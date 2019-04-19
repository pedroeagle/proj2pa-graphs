package model;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.BasicEdgeRenderer;
import edu.uci.ics.jung.visualization.renderers.GradientVertexRenderer;
import edu.uci.ics.jung.visualization.renderers.VertexLabelAsShapeRenderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;
import org.apache.commons.collections15.Predicate;
import edu.uci.ics.jung.graph.util.Pair;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;
import edu.uci.ics.jung.visualization.decorators.AbstractVertexShapeTransformer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Vector;

public class ViewGraph extends javax.swing.JPanel{
    protected static VertexShapeSizeAspect<Integer,Number> vssa;
    public ViewGraph() {

    }

    public static void createAndShowGUI(ArrayList<Vector<model.Pair>> myGraph) {
        JFrame f = new JFrame("Seu grafo");
        if(f!=null){
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocation(450, 250);
        }

        Graph<String, String> g = converteGraph(myGraph);

        Dimension size = new Dimension(600, 600);
        VisualizationViewer<String, String> vv =
                new VisualizationViewer<String, String>(
                        new FRLayout<String, String>(g, size));
        DefaultModalGraphMouse<String, Double> graphMouse =
                new DefaultModalGraphMouse<String, Double>();
        vv.setGraphMouse(graphMouse);

        improvePerformance(vv);

        f.getContentPane().add(vv);
        f.setSize(size);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    // This method summarizes several options for improving the painting
    // performance. Enable or disable them depending on which visual features
    // you want to sacrifice for the higher performance.
    private static <V, E> void improvePerformance(
            VisualizationViewer<V, E> vv) {
        // Probably the most important step for the pure rendering performance:
        // Disable anti-aliasing
        vv.getRenderingHints().remove(RenderingHints.KEY_ANTIALIASING);

        // Skip vertices that are not inside the visible area.
        doNotPaintInvisibleVertices(vv);

        // May be helpful for performance in general, but not appropriate
        // when there are multiple edges between a pair of nodes: Draw
        // the edges not as curves, but as straight lines:
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<V, E>());

        VertexLabelAsShapeRenderer<Integer, Number> vlasr = new VertexLabelAsShapeRenderer<Integer, Number>((RenderContext<Integer, Number>) vv.getRenderContext());

        vv.getRenderer().setVertexRenderer((edu.uci.ics.jung.visualization.renderers.Renderer.Vertex<V, E>) new GradientVertexRenderer<Integer, Number>( new Color(175,224,228), new Color(133,170,173), true));
        vv.getRenderer().setVertexLabelRenderer((edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel<V, E>) vlasr);

        vv.getRenderContext().setVertexLabelTransformer((Transformer<V, String>) new ToStringLabeller<Integer>());

        vssa = new VertexShapeSizeAspect<Integer,Number>();
        vv.getRenderContext().setVertexShapeTransformer((Transformer<V, Shape>) vssa);

        vv.getRenderContext().setArrowFillPaintTransformer(new ConstantTransformer(Color.lightGray));
        vv.getRenderContext().setArrowDrawPaintTransformer(new ConstantTransformer(Color.black));

        // May be helpful for painting performance: Omit the arrow heads
        // of directed edges
        Predicate<Context<Graph<V, E>, E>> edgeArrowPredicate =
                new Predicate<Context<Graph<V, E>, E>>() {
                    @Override
                    public boolean evaluate(Context<Graph<V, E>, E> arg0) {
                        return false;
                    }
                };
        vv.getRenderContext().setEdgeArrowPredicate(edgeArrowPredicate);

    }

    // Skip all vertices that are not in the visible area.
    // NOTE: See notes at the end of this method!
    private static <V, E> void doNotPaintInvisibleVertices(
            VisualizationViewer<V, E> vv) {
        Predicate<Context<Graph<V, E>, V>> vertexIncludePredicate =
                new Predicate<Context<Graph<V, E>, V>>() {
                    Dimension size = new Dimension();

                    @Override
                    public boolean evaluate(Context<Graph<V, E>, V> c) {
                        vv.getSize(size);
                        Point2D point = vv.getGraphLayout().transform(c.element);
                        Point2D transformed =
                                vv.getRenderContext().getMultiLayerTransformer()
                                        .transform(point);
                        if (transformed.getX() < 0 || transformed.getX() > size.width) {
                            return false;
                        }
                        if (transformed.getY() < 0 || transformed.getY() > size.height) {
                            return false;
                        }
                        return true;
                    }
                };
        vv.getRenderContext().setVertexIncludePredicate(vertexIncludePredicate);

        // NOTE: By default, edges will NOT be included in the visualization
        // when ONE of their vertices is NOT included in the visualization.
        // This may look a bit odd when zooming and panning over the graph.
        // Calling the following method will cause the edges to be skipped
        // ONLY when BOTH their vertices are NOT included in the visualization,
        // which may look nicer and more intuitive
        doPaintEdgesAtLeastOneVertexIsVisible(vv);
    }

    // See note at end of "doNotPaintInvisibleVertices"
    private static <V, E> void doPaintEdgesAtLeastOneVertexIsVisible(
            VisualizationViewer<V, E> vv) {
        vv.getRenderer().setEdgeRenderer(new BasicEdgeRenderer<V, E>() {
            @Override
            public void paintEdge(RenderContext<V, E> rc, Layout<V, E> layout, E e) {
                GraphicsDecorator g2d = rc.getGraphicsContext();
                Graph<V, E> graph = layout.getGraph();
                if (!rc.getEdgeIncludePredicate().evaluate(
                        Context.<Graph<V, E>, E>getInstance(graph, e)))
                    return;

                Pair<V> endpoints = graph.getEndpoints(e);
                V v1 = endpoints.getFirst();
                V v2 = endpoints.getSecond();
                if (!rc.getVertexIncludePredicate().evaluate(
                        Context.<Graph<V, E>, V>getInstance(graph, v1)) &&
                        !rc.getVertexIncludePredicate().evaluate(
                                Context.<Graph<V, E>, V>getInstance(graph, v2)))
                    return;

                Stroke new_stroke = rc.getEdgeStrokeTransformer().transform(e);
                Stroke old_stroke = g2d.getStroke();
                if (new_stroke != null)
                    g2d.setStroke(new_stroke);

                drawSimpleEdge(rc, layout, e);

                // restore paint and stroke
                if (new_stroke != null)
                    g2d.setStroke(old_stroke);
            }
        });

    }

    public static Graph<String, String> converteGraph(ArrayList<Vector<model.Pair>> myGraph)
    {
        Graph<String, String> g = new DirectedSparseGraph<String, String>();
        for(int i=0; i<myGraph.size(); ++i){
            g.addVertex(Integer.toString(i));
            for(int j=0; j< myGraph.get(i).size(); ++j){
                model.Pair verticeVizinho = myGraph.get(i).get(j);

                g.addEdge("e"+ i+" "+j, Integer.toString(i), Integer.toString(verticeVizinho.getFirst()));
            }
        }
        return g;
    }
    private final static class VertexShapeSizeAspect<V,E>  extends AbstractVertexShapeTransformer <V> implements Transformer<V,Shape> {

        public VertexShapeSizeAspect() {
            setSizeTransformer(new Transformer<V, Integer>() {
                public Integer transform(V v) {
                    return 25;
                }
            });
            setAspectRatioTransformer(new Transformer<V, Float>() {
                public Float transform(V v) {
                    return 1.0f;
                }
            });
        }

        public Shape transform(V v) {
            return factory.getEllipse(v);
        }
    }
}

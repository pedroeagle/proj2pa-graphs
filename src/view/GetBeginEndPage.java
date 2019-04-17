package view;

import model.BreadthFirstSearch;
import model.DeepingFirstSearch;
import model.Dijkstra;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static model.Main.grafo;

public class GetBeginEndPage {
    private JPanel getBeginEndPanel;
    private JTextField fimGetIn;
    private JButton proximoGetButton;
    private JLabel inicioGetText;
    private JLabel fimGetText;
    private JTextField inicioGetIn;
    public static Integer[] inicioFim = new Integer[2];
    private static String result;

    public GetBeginEndPage(int algorithm){

        JFrame getBeginEndPage = new JFrame("Defina o início/fim");
        if(getBeginEndPage!=null) {
            getBeginEndPage.setContentPane(getBeginEndPanel);
            getBeginEndPage.setLocation(450, 250);
        }
        getBeginEndPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getBeginEndPage.pack();
        getBeginEndPage.setVisible(true);
        switch (algorithm) {
            case 0:
                try {
                    proximoGetButton.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            inicioFim[0] = Integer.valueOf(inicioGetIn.getText());
                            inicioFim[1] = Integer.valueOf(fimGetIn.getText());
                            BreadthFirstSearch b = new BreadthFirstSearch(grafo, grafo.size());
                            result = b.BFS(inicioFim[0], inicioFim[1]);
                            new resultPage(result);
                            getBeginEndPage.dispose();
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                } catch (Exception error) {
                    new GetBeginEndPage(0);
                }
                break;
            case 1:
                try {
                    proximoGetButton.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            inicioFim[0] = Integer.valueOf(inicioGetIn.getText());
                            inicioFim[1] = Integer.valueOf(fimGetIn.getText());
                            DeepingFirstSearch d = new DeepingFirstSearch(grafo, grafo.size());
                            result = d.DFS(inicioFim[0], inicioFim[1]);
                            new resultPage(result);
                            getBeginEndPage.dispose();
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                } catch (Exception error) {
                    new GetBeginEndPage(1);
                }
                break;
            case 2:
                try {
                    proximoGetButton.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            inicioFim[0] = Integer.valueOf(inicioGetIn.getText());
                            inicioFim[1] = Integer.valueOf(fimGetIn.getText());
                            Dijkstra dij = new Dijkstra(grafo, grafo.size());
                            result = dij.ssspDijkstra(inicioFim[0], inicioFim[1]);
                            getBeginEndPage.dispose();
                            new resultPage(result);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                } catch (Exception error) {
                    new GetBeginEndPage(2);
                }
                break;
        }


    }
}

package model;

import java.util.ArrayList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		ArrayList<Vector<Pair>> grafo = new ArrayList<Vector<Pair>>();
		int verticeInicial = 0;
		int verticeDestino = 5;
		for(int i=0; i<8; ++i) {
			grafo.add(new Vector<Pair>());
		}

		grafo.get(0).add(new Pair(1, 1));
		grafo.get(0).add(new Pair(3, 1));
		grafo.get(0).add(new Pair(7, 1));
		grafo.get(0).add(new Pair(2, 1));
		
		grafo.get(1).add(new Pair(7, 1));
		grafo.get(1).add(new Pair(2, 1));
		grafo.get(1).add(new Pair(3, 1));
		grafo.get(1).add(new Pair(6, 1));
		grafo.get(1).add(new Pair(4, 1));

		grafo.get(2).add(new Pair(6, 1));
		grafo.get(2).add(new Pair(4, 1));
		grafo.get(2).add(new Pair(5, 1));
		
		grafo.get(3).add(new Pair(7, 1));
		grafo.get(3).add(new Pair(4, 1));
		grafo.get(4).add(new Pair(6, 1));
		grafo.get(5).add(new Pair(7, 1));
		grafo.get(6).add(new Pair(7, 1));
		ArrayList<Vector<Pair>> grafo2 = grafo;
		BreadthFirstSearch b = new BreadthFirstSearch(grafo2, 8);
		b.BFS(verticeInicial, verticeDestino);
		Dijkstra dijkstra = new Dijkstra(grafo, 8);
		dijkstra.ssspDijkstra(verticeInicial, verticeDestino);
		DeepingFirstSearch d = new DeepingFirstSearch(grafo, 8);
		d.DFS(verticeInicial);
	}

}

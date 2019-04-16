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

		grafo.get(0).add(new Pair(1, 3));
		grafo.get(0).add(new Pair(3, 2));
		grafo.get(0).add(new Pair(7, 10));
		grafo.get(0).add(new Pair(2, 5));
		
		grafo.get(1).add(new Pair(7, 6));
		grafo.get(1).add(new Pair(2, 5));
		grafo.get(1).add(new Pair(3, 8));
		grafo.get(1).add(new Pair(6, 6));
		grafo.get(1).add(new Pair(4, 4));

		grafo.get(2).add(new Pair(6, 9));
		grafo.get(2).add(new Pair(4, 1));
		grafo.get(2).add(new Pair(5, 7));
		
		grafo.get(3).add(new Pair(7, 14));
		grafo.get(3).add(new Pair(4, 12));
		grafo.get(4).add(new Pair(6, 15));
		grafo.get(5).add(new Pair(7, 9));
		grafo.get(6).add(new Pair(7, 3));

		BreadthFirstSearch b = new BreadthFirstSearch(grafo, 8);
		b.BFS(verticeInicial, 3);
		Dijkstra dijkstra = new Dijkstra(grafo, 8);
		dijkstra.ssspDijkstra(verticeInicial, verticeDestino);
		DeepingFirstSearch d = new DeepingFirstSearch(grafo, 8);
		d.DFS(verticeInicial);
	}

}

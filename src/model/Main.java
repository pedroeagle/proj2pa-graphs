package model;

import view.MainPage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {



		/*int verticeInicial = 0;
		int verticeDestino = 7;
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
		ArrayList<Vector<Pair>> grafo2 = grafo;
		String []caminhos = new String[3];
		System.out.println("---------BFS----------");
		BreadthFirstSearch b = new BreadthFirstSearch(grafo2, 8);
		caminhos[0] = b.BFS(verticeInicial, verticeDestino);
		System.out.println("---------DJS----------");
		Dijkstra dijkstra = new Dijkstra(grafo, 8);
		caminhos[1] = dijkstra.ssspDijkstra(verticeInicial, verticeDestino);
		System.out.println("---------DFS----------");
		DeepingFirstSearch d = new DeepingFirstSearch(grafo, 8);
		caminhos[2] = d.DFS(verticeInicial, verticeDestino);
		System.out.println(caminhos[0] + caminhos[1] + caminhos[2]);*/
		new MainPage();
	}
	public static ArrayList<Vector<Pair>> grafo = new ArrayList<Vector<Pair>>();
	public static void RandomGraphGenerate(){
		int size = new Random().nextInt(50)+50;
		for(int i = 0; i < size; i++){
			grafo.add(new Vector<Pair>());
			int edges = new Random().nextInt()%(size*size);
			for(int j = 0; j < edges; j++){
				int vertex = new Random().nextInt(50)+50;
				int weight = 0;
				while(weight==0){
					weight = new Random().nextInt(50)+50;
				}
				grafo.get(i).add(new Pair(vertex, weight));
			}
		}
	}

}

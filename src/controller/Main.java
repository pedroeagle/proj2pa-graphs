package controller;

import view.MainPage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		new MainPage();
	}
	public static ArrayList<Vector<Pair>> grafo = new ArrayList<Vector<Pair>>();
	public static void RandomGraphGenerate(){
		grafo.clear();
		int size = Math.abs(new Random().nextInt())%101;
		for(int i = 0; i < size; i++){
			grafo.add(new Vector<Pair>());
			int edges = Math.abs(new Random().nextInt(size))%101;
			for(int j = 0; j < edges; j++){
				Integer vertex = Math.abs(new Random().nextInt(size))%101;
				Integer weight = 0;
				while(weight==0){
					weight = Math.abs(new Random().nextInt())%101;
				}
				grafo.get(i).add(new Pair(vertex, weight));
			}
		}
	}

}
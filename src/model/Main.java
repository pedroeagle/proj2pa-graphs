package model;

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
		int size = new Random().nextInt(50)+50;
		for(int i = 0; i < size; i++){
			grafo.add(new Vector<Pair>());
			int edges = new Random().nextInt((size)/2)+(size)/2;
			for(int j = 0; j < edges; j++){
				Integer vertex = new Random().nextInt(size/2)+size/2;
				Integer weight = 0;
				while(weight==0){
					weight = new Random().nextInt(50)+50;
				}
				grafo.get(i).add(new Pair(vertex, weight));
			}
		}
	}

}
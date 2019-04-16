package model;

import java.util.*;

public class DeepingFirstSearch {
    private ArrayList<Vector<Pair>> grafo;
	private Vector<Integer> verticesVerificados;
    private Boolean []verticesVisitados;
    private Integer []distancias;
    private Integer []pesos;
    private Integer []verticePai;

    public DeepingFirstSearch(ArrayList<Vector<Pair>> grafo, int quantidadeDeNos) {
        this.grafo = grafo;
        verticesVisitados = new Boolean[100000];
		verticesVerificados = new Vector<Integer>();
        pesos = new Integer[100000];
        verticePai = new Integer[100000];
        distancias = new Integer[100000];
        for(int i=0; i< quantidadeDeNos+10; ++i) {
            distancias[i] = -1;
            verticePai[i] = -1;
            pesos[i] = 0;
            verticesVisitados[i] = false;
        }
    }


    public int DFS(Integer inicio, Integer destino){
        Stack<Triplet> paraVisitar = new Stack<>();
        verticesVisitados[inicio] = true;
        distancias[inicio] = 0;
        verticePai[inicio] = inicio;
        paraVisitar.add(new Triplet(inicio, 0, inicio));
        while(!paraVisitar.isEmpty()){
        	verticesVerificados.add(paraVisitar.peek().getFirst());
        	Triplet verticeAtual = paraVisitar.pop();
        	mostrarSequenciaDeNos();
            for(Pair verticeVizinho : grafo.get(verticeAtual.getFirst())){
                if(verticesVisitados[verticeVizinho.getFirst()] == false) {
                    System.out.println(verticeAtual.getFirst() + " ---> " + verticeVizinho.getFirst());
                    paraVisitar.add(new Triplet(verticeVizinho.getFirst(), 
                    		verticeAtual.getSecond()+1, verticeAtual.getFirst()));
                    verticesVisitados[verticeVizinho.getFirst()] = true;
                    verticePai[verticeVizinho.getFirst()] = verticeAtual.getFirst();
                    distancias[verticeVizinho.getFirst()] = verticeAtual.getSecond()+1;
                    pesos[verticeVizinho.getFirst()] = verticeVizinho.getSecond();
                }
            }
            if(!paraVisitar.isEmpty()) {
            	paraVisitar = printaFila(paraVisitar);
            }
        }
        
        if(verticesVisitados[destino]==true) {
        	return 1;
        } 	
        else {
        	return 0;
        }
    }
    
    private Stack<Triplet> printaFila(Stack<Triplet> paraVisitar) {
		Stack<Triplet> paraVisitarClone =
				new Stack<>();
		System.out.print("------------------\n"
				+ "   Fila atual\n"
				+ "dist vert (pai)\n");
		
	    while(!paraVisitar.isEmpty()){
	    	Triplet vertice = paraVisitar.peek();
	    	paraVisitarClone.add(paraVisitar.pop());
	        System.out.printf(" %02d   %02d  (%02d)\n", vertice.getSecond(),
	        		vertice.getFirst(), vertice.getThird());
	    }
	    System.out.print("------------------\n");
	    return paraVisitarClone;
	}
    
    private void mostrarSequenciaDeNos() {
		System.out.print("\nSequencia atual de vértices:\n");
	    System.out.print(verticesVerificados.get(0));
	    Boolean first = true;
	    for(Integer vertice : verticesVerificados){
	        if(first){
	            first = false;
	            continue;
	        }
	        System.out.printf(" -> %d", vertice);
	    }
	    System.out.println("\n");
	}
}

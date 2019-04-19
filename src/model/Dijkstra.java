package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class Dijkstra {
	private Set<Integer> verticesVisitados;
	private ArrayList<Vector<Pair>> grafo;
	private Vector<Integer> verticesVerificados;
	private Integer []distancias;
	private Integer []pesos;
	private Integer []verticePai;
	
	public Dijkstra(ArrayList<Vector<Pair>> grafo, int quantidadeDeNos) {
		this.grafo = grafo;
		verticesVisitados = new HashSet<Integer>();
		verticesVerificados = new Vector<Integer>();
		distancias = new Integer[100000];
		pesos = new Integer[100000];
		verticePai = new Integer[100000];
		for(int i=0; i< quantidadeDeNos+10; ++i) {
			distancias[i] = 100000;
			verticePai[i] = -1;
			pesos[i] = 0;
		}
	}

	public String ssspDijkstra(Integer inicio, Integer destino) {
	    PriorityQueue<Triplet> paraVisitar = 
	    		new PriorityQueue<Triplet>(new TripletComparator());

	    distancias[inicio] = 0;
	    verticePai[inicio] = inicio;
	    pesos[inicio] = 0;
	    paraVisitar.offer(new Triplet(distancias[inicio], inicio, inicio));
	    
	    while(!paraVisitar.isEmpty()) {
	        // Distancia d :: Veritice v
	        Integer verticeAtual = paraVisitar.peek().getSecond();
	        Integer distanciaAtual = paraVisitar.peek().getFirst();
	        paraVisitar.poll();

	        // Caso a distancia seja maior do que a distancia já registrada
	        if (distanciaAtual > distancias[verticeAtual]){
	            continue;  
	        } 

	        verticesVerificados.add(verticeAtual);
	        verticesVisitados.add(verticeAtual);
	        mostrarSequenciaDeNos();
	        if(verticesVerificados.contains(destino) == true){
	        	System.out.println("Caminho gerado!!!");
				String caminhoInicioDestinoPeso = gerarCaminho(inicio,  destino);
				return caminhoInicioDestinoPeso;
			}

	        for(Pair vertice : grafo.get(verticeAtual)) {
	        	Integer vizinhoDoVerticeAtual = vertice.getFirst();
	        	Integer distanciaVizinhoDoVerticeAtual = vertice.getSecond();
	            System.out.println("Caminhos possíveis: " + verticeAtual + " -> " + vizinhoDoVerticeAtual);
	        	//cout << "Possible path: " << v << " -> " << i_v << endl;

	            if (distancias[verticeAtual] + distanciaVizinhoDoVerticeAtual < 
	            		distancias[vizinhoDoVerticeAtual]) {
	                
	            	distancias[vizinhoDoVerticeAtual] = distancias[verticeAtual] + 
	            			distanciaVizinhoDoVerticeAtual;
	                verticePai[vizinhoDoVerticeAtual] = verticeAtual;
	                pesos[vizinhoDoVerticeAtual] = distanciaVizinhoDoVerticeAtual;
	                paraVisitar.add(new Triplet(distancias[vizinhoDoVerticeAtual], 
	                		vizinhoDoVerticeAtual, verticeAtual));
	            }
	        }
	        paraVisitar = removeVerticesRepetidos(paraVisitar);
	        if(!paraVisitar.isEmpty()){
	            paraVisitar = printaFila(paraVisitar);
	            System.out.print("Caminho escolhido: " + 
	            verticePai[paraVisitar.peek().getSecond().intValue()]
	            		+ " -> " + paraVisitar.peek().getSecond());
	        }else{
	           System.out.println("\nNenhum caminho escolhido.\nSem opções restantes.");
	        }
	    }
	    
	    if(verticesVisitados.contains(destino)==true) {
	    	String caminhoInicioDestinoPeso = gerarCaminho(inicio,  destino);
	    	return caminhoInicioDestinoPeso;
	    }
	    else {
	    	return "Não há conexão entre esses dois vértices";
	    }
	}

	private String gerarCaminho(Integer inicio, Integer destino) {
		String caminhoInicioDestinoPeso = new String();
		caminhoInicioDestinoPeso += "<html>Caminho encontrado pelo Dijkstra:		<br>";
		Stack<Integer> caminhoInicioDestino = new Stack<>();
		caminhoInicioDestino.add(destino);
		int verticeAtual = destino;
		while(true){
			if(verticePai[verticeAtual] != caminhoInicioDestino.peek() && 
					verticePai[verticeAtual] != -1){
			    caminhoInicioDestino.add(verticePai[verticeAtual]);
			    verticeAtual = verticePai[verticeAtual];
			}
			else{
				break;
			}
		}
		int pesoDoCaminho = 0;
		pesoDoCaminho += pesos[caminhoInicioDestino.peek()];
		caminhoInicioDestinoPeso += caminhoInicioDestino.pop();
	    while(!caminhoInicioDestino.isEmpty()){
	    	caminhoInicioDestinoPeso+= " -> " + caminhoInicioDestino.peek();
	        pesoDoCaminho += pesos[caminhoInicioDestino.pop()];	     
	    }
	    caminhoInicioDestinoPeso+="<br>";
	    caminhoInicioDestinoPeso += "Distância total: " + pesoDoCaminho + "<br>";
	    caminhoInicioDestinoPeso+="</html>";
	    return caminhoInicioDestinoPeso;
	}

	private PriorityQueue<Triplet> printaFila(PriorityQueue<Triplet> paraVisitar) {
		PriorityQueue<Triplet> paraVisitarClone =
				new PriorityQueue<Triplet>(new TripletComparator());
		System.out.print("------------------\n"
				+ "   Heap atual\n"
				+ "dist vert (pai)\n");
		
	    while(!paraVisitar.isEmpty()){
	    	Triplet vertice = paraVisitar.peek();
	    	paraVisitarClone.add(paraVisitar.poll());
	        System.out.printf(" %02d   %02d  (%02d)\n", vertice.getFirst(),
	        		vertice.getSecond(), vertice.getThird());
	    }
	    System.out.print("------------------\n");
	    return paraVisitarClone;
	}

	private PriorityQueue<Triplet> removeVerticesRepetidos(
			PriorityQueue<Triplet> paraVisitar) {
		int _tamanho = paraVisitar.size();
		PriorityQueue<Triplet> paraVisitarAtualizado = 
				new PriorityQueue<Triplet>(new TripletComparator());
	    for(int i=0; i<_tamanho; ++i){
	        if(verticesVisitados.contains(paraVisitar.peek().getSecond())){
	            paraVisitar.poll();
	        }
	        else{
	            paraVisitarAtualizado.add(paraVisitar.poll());
	        }
	    }
		return paraVisitarAtualizado;
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

 
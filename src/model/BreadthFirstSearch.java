package model;

import java.util.*;

public class BreadthFirstSearch {
    private Set<Integer> verticesVisitados;
    private ArrayList<Vector<Pair>> grafo;
    private Vector<Integer> verticesVerificados;
    private Integer []distancias;
    private Integer []pesos;
    private Integer []verticePai;
    private int quantidadeDeNos;

    public BreadthFirstSearch(ArrayList<Vector<Pair>> grafo, int quantidadeDeNos) {
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


    public int BFS(Integer inicio, Integer destino){
        ArrayList<Integer> paraVisitar = new ArrayList<>();
        ArrayList<Integer> visitados = new ArrayList<>();
        paraVisitar.add(inicio);
        int path = 0;
        while(!paraVisitar.isEmpty()){
            for(int i = 0; i < grafo.get(inicio).size(); i++){
                if(!visitados.contains(grafo.get(inicio).get(i).getFirst())) {
                    System.out.println(inicio + " ---> " + grafo.get(inicio).get(i).getFirst());
                    if(!paraVisitar.contains(grafo.get(inicio).get(i).getFirst())) {
                        paraVisitar.add(grafo.get(inicio).get(i).getFirst());
                    }
                }
            }
            visitados.add(inicio);
            System.out.println("visitados "+visitados);
            System.out.println("paraVisitar "+paraVisitar);
            paraVisitar.remove(inicio);
            inicio = paraVisitar.get(0);
            paraVisitar.remove(0);
            while(visitados.contains(inicio)){
                inicio = paraVisitar.get(0);
                paraVisitar.remove(0);
            }
            if (!visitados.contains(destino)){
                path++;
            }
            else{
                return path;
            }
            System.out.println("path: "+path);
        }

        return path;
    }
}

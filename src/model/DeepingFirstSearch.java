package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class DeepingFirstSearch {
    private Set<Integer> verticesVisitados;
    private ArrayList<Vector<Pair>> grafo;
    private Vector<Integer> verticesVerificados;
    private Integer []distancias;
    private Integer []pesos;
    private Integer []verticePai;
    private int quantidadeDeNos;
    private ArrayList<Integer> arvore = new ArrayList<>();

    ArrayList<Integer> paraVisitar = new ArrayList<>();
    ArrayList<Integer> visitados = new ArrayList<>();
    public DeepingFirstSearch(ArrayList<Vector<Pair>> grafo, int quantidadeDeNos) {
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
    public int DFS(Integer inicio){

        for(int i = 0; i < grafo.size(); i++) {
            if (!verticesVisitados.contains(inicio)){
                DFSVisit(inicio);
            }
            else{
                inicio = grafo.get(i).firstElement().getFirst();
            }
        }
        return 0;
    }
    public void DFSVisit(Integer inicio){
        if(!visitados.contains(inicio)) {
            visitados.add(inicio);
        }
        System.out.println("visitados: " + visitados);
        for(int i = 0; i < grafo.get(inicio).size(); i++){
            if(!visitados.contains(grafo.get(inicio).get(i).getFirst())) {
                arvore.add(inicio);
                DFSVisit(grafo.get(inicio).get(i).getFirst());
                System.out.println(arvore);
            }

        }

    }

}

package Grafo;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
    public Map<Integer, Vertice> vertices;    
    public Map<Integer, Aresta> arestas;

    public Grafo() {
        this.vertices = new HashMap<>();
        this.arestas = new HashMap<>();
    }

    public void adicionarVertice(Vertice vertice) {
        if (!vertices.containsKey(vertice.cod_vertice)) {
            vertice.Add(vertice);
            vertices.put(vertice.cod_vertice, vertice);
        }
    }

    public void adicionarAresta(Aresta aresta) {       
        if (!arestas.containsKey(aresta.cod_aresta)) {
            aresta.Add(aresta);
            arestas.put(aresta.cod_aresta, aresta);
        }
    }
    
    public void listaVertices(){ 
        System.out.println("VERTICES:");
        for (Integer key: vertices.keySet()) {
            System.out.print("Key : " + key);
            System.out.print(" Codigo : " + vertices.get(key).cod_vertice);
            System.out.println(" Value : " + vertices.get(key).ver_nome);
        }
    }
    
    public void listaArestas(){    
        System.out.println("ARESTAS:");
        for (Integer key: arestas.keySet()) {
            System.out.print("Key : " + key);
            System.out.print(" Origem : " + arestas.get(key).are_origem);
            System.out.print(" Destino : " + arestas.get(key).are_destino);
            System.out.println(" Value : " + arestas.get(key).are_distancia);
        }
    }
}

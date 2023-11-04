package Grafo;

import FaindMap.api.Arestas.Aresta;
import FaindMap.api.Vertice.Vertice;
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
        if (!vertices.containsKey(vertice.getId_vertice())) {
            vertice.Add(vertice);
            vertices.put(vertice.getId_vertice(), vertice);
        }
    }

    public void adicionarAresta(Aresta aresta) {       
        if (!arestas.containsKey(aresta.getId_aresta())) {
            aresta.Add(aresta);
            arestas.put(aresta.getId_aresta(), aresta);
        }
    }
    
    public void listaVertices(){ 
        System.out.println("VERTICES:");
        for (Integer key: vertices.keySet()) {
            System.out.print("Key : " + key);
            System.out.print(" Codigo : " + vertices.get(key).getId_vertice());
            System.out.println(" Value : " + vertices.get(key).getNome());
        }
    }
    
    public void listaArestas(){    
        System.out.println("ARESTAS:");
        for (Integer key: arestas.keySet()) {
            System.out.print("Key : " + key);
            System.out.print(" Origem : " + arestas.get(key).getId_vertice_origem().getId_vertice());
            System.out.print(" Destino : " + arestas.get(key).getId_vertice_destino().getId_vertice());
            System.out.println(" Value : " + arestas.get(key).getDistancia());
        }
    }
}

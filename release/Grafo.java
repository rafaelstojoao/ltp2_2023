/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package release;

import com.mycompany.faindmap.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Guilherme Cezarine
 */
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
        
        System.out.println("\n\tVERTICES:\n");
        for (Integer key: vertices.keySet()) {
            System.out.print("key : " + key);
            System.out.print(" codigo : " + vertices.get(key).cod_vertice);
            System.out.println(" value : " + vertices.get(key).ver_nome);
        }
    }
    
        public void listaArestas(){
        
        System.out.println("\n\tARESTAS:\n");
        for (Integer key: arestas.keySet()) {
            System.out.print("key : " + key);
            System.out.print(" Origem : " + arestas.get(key).are_origem);
            System.out.print(" Destino : " + arestas.get(key).are_destino);
            System.out.println(" value : " + arestas.get(key).are_distancia);


        }
    }

}

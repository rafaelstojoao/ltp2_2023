/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

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

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public void adicionarVertice(Vertice vertice) {
        if (!vertices.containsKey(vertice.cod_vertice)) {
            vertice.Add(vertice);
            vertices.put(vertice.cod_vertice, vertice);
        }
    }

    public void adicionarAresta(Aresta aresta) {
        Vertice verticeOrigem = vertices.get(aresta.are_origem);
        Vertice verticeDestino = vertices.get(aresta.are_destino);

        if (verticeOrigem != null && verticeDestino != null) {
            verticeOrigem.adicionarAresta(verticeDestino, aresta.are_distancia);
        }
    }

    public double dijkstra(int inicio, int fim) {
        double distancias = 0.00;
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(Vertice::getDistancia));
        
        Vertice verticeInicial = vertices.get(inicio);
        
        if (verticeInicial != null) {
            for (Vertice vertice : vertices.values()) {
                vertice.setDistancia(Integer.MAX_VALUE);
            }
            
            verticeInicial.setDistancia(0);
            filaPrioridade.add(verticeInicial);
            
            while (!filaPrioridade.isEmpty()) {
                Vertice verticeAtual = filaPrioridade.poll();
                for (Map.Entry<Vertice, Double> vizinho : verticeAtual.getVizinhos().entrySet()) {
                    Vertice v = vizinho.getKey();
                    double novaDistancia = verticeAtual.getDistancia() + vizinho.getValue();
                    if (novaDistancia < v.getDistancia()) {
                        v.setDistancia(novaDistancia);
                        filaPrioridade.add(v);
                    }
                }
            }
            
            for (Vertice vertice : vertices.values()) {
                if (vertice.cod_vertice == fim) {
                    distancias = vertice.getDistancia();
                } 
            }
        }
        
        return distancias;
    }
    
    
    public Map<Integer, Double> dijkstra(int inicio) {
        Map<Integer, Double> distancias = new HashMap<>();
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(Vertice::getDistancia));
        
        Vertice verticeInicial = vertices.get(inicio);
        
        if (verticeInicial != null) {
            for (Vertice vertice : vertices.values()) {
                vertice.setDistancia(Integer.MAX_VALUE);
            }
            
            verticeInicial.setDistancia(0);
            filaPrioridade.add(verticeInicial);
            
            while (!filaPrioridade.isEmpty()) {
                Vertice verticeAtual = filaPrioridade.poll();
                for (Map.Entry<Vertice, Double> vizinho : verticeAtual.getVizinhos().entrySet()) {
                    Vertice v = vizinho.getKey();
                    double novaDistancia = verticeAtual.getDistancia() + vizinho.getValue();
                    if (novaDistancia < v.getDistancia()) {
                        v.setDistancia(novaDistancia);
                        filaPrioridade.add(v);
                    }
                }
            }
            
            for (Vertice vertice : vertices.values()) {
                distancias.put(vertice.getCodVertice(), vertice.getDistancia());
            }
        }
        
        return distancias;
    }
}

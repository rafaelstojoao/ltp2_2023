/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Cezarine
 */
 class Vertice implements Comparable<Vertice> {
     
    public int cod_campos;
    public String ver_nome;
    public int cod_bloco;
    public int cod_andar;
    public int cod_vertice;
    public double peso;
    private Map<Vertice, Double> vizinhos;

    public void Add(Vertice vertice) {
        this.cod_vertice = vertice.cod_vertice;
        this.vizinhos = new HashMap<>();
        this.peso = Integer.MAX_VALUE;
        
        this.cod_campos = vertice.cod_campos;
        this.cod_andar = vertice.cod_andar;
        this.cod_bloco = vertice.cod_bloco;
        this.ver_nome = vertice.ver_nome;
    }

    public void adicionarAresta(Vertice vizinho, double peso) {
        vizinhos.put(vizinho, peso);
    }

    public int getCodVertice() {
        return cod_vertice;
    }

    public Map<Vertice, Double> getVizinhos() {
        return vizinhos;
    }

    public double getDistancia() {
        return peso;
    }

    public void setDistancia(double distancia) {
        this.peso = distancia;
    }

    @Override
    public int compareTo(Vertice outro) {
        return Double.compare(peso, outro.peso);
    }
}

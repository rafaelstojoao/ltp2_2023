/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Cezarine
 */
 public class Vertice implements Comparable<Vertice> {
     
    private int cod_campos;
    private String ver_nome;
    private int cod_bloco;
    private int cod_andar;
    private int cod_vertice;
    private int ver_numero_sala;
    public GeoLoc ver_coordenadas;
    private Status ver_status;
    
    private double peso;  
    private Map<Integer, Aresta> arestas;
    private Map<Vertice, Double> vizinhos;

    public int getCod_campos() {
        return cod_campos;
    }

    public String getVer_nome() {
        return ver_nome;
    }

    public int getCod_bloco() {
        return cod_bloco;
    }

    public int getCod_andar() {
        return cod_andar;
    }

    public int getCod_vertice() {
        return cod_vertice;
    }

    public int getVer_numero_sala() {
        return ver_numero_sala;
    }

    public Status getVer_status() {
        return ver_status;
    }

    public double getPeso() {
        return peso;
    }

    public Map<Integer, Aresta> getArestas() {
        return arestas;
    }

    public void setCod_campos(int cod_campos) {
        this.cod_campos = cod_campos;
    }

    public void setVer_nome(String ver_nome) {
        this.ver_nome = ver_nome;
    }

    public void setCod_bloco(int cod_bloco) {
        this.cod_bloco = cod_bloco;
    }

    public void setCod_andar(int cod_andar) {
        this.cod_andar = cod_andar;
    }

    public void setCod_vertice(int cod_vertice) {
        this.cod_vertice = cod_vertice;
    }

    public void setVer_numero_sala(int ver_numero_sala) {
        this.ver_numero_sala = ver_numero_sala;
    }

    public void setVer_status(Status ver_status) {
        this.ver_status = ver_status;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setArestas(Map<Integer, Aresta> arestas) {
        this.arestas = arestas;
    }
    
    public void Add(Vertice vertice) {
        this.cod_vertice = vertice.cod_vertice;
        this.vizinhos = new HashMap<>();
        this.peso = Integer.MAX_VALUE;
        
        this.cod_campos = vertice.cod_campos;
        this.cod_andar = vertice.cod_andar;
        this.cod_bloco = vertice.cod_bloco;
        this.ver_nome = vertice.ver_nome;
    }

    public void setCoordenadas(double ALongitude, double ALatitude, double AAltitude){
        ver_coordenadas.Longitude= ALongitude;
        ver_coordenadas.Latitude = ALatitude;
        ver_coordenadas.Altitude = AAltitude;
    }
    
    public void adicionarAresta(Aresta aresta, Vertice vizinho, double peso) {
        vizinhos.put(vizinho, peso);
        arestas.put(aresta.are_origem, aresta);
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

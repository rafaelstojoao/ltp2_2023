/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.Random;

public class Aresta {   
    private Vertice Origem;
    private Vertice Destino;
    private Direcao Direcao ;
    private Double Distancia;
    private final int Id;
    
    public Aresta(){
        Random r = new Random();
        this.Id = r.nextInt();
    }
    
    public int RetornaID(){
        return Id;
    }
    
    public Double RetornaDistancia(){
        return Distancia;
    }
    
    public Direcao RetornaDirecao(){
        return Direcao;
    }
    
    public Vertice RetornaDestino(){
        return Destino;
    }
    
    public Vertice RetornaOrigem(){
        return Origem;
    }
    
    public void MudaDistancia(Double distancia){
        this.Distancia = distancia;
    }
    
    public void MudaDirecao(Direcao direcao){
        this.Direcao = direcao;
    }
    
    public void MudaDestino(Vertice destino){
        this.Destino = destino;
    }
    
    public void MudaOrigem(Vertice origem){
        this.Origem = origem;
    }
}

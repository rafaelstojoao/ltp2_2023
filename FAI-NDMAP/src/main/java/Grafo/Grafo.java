/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;

public class Grafo { 
    public ArrayList<Vertice> vertices;
    public ArrayList<Aresta> arestas;
    
   public Grafo(){
    this.vertices = new ArrayList<>();
    this.arestas = new ArrayList<>(); 
   } 
   
   public Vertice CriarVertice()
   {
       Vertice vVertice = new Vertice();
       this.vertices.add(vVertice);  
       return vVertice;
   }
   
   public Aresta CriaAresta(){
       Aresta vAresta = new Aresta();
       this.arestas.add(vAresta);  
       return vAresta;
   }
   
}

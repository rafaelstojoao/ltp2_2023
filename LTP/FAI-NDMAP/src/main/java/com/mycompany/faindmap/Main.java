/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import Grafo.Direcao;
import Grafo.Grafo;

public class Main {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Direcao direita = Direcao.DIREITA;
        grafo.CriaAresta();
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                grafo.CriarVertice();
                
                grafo.vertices.get(i).MudaNome("Sala 6");
                grafo.vertices.get(i).MudaAndar("1");
                grafo.vertices.get(i).MudaBloco("4");
                grafo.vertices.get(i).MudaCampos("2");
                grafo.vertices.get(i).MudaNumeroSala(6);
                grafo.vertices.get(i).MudaLocalizacao(38.736946, -9.142685, 87);
                grafo.arestas.get(i).MudaDirecao(direita);
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println(grafo.vertices.get(i).RetornaNome()); 
                System.out.println(grafo.vertices.get(i).RetornaAndar());
                System.out.println(grafo.vertices.get(i).RetornaBloco());
                System.out.println(grafo.vertices.get(i).RetornaCampos());
                System.out.println(grafo.vertices.get(i).RetornaNumeroSala());
                System.out.println(grafo.vertices.get(i).RetornaLocalizacao().toString());
                System.out.println(grafo.arestas.get(i).RetornaDirecao());
            }
        }
    }
}
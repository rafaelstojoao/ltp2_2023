/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import Grafo.Grafo;

public class Main {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                grafo.vertice.get(i).MudaNome("Sala 6");
                grafo.vertice.get(i).MudaAndar("1");
                grafo.vertice.get(i).MudaBloco("4");
                grafo.vertice.get(i).MudaCampos("2");
                grafo.vertice.get(i).MudaNumeroSala(6);
                grafo.vertice.get(i).MudaLocalizacao(38.736946, -9.142685, 87);
            }
        }
    }
}
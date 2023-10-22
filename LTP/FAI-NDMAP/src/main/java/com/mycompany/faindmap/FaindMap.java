package com.mycompany.faindmap;

import Grafo.Vertice;
import Grafo.Aresta;
import Grafo.Dijkstra;
import Grafo.Grafo;
import java.sql.SQLException;

public class FaindMap {
    public static int ponto_partida;
    public static int ponto_destino;
        
        
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Grafo grafo = new Grafo();
        Aresta aresta = new Aresta();
         
        Conexao2 conexao = new Conexao2();
        conexao.Conecta();
        
        for (int i = 0; i < 5; i++) {
            Vertice vertice = new Vertice();
            vertice.cod_vertice = i + 1;
            vertice.ver_nome = "Sala " + (i+1);
            vertice.cod_andar = i + 1;
            vertice.cod_bloco = i + 1;
            vertice.cod_campos = i + 1;
            grafo.adicionarVertice(vertice);
        }
        
        for (int i = 0; i < grafo.vertices.size(); i++) { 
            aresta = new Aresta();
            if (i==0) {
                aresta.are_origem   = 1;
                aresta.are_destino  = 2;
                aresta.are_distancia= 10;
                aresta.cod_aresta   = i+1;
                grafo.adicionarAresta(aresta);
                
                aresta = new Aresta();
                aresta.are_origem   = 2;
                aresta.are_destino  = 1;
                aresta.are_distancia= 10;
                aresta.cod_aresta   = i*10;
                grafo.adicionarAresta(aresta);              
            }
            
            if (i==1) {
                aresta.are_origem   = 1;
                aresta.are_destino  = 4;
                aresta.are_distancia= 32;
                aresta.cod_aresta   = i+1;
                grafo.adicionarAresta(aresta);
                
                aresta = new Aresta();
                aresta.are_origem   = 4;
                aresta.are_destino  = 1;
                aresta.are_distancia= 32;
                aresta.cod_aresta   = i*10;
                grafo.adicionarAresta(aresta);
            }
                    
             if (i==2) {
                aresta.are_origem   = 2;
                aresta.are_destino  = 3;
                aresta.are_distancia= 19;
                aresta.cod_aresta   = i+1;
                grafo.adicionarAresta(aresta);
                
                aresta = new Aresta();
                aresta.are_origem   = 3;
                aresta.are_destino  = 2;
                aresta.are_distancia= 19;
                aresta.cod_aresta   = i*10;
                grafo.adicionarAresta(aresta);
            }
        }
        
        aresta = new Aresta();
        aresta.are_origem   = 2;
        aresta.are_destino  = 4;
        aresta.are_distancia= 9;
        aresta.cod_aresta   = 24;
        grafo.adicionarAresta(aresta);

         aresta = new Aresta();
        aresta.are_origem   = 4;
        aresta.are_destino  = 2;
        aresta.are_distancia= 9;
        aresta.cod_aresta   = 42;
        grafo.adicionarAresta(aresta);
                
        aresta = new Aresta();
        aresta.are_origem   = 5;
        aresta.are_destino  = 4;
        aresta.are_distancia= 2;
        aresta.cod_aresta   = 94;
        grafo.adicionarAresta(aresta);

        aresta = new Aresta();
        aresta.are_origem   = 4;
        aresta.are_destino  = 5;
        aresta.are_distancia= 2;
        aresta.cod_aresta   = 92;
        grafo.adicionarAresta(aresta);
                
        aresta = new Aresta();
        aresta.are_origem   = 3;
        aresta.are_destino  = 5;
        aresta.are_distancia= 34;
        aresta.cod_aresta   = 35;
        grafo.adicionarAresta(aresta);

        aresta = new Aresta();
        aresta.are_origem   = 5;
        aresta.are_destino  = 3;
        aresta.are_distancia= 34;
        aresta.cod_aresta   = 53;
        grafo.adicionarAresta(aresta);
        
        grafo.listaVertices();
        System.out.println("");
        grafo.listaArestas();
        
        Dijkstra  foo = new Dijkstra();
        ponto_partida = 1;
        ponto_destino = 3;
        foo.runDijkstraSearch(FaindMap.ponto_partida,grafo);
        foo.showRoute(FaindMap.ponto_destino);
       
        
    }
}

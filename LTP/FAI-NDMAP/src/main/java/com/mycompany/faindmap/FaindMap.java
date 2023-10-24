package com.mycompany.faindmap;

import Grafo.Vertice;
import Grafo.Aresta;
import Grafo.Dijkstra;
import Grafo.Grafo;
import java.sql.SQLException;

public class FaindMap{ 
    public static int ponto_partida;
    public static int ponto_destino;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql;
        Grafo grafo = new Grafo();
        Aresta aresta = new Aresta();
        Vertice vertice = new Vertice();
         
        Conexao2 conexao = new Conexao2();
        conexao.Conecta();
        
        sql = "SELECT * FROM vertices";
        conexao.res = conexao.stmt.executeQuery(sql);
        
        while ( conexao.res.next() ) {
            vertice.id_vertice  = conexao.res.getInt("id_vertice");
            vertice.id_status   = conexao.res.getInt("id_status");
            vertice.id_bloco    = conexao.res.getInt("id_bloco");
            vertice.id_andar    = conexao.res.getInt("id_andar");
            vertice.id_campus   = conexao.res.getInt("id_campus");
            vertice.nome        = conexao.res.getString("nome");
            vertice.latitude    = conexao.res.getDouble("latitude");
            vertice.longitude   = conexao.res.getDouble("longitude");
            
            grafo.adicionarVertice(vertice);
            vertice = new Vertice();
        }
        
        sql = "SELECT * FROM arestas";
        conexao.res = conexao.stmt.executeQuery(sql);
        
        while ( conexao.res.next() ) {
            aresta.id_aresta                = conexao.res.getInt("id_aresta");
            aresta.id_vertice_origem        = conexao.res.getInt("id_vertice_origem");
            aresta.id_vertice_destino       = conexao.res.getInt("id_vertice_destino");
            aresta.id_direcao               = conexao.res.getInt("id_direcao");
            aresta.descricao_vertice_origem = conexao.res.getString("descricao_vertice_origem");
            aresta.descricao_vertice_destino= conexao.res.getString("descricao_vertice_destino");
            aresta.distancia                = conexao.res.getDouble("distancia");
            grafo.adicionarAresta(aresta);
            
            aresta = new Aresta();
            aresta.id_aresta                = conexao.res.getInt("id_aresta");
            aresta.id_vertice_origem        = conexao.res.getInt("id_vertice_destino");
            aresta.id_vertice_destino       = conexao.res.getInt("id_vertice_origem");
            aresta.id_direcao               = conexao.res.getInt("id_direcao");
            aresta.descricao_vertice_origem = conexao.res.getString("descricao_vertice_origem");
            aresta.descricao_vertice_destino= conexao.res.getString("descricao_vertice_destino");
            aresta.distancia                = conexao.res.getDouble("distancia");
            grafo.adicionarAresta(aresta);
            
            aresta = new Aresta();
        }
        
        conexao.con.close();
        
        grafo.listaVertices();
        System.out.println("");
        grafo.listaArestas();
        
        Dijkstra  foo = new Dijkstra();
        ponto_partida = 1;
        ponto_destino = 5;
        foo.runDijkstraSearch(FaindMap.ponto_partida, grafo);
        foo.showRoute(FaindMap.ponto_destino);
       
        
    }
}

package Grafo;

import static java.lang.Integer.MAX_VALUE;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Dijkstra {
    
    public Vertice origem = null;
    public Map<Integer, Caminho> caminho= new HashMap<>();
    public Queue<Aresta> fila_arestas_adjascentes =new LinkedList<>();    
    public Queue<Vertice> fila_vertices_processar =new LinkedList<>();
    
    public  void inicializaDistancias(Grafo G){
        for (Integer key: G.vertices.keySet()) {
            Caminho rota =  new Caminho();
            rota.estimativa= MAX_VALUE;
            rota.precedente = -1;
            rota.vert = G.vertices.get(key);
            rota.aberto = true;
            this.caminho.put(key, rota); 
        }
    }
    
    public  void runDijkstraSearch(int cod_origem, Grafo G){
        this.origem = G.vertices.get(cod_origem);
        int partida = cod_origem;
        this.inicializaDistancias(G);
        this.caminho.get(cod_origem).estimativa=0;
        this.caminho.get(cod_origem).precedente=cod_origem;       
        
        //mapear todas as arestas que tem como origem, o vertice cod_origem
        //fechar cod_origem
        //atualizar caminhos
        // fila de arestas  fila_arestas_adjascentes

        for (Integer key: G.arestas.keySet()) {
              
            if(G.arestas.get(key).are_origem - cod_origem == 0){
                this.fila_arestas_adjascentes.add(G.arestas.get(key));
            }
             
            while(!this.fila_arestas_adjascentes.isEmpty()){
                Aresta are_vizinho = this.fila_arestas_adjascentes.poll();
                 
                this.fila_vertices_processar.add(G.vertices.get(are_vizinho.are_destino));

                this.caminho.get(are_vizinho.are_origem).aberto=false;
                 
                if(this.caminho.get(are_vizinho.are_destino).estimativa > (int) are_vizinho.are_distancia){
                    this.caminho.get(are_vizinho.are_destino).estimativa = (int) are_vizinho.are_distancia;
                    this.caminho.get(are_vizinho.are_destino).precedente = are_vizinho.are_origem;
                }  
//                System.out.println(are_vizinho.are_origem+ "  -  " +are_vizinho.are_destino+" distância: "+are_vizinho.are_distancia);
            }       
         }
         
        while(!this.fila_vertices_processar.isEmpty()){
            System.out.println("");
            Vertice vert_atual = this.fila_vertices_processar.poll();
            System.out.println("Processando: "+vert_atual.ver_nome);
                 
            for (Integer key: G.arestas.keySet()) {
                if(G.arestas.get(key).are_origem - vert_atual.cod_vertice==0){
                    if(this.caminho.get(G.arestas.get(key).are_destino).aberto){
                       this.fila_arestas_adjascentes.add(G.arestas.get(key));
                    }
                }
            }
            while(!this.fila_arestas_adjascentes.isEmpty()){
                Aresta are_vizinho = this.fila_arestas_adjascentes.poll();
                this.caminho.get(are_vizinho.are_origem).aberto=false;

                if(this.caminho.get(are_vizinho.are_destino).aberto){
                    this.fila_vertices_processar.add(G.vertices.get(are_vizinho.are_destino));
                }

                if(this.caminho.get(are_vizinho.are_destino).estimativa > ((int) are_vizinho.are_distancia+ this.caminho.get(are_vizinho.are_origem).estimativa )){
                    this.caminho.get(are_vizinho.are_destino).estimativa = (int) are_vizinho.are_distancia +  this.caminho.get(are_vizinho.are_origem).estimativa;
                    this.caminho.get(are_vizinho.are_destino).precedente = are_vizinho.are_origem;
                }
                System.out.println(are_vizinho.are_origem+ "  -  " +are_vizinho.are_destino+" distância: "+are_vizinho.are_distancia);
            }              
        }
        //laço a partir do menor caminho aberto
        //fecha vertice selecionado
        //atualiza caminhos
        System.out.println("");
        for (Integer key: this.caminho.keySet()) {
            System.out.println(key+" status: "+this.caminho.get(key).aberto+" precedente:  "+this.caminho.get(key).precedente+ " distância: " +this.caminho.get(key).estimativa);
        }
    }

    public void showRoute(int ponto_destino) {
        System.out.println("");
        System.out.println("APRESENTANDO O CAMINHO MAIS EFICIENTE A PARTIR DE: "+this.origem.cod_vertice+ " ATÉ: "+ponto_destino);
        while(this.caminho.get(ponto_destino).estimativa > 0){
            System.out.println(" Para chegar a: "+ponto_destino +"  Passe por:  "+this.caminho.get(ponto_destino).precedente+ " distância total até o destino: " +this.caminho.get(ponto_destino).estimativa);
            ponto_destino = this.caminho.get(ponto_destino).precedente;
        }       
    }       
}

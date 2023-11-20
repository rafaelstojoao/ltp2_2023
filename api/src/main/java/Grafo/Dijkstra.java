package Grafo;

import FaindMap.api.Arestas.Aresta;
import FaindMap.api.Vertice.Vertice;
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
    
    public  void inicializaDistancias(Grafo grafo){
        for (Integer key: grafo.vertices.keySet()) {
            Caminho rota =  new Caminho();
            rota.estimativa= MAX_VALUE;
            rota.precedente = -1;
            rota.vertice = grafo.vertices.get(key);
            rota.aberto = true;
            this.caminho.put(key, rota); 
        }
    }
    
    public  void runDijkstraSearch(int cod_origem, Grafo grafo){
        this.origem = grafo.vertices.get(cod_origem);
        this.inicializaDistancias(grafo);
        this.caminho.get(cod_origem).estimativa=0;
        this.caminho.get(cod_origem).precedente=cod_origem;       
        
        //mapear todas as arestas que tem como origem, o vertice cod_origem
        //fechar cod_origem
        //atualizar caminhos
        // fila de arestas  fila_arestas_adjascentes

        for (Integer key: grafo.arestas.keySet()) {
              
            if(grafo.arestas.get(key).getId_vertice_origem().getId_vertice() - cod_origem == 0){
                this.fila_arestas_adjascentes.add(grafo.arestas.get(key));
            }
            
            System.out.println("Verificando Lista dos Adjascentes");
            while(!this.fila_arestas_adjascentes.isEmpty()){
                Aresta are_vizinho = this.fila_arestas_adjascentes.poll();
                this.caminho.get(are_vizinho.getId_vertice_origem().getId_vertice()).aberto=false;
                
                if(this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).aberto){
                    this.fila_vertices_processar.add(grafo.vertices.get(are_vizinho.getId_vertice_destino().getId_vertice()));
                }
                                                                                                       
                if(this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).estimativa > are_vizinho.getDistancia().intValue()){
                    this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).estimativa = are_vizinho.getDistancia().intValue();                                                                                       
                    this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).precedente = are_vizinho.getId_vertice_origem().getId_vertice();
                }  
                System.out.println(are_vizinho.getId_vertice_origem().getId_vertice()+ "  -  " +are_vizinho.getId_vertice_destino().getId_vertice()+" distância: "+are_vizinho.getDistancia());
            }       
         }
         
        while(!this.fila_vertices_processar.isEmpty()){
            System.out.println("");
            Vertice vert_atual = this.fila_vertices_processar.poll();
            System.out.println("Processando: "+vert_atual.getNome());
                 
            for (Integer key: grafo.arestas.keySet()) {
                if(grafo.arestas.get(key).getId_vertice_origem().getId_vertice() - vert_atual.getId_vertice()==0){
                    if(this.caminho.get(grafo.arestas.get(key).getId_vertice_destino().getId_vertice()).aberto){
                       this.fila_arestas_adjascentes.add(grafo.arestas.get(key));
                    }
                }
            }
            while(!this.fila_arestas_adjascentes.isEmpty()){
                Aresta are_vizinho = this.fila_arestas_adjascentes.poll();
                this.caminho.get(are_vizinho.getId_vertice_origem().getId_vertice()).aberto=false;

                if(this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).aberto){
                    this.fila_vertices_processar.add(grafo.vertices.get(are_vizinho.getId_vertice_destino().getId_vertice()));
                }

                if(this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).estimativa > (are_vizinho.getDistancia().intValue() + this.caminho.get(are_vizinho.getId_vertice_origem().getId_vertice()).estimativa)){
                    this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).estimativa = are_vizinho.getDistancia().intValue() + this.caminho.get(are_vizinho.getId_vertice_origem().getId_vertice()).estimativa;
                    this.caminho.get(are_vizinho.getId_vertice_destino().getId_vertice()).precedente = are_vizinho.getId_vertice_origem().getId_vertice();
                }
                System.out.println(are_vizinho.getId_vertice_origem().getId_vertice()+ "  -  " +are_vizinho.getId_vertice_destino().getId_vertice()+" distância: "+are_vizinho.getDistancia());
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

    public Map<Integer, Caminho> showRoute(int ponto_destino) {
        Map<Integer, Caminho> retorno = new HashMap<>();
        System.out.println("");
        System.out.println("APRESENTANDO O CAMINHO MAIS EFICIENTE A PARTIR DE: "+this.origem.getId_vertice()+ " ATÉ: "+ponto_destino);
        while(this.caminho.get(ponto_destino).estimativa > 0){
            System.out.println(" Para chegar a: "+ponto_destino +"  Passe por:  "+this.caminho.get(ponto_destino).precedente+ " distância total até o destino: " +this.caminho.get(ponto_destino).estimativa);
            retorno.put(this.caminho.get(ponto_destino).vertice.getId_vertice(), this.caminho.get(ponto_destino));
            ponto_destino = this.caminho.get(ponto_destino).precedente; 
        }  
        
        return this.caminho;
    }       
}

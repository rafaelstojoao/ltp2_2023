package FaindMap.api.Arestas;

import FaindMap.api.Direcao.Direcao;
import FaindMap.api.Vertice.Vertice;
import FaindMap.api.Arestas.Aresta;

public record DadosListagemAresta(Vertice origem, Vertice destino, String nomeOrigem, String nomeDestino, Direcao direcao, Double distancia) {
    
    public DadosListagemAresta(Aresta aresta){
        this(  aresta.getId_vertice_origem(), 
              aresta.getId_vertice_destino(), 
            aresta.getDescricao_vertice_origem(), 
           aresta.getDescricao_vertice_destino(), 
             aresta.getDirecao(), 
             aresta.getDistancia());
    }
}

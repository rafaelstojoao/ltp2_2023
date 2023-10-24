package Grafo;

public class Aresta {
    public int id_aresta;
    public int id_vertice_origem;
    public String descricao_vertice_origem;
    public int id_vertice_destino;
    public String descricao_vertice_destino;
    public int id_direcao;
    public double distancia;
    
    public void Add(Aresta aresta) {
        this.id_aresta = aresta.id_aresta;
        this.id_vertice_origem = aresta.id_vertice_origem;
        this.descricao_vertice_origem = aresta.descricao_vertice_origem;
        this.id_vertice_destino = aresta.id_vertice_destino;
        this.descricao_vertice_destino = aresta.descricao_vertice_destino;
        this.id_direcao = aresta.id_direcao;  
        this.distancia = aresta.distancia;
    }
      
}

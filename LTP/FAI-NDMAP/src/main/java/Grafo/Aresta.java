package Grafo;

public class Aresta {
    public int cod_aresta;
    public int are_origem;
    public int are_destino;
    public String are_direcao;
    public double are_distancia;
    
    public void Add(Aresta aresta) {
        this.cod_aresta = aresta.cod_aresta;
        this.are_origem = aresta.are_origem;
        this.are_destino = aresta.are_destino;
        this.are_direcao = aresta.are_direcao;  
        this.are_distancia = aresta.are_distancia;
    }
      
}

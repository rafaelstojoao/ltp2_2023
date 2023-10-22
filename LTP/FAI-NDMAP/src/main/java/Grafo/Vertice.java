package Grafo;

public class Vertice{
     
    public int cod_campos;
    public String ver_nome;
    public int cod_bloco;
    public int cod_andar;
    public int cod_vertice;
    public double peso;
   
    public void Add(Vertice vertice) {
        this.cod_vertice = vertice.cod_vertice;
        this.peso = Integer.MAX_VALUE;
        
        this.cod_campos = vertice.cod_campos;
        this.cod_andar = vertice.cod_andar;
        this.cod_bloco = vertice.cod_bloco;
        this.ver_nome = vertice.ver_nome;
    }

    

  
}

package Grafo;

public class Vertice{
    
    public int id_vertice;
    public int id_status;
    public int id_bloco;
    public int id_andar;
    public int id_campus;
    public String nome;
    public double peso;
    public double latitude;
    public double longitude;
    
    
    public void Add(Vertice vertice) {
        this.id_vertice = vertice.id_vertice;
        this.peso = Integer.MAX_VALUE;
        
        this.id_campus = vertice.id_campus;
        this.id_andar = vertice.id_andar;
        this.id_bloco = vertice.id_bloco;
        this.nome = vertice.nome;
        this.id_status = vertice.id_status;
        this.latitude = vertice.latitude;
        this.longitude = vertice.longitude;
    }

    

  
}

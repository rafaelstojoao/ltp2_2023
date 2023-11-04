package FaindMap.api.Arestas;

import FaindMap.api.Direcao.Direcao;
import FaindMap.api.Vertice.Vertice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "arestas")
@Entity(name = "Aresta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_aresta")
public class Aresta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aresta;
    private String descricao_vertice_origem;
    private String descricao_vertice_destino;
    private Double distancia;
    
    @ManyToOne
    @JoinColumn(name = "id_vertice_origem")
    private Vertice id_vertice_origem;

    @ManyToOne
    @JoinColumn(name = "id_vertice_destino")
    private Vertice id_vertice_destino;
    
    @ManyToOne
    @JoinColumn(name = "id_direcao")
    private Direcao direcao;   
    
    public Aresta(Aresta json) {
        this.id_aresta                  = json.id_aresta;
        this.descricao_vertice_origem   = json.descricao_vertice_origem;
        this.descricao_vertice_destino  = json.descricao_vertice_destino;
        this.distancia                  = json.distancia;
        this.id_vertice_destino         = json.id_vertice_destino;
        this.id_vertice_origem          = json.id_vertice_origem;
        this.direcao                    = json.direcao;
    }
    
    
    public void Add(Aresta aresta) {
        this.id_aresta                  = aresta.id_aresta;
        this.id_vertice_origem          = aresta.id_vertice_origem;
        this.descricao_vertice_origem   = aresta.descricao_vertice_origem;
        this.id_vertice_destino         = aresta.id_vertice_destino;
        this.descricao_vertice_destino  = aresta.descricao_vertice_destino;
        this.direcao                    = aresta.direcao;  
        this.distancia                  = aresta.distancia;
    }
}

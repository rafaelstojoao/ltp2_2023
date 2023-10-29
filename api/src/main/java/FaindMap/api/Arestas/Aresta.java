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
}

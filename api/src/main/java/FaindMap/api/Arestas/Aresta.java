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

    /**
     * @return the id_aresta
     */
    public int getId_aresta() {
        return id_aresta;
    }

    /**
     * @param id_aresta the id_aresta to set
     */
    public void setId_aresta(int id_aresta) {
        this.id_aresta = id_aresta;
    }

    /**
     * @return the distancia
     */
    public Double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the id_vertice_origem
     */
    public Vertice getId_vertice_origem() {
        return id_vertice_origem;
    }

    /**
     * @param id_vertice_origem the id_vertice_origem to set
     */
    public void setId_vertice_origem(Vertice id_vertice_origem) {
        this.id_vertice_origem = id_vertice_origem;
    }

    /**
     * @return the id_vertice_destino
     */
    public Vertice getId_vertice_destino() {
        return id_vertice_destino;
    }

    /**
     * @param id_vertice_destino the id_vertice_destino to set
     */
    public void setId_vertice_destino(Vertice id_vertice_destino) {
        this.id_vertice_destino = id_vertice_destino;
    }

    /**
     * @return the direcao
     */
    public Direcao getDirecao() {
        return direcao;
    }

    /**
     * @param direcao the direcao to set
     */
    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aresta;
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
        this.distancia                  = json.distancia;
        this.id_vertice_destino         = json.id_vertice_destino;
        this.id_vertice_origem          = json.id_vertice_origem;
        this.direcao                    = json.direcao;
    }
    
    
    public void Add(Aresta aresta) {
        this.setId_aresta(aresta.getId_aresta());
        this.setId_vertice_origem(aresta.getId_vertice_origem());
        this.setId_vertice_destino(aresta.getId_vertice_destino());
        this.setDirecao(aresta.getDirecao());  
        this.setDistancia(aresta.getDistancia());
    }
}

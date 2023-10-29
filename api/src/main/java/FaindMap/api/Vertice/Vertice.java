package FaindMap.api.Vertice;

import FaindMap.api.Andares.Andar;
import FaindMap.api.Arestas.Aresta;
import FaindMap.api.Blocos.Bloco;
import FaindMap.api.Campus.Campus;
import FaindMap.api.Entity.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "vertices")
@Entity(name = "Vertice")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_vertice")
public class Vertice {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vertice;
    private String nome;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;
    @ManyToOne
    @JoinColumn(name = "id_andar")
    private Andar andar;
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    
//    @ManyToOne
//    private Aresta id_vertice_destino;
//
//    @ManyToOne
//    private Aresta id_vertice_origem;
   
    public Vertice(DadosCadastroVertice json) {
        this.nome       = json.nome();
        this.bloco      = json.bloco();
        this.andar      = json.andar();
        this.latitude   = json.latitude();
        this.longitude  = json.longitude();
        this.status     = json.status();
        this.campus     = json.campus();
        //this.id_campus =  new Campus(json.campus());
    }
}

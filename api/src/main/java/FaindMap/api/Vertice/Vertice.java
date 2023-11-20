package FaindMap.api.Vertice;

import FaindMap.api.Andares.Andar;
import FaindMap.api.Blocos.Bloco;
import FaindMap.api.Campus.Campus;
import FaindMap.api.Locais.Local;
import FaindMap.api.Status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    
    private transient double peso;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vertice;
    private String nome;
    private transient double latitude;
    private transient double longitude;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private transient Status status;
    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;
    @ManyToOne
    @JoinColumn(name = "id_andar")
    private Andar andar;
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;   
    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local; 
    
    public Vertice(DadosCadastroVertice json) {
        this.id_vertice = json.id_vertice();
        this.nome       = json.nome();
        this.bloco      = json.bloco();
        this.andar      = json.andar();
        this.latitude   = json.latitude();
        this.longitude  = json.longitude();
        this.status     = json.status();
        this.campus     = json.campus();
        this.local      = json.local();
    }
    
    public void Add(Vertice vertice) {
        this.id_vertice = vertice.id_vertice;
        this.peso = Integer.MAX_VALUE;
        
        this.campus     = vertice.campus;
        this.andar      = vertice.andar;
        this.bloco      = vertice.bloco;
        this.nome       = vertice.nome;
        this.status     = vertice.status;
        this.local      = vertice.local;
        this.latitude   = vertice.latitude;
        this.longitude  = vertice.longitude;
    }
}

package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;
import FaindMap.api.Entity.Status;
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
    private int id_bloco;
    private int id_andar;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;
   
    public Vertice(DadosCadastroVertice json) {
        this.nome   = json.nome();
        this.id_bloco  = json.bloco();
        this.id_andar  = json.andar();
        this.latitude   = json.latitude();
        this.longitude  = json.longitude();
        this.status = json.status();
        this.campus = json.campus();
        //this.id_campus =  new Campus(json.campus());
    }
}

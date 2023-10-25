package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vertice;
    private String nome;
    private int id_status;
    private int id_bloco;
    private int id_andar;
    
    //@ManyToOne
    private int id_campus;
    //private Campus id_campus;
    private double latitude;
    private double longitude;

    public Vertice(DadosCadastroVertice json) {
        this.nome   = json.nome();
        this.id_bloco  = json.bloco();
        this.id_andar  = json.andar();
        this.latitude   = json.latitude();
        this.longitude  = json.longitude();
        this.id_status = json.status();
        this.id_campus = json.campus();
        //this.id_campus =  new Campus(json.campus());
    }
}

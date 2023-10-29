package FaindMap.api.Blocos;

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

@Table(name = "blocos")
@Entity(name = "Blocos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_bloco")
public class Bloco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_bloco;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    private String nome;
            
}

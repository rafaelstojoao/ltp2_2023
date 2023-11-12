package FaindMap.api.Andares;

import FaindMap.api.Status.Status;
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

@Table(name = "andares")
@Entity(name = "Andares")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_andar")
public class Andar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_andar;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    private String nome;
}

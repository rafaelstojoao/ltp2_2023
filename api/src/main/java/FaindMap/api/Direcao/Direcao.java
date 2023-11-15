package FaindMap.api.Direcao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "direcao")
@Entity(name = "Direcao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_direcao")
public class Direcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int id_direcao;
    
    private String descricao;
}

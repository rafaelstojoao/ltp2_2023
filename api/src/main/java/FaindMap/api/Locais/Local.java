package FaindMap.api.Locais;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "locais")
@Entity(name = "Locais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int id_local;
    
    private int num_local;
    private String nome_local;
    private String nome_laboratorio;
    
}

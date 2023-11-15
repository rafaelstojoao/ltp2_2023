package FaindMap.api.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "status")
@Entity(name = "Status")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_status")
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int id_status;
    
    private String descricao;
}

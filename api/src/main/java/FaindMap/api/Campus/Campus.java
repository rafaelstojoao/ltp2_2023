package FaindMap.api.Campus;

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

@Table(name = "campus")
@Entity(name = "Campus")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_campus")
public class Campus {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_campus;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    public Campus(DadosCadastroCampus campus) {
        this.status = campus.status();
        this.descricao = campus.descricao();
    }

    public void atualizarInformacoes(DadosAtualizacaoCampus json) {
        if (json.descricao() != null) {
            this.descricao = json.descricao();
        }
        
        if (json.status() != null) {
            this.status = json.status();
        }
        
    }
    
}

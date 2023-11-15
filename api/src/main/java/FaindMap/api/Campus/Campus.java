package FaindMap.api.Campus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Campus(DadosCadastroCampus campus) {
        this.descricao = campus.descricao();
    }

    public void atualizarInformacoes(DadosAtualizacaoCampus json) {
        if (json.descricao() != null) {
            this.descricao = json.descricao();
        }
    }
    
}

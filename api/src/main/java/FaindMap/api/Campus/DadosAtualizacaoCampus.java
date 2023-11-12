package FaindMap.api.Campus;

import FaindMap.api.Status.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCampus(
        @NotNull
        Long id, 
        String descricao) {
    
}

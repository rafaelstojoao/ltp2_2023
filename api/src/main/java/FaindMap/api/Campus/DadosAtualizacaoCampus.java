package FaindMap.api.Campus;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCampus(
        @NotNull
        Long id, 
        String descricao, 
        int status) {
    
}

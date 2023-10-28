package FaindMap.api.Campus;

import FaindMap.api.Entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCampus(
    @NotBlank   
    String descricao,
        
    @NotNull    
    Status status) {

}

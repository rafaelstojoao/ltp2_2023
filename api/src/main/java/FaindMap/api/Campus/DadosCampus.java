package FaindMap.api.Campus;

import FaindMap.api.Enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCampus(
    @NotBlank   
    String descricao,
        
    @NotNull    
    int status) {

}

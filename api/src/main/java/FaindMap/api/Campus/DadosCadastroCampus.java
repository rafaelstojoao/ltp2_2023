package FaindMap.api.Campus;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCampus(
    @NotBlank   
    String descricao) {

}

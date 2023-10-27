package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVertice(
        @NotBlank
        String nome, 
        @NotNull
        int status,
        @NotNull
        int bloco,
        @NotNull
        int andar,
        @NotNull /*Campus campus*/
        int campus,
        @NotNull
        @Pattern(regexp = "\\-?[0-9]*[.]?[0-9]+")
        double latitude, 
        @NotNull
        double longitude) {

}

package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;
import FaindMap.api.Entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVertice(
        @NotBlank
        String nome, 
        
        @NotNull
        Status status,
        
        @NotNull
        int bloco,
        
        @NotNull
        int andar,
        
        @NotNull 
        Campus campus,
        
        @NotNull
        @Pattern(regexp = "\\-?[0-9]*[.]?[0-9]+")
        double latitude, 
        
        @NotNull
        @Pattern(regexp = "\\-?[0-9]*[.]?[0-9]+")        
        double longitude) {

}

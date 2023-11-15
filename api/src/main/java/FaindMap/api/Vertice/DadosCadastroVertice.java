package FaindMap.api.Vertice;

import FaindMap.api.Andares.Andar;
import FaindMap.api.Blocos.Bloco;
import FaindMap.api.Campus.Campus;
import FaindMap.api.Locais.Local;
import FaindMap.api.Status.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVertice(
        @NotBlank
        Integer id_vertice, 
        
        @NotBlank
        String nome, 
        
        @NotNull
        Status status,
        
        @NotNull
        Bloco bloco,
        
        @NotNull
        Andar andar,
        
        @NotNull 
        Campus campus,
        
        @NotNull 
        Local local,
        
        @NotNull
        @Pattern(regexp = "\\-?[0-9]*[.]?[0-9]+")
        double latitude, 
        
        @NotNull
        @Pattern(regexp = "\\-?[0-9]*[.]?[0-9]+")        
        double longitude) {

}

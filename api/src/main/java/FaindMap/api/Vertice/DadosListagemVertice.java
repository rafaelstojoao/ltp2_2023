package FaindMap.api.Vertice;

import FaindMap.api.Andares.Andar;
import FaindMap.api.Blocos.Bloco;
import FaindMap.api.Campus.Campus;
import FaindMap.api.Entity.Status;

public record DadosListagemVertice(String nome, Campus campus, Status status, Bloco bloco, Andar andar, Double longitude, Double latitude) {
    public DadosListagemVertice(Vertice vertice){
        this(vertice.getNome(), 
           vertice.getCampus(), 
           vertice.getStatus(), 
            vertice.getBloco(), 
            vertice.getAndar(), 
         vertice.getLongitude(), 
          vertice.getLatitude());
    }
}

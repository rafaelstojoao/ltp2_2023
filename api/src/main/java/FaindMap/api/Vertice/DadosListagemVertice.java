package FaindMap.api.Vertice;

import FaindMap.api.Andares.Andar;
import FaindMap.api.Blocos.Bloco;
import FaindMap.api.Campus.Campus;
import FaindMap.api.Locais.Local;
import FaindMap.api.Status.Status;

public record DadosListagemVertice(Integer id_vertice, String nome, Campus campus, Status status, Bloco bloco, Andar andar, Local local, Double longitude, Double latitude) {
    public DadosListagemVertice(Vertice vertice){
        this(vertice.getId_vertice(),
           vertice.getNome(), 
           vertice.getCampus(), 
           vertice.getStatus(), 
            vertice.getBloco(), 
            vertice.getAndar(), 
            vertice.getLocal(), 
         vertice.getLongitude(), 
          vertice.getLatitude());
    }
}

package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;
import FaindMap.api.Entity.Status;

public record DadosListagemVertice(String nome, Campus campus, Status status) {
    public DadosListagemVertice(Vertice vertice){
        this(vertice.getNome(), vertice.getCampus(), vertice.getStatus());
    }
}

package FaindMap.api.Status;

import FaindMap.api.Entity.Status;

public record DadosListagemStatus(String descricao) 
{
    public DadosListagemStatus(Status status){
        this(status.getDescricao());
    }
}

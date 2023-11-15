package FaindMap.api.Status;

public record DadosListagemStatus(String descricao) 
{
    public DadosListagemStatus(Status status){
        this(status.getDescricao());
    }
}

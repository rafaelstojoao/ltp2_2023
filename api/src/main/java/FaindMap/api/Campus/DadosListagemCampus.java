package FaindMap.api.Campus;

public record DadosListagemCampus(int id, String descricao, int status) {
    
    public DadosListagemCampus(Campus campus){
        this(campus.getId_campus(), campus.getDescricao(), campus.getId_status());
    }
    
}


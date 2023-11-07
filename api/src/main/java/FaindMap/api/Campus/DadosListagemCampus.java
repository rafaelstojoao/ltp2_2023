package FaindMap.api.Campus;


public record DadosListagemCampus(int id, String descricao) {
    
    public DadosListagemCampus(Campus campus){
        this(campus.getId_campus(), campus.getDescricao());
    }
    
}


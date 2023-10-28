package FaindMap.api.Campus;

import FaindMap.api.Entity.Status;

public record DadosListagemCampus(int id, String descricao, Status status) {
    
    public DadosListagemCampus(Campus campus){
        this(campus.getId_campus(), campus.getDescricao(), campus.getStatus());
    }
    
}


package FaindMap.api.controllers;

import FaindMap.api.Arestas.DadosListagemAresta;
import FaindMap.api.Repository.ArestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("faindmap/aresta")
public class ArestaController {
    
    @Autowired
    private ArestaRepository repository;
    
    @GetMapping
    public Page<DadosListagemAresta> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAresta::new);
    }          
    
}

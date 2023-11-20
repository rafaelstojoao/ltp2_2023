
package FaindMap.api.controllers;

import FaindMap.api.Repository.VerticeRepository;
import FaindMap.api.Vertice.DadosCadastroVertice;
import FaindMap.api.Vertice.DadosListagemVertice;
import FaindMap.api.Vertice.Vertice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("faindmap/vertice")
public class VerticeController {
    
    @Autowired
    private VerticeRepository repository;
    
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroVertice json) {
        repository.save(new Vertice(json));
    }
    
    @GetMapping
    public Page<DadosListagemVertice> listar(@PageableDefault(size = 100)Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemVertice::new);              
    }          
}

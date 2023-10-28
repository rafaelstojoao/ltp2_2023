package FaindMap.api.controllers;

import FaindMap.api.Campus.Campus;
import FaindMap.api.Campus.DadosAtualizacaoCampus;
import FaindMap.api.Campus.DadosCadastroCampus;
import FaindMap.api.Campus.DadosListagemCampus;
import FaindMap.api.Repository.CampusRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("faindmap/campus")
public class CampusController {
    
    @Autowired
    private CampusRepository repository;
    
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroCampus json){
        repository.save(new Campus(json));
    }
    
    @GetMapping
    public Page<DadosListagemCampus> listar (@PageableDefault(size = 2, sort={"descricao"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCampus::new);
    }
   
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCampus json){
        var campus = repository.getReferenceById(json.id());
        campus.atualizarInformacoes(json);
        
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}

// Controle de paginas.
// Quando for implementando aquela janela de que aparecera pro usuário clicar no X quando chegar ao primeiro destino
// usar esse metodo de url(size e o page)
//http://localhost:8080/faindmap/campus?size=1&page=1


//Ordenação
//http://localhost:8080/faindmap/campus?size=2&page=0&sort=descricao,desc
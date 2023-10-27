
package FaindMap.api.controllers;

import FaindMap.api.Vertice.DadosCadastroVertice;
import FaindMap.api.Vertice.Vertice;
import FaindMap.api.Vertice.VerticeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("faindmap/locais")
public class VerticeController {
    
    @Autowired
    private VerticeRepository repository;
    
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroVertice json) {
        repository.save(new Vertice(json));
    }
}

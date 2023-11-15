package FaindMap.api.controllers;

import FaindMap.api.Arestas.Aresta;
import FaindMap.api.Repository.ArestaRepository;
import Grafo.Dijkstra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import FaindMap.api.Repository.VerticeRepository;
import FaindMap.api.Vertice.Vertice;
import Grafo.Caminho;
import Grafo.Grafo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("faindmap/buscar")
public class GrafoController {
    
    @Autowired
    private VerticeRepository repositoryVertice;
    @Autowired
    private ArestaRepository repositoryAresta;
    
    @GetMapping("/{origem}/{destino}") //Page<ListagemGrafo>Page<DadosListagemVertice>
    public Page<ArrayList<Caminho>> Buscar(@PathVariable int origem, @PathVariable int destino, @PageableDefault(sort = {}) Pageable paginacao){
        
        Grafo grafo = new Grafo();
        int destinoAux = destino;
        
        for (Vertice vertice : repositoryVertice.findAll()) {
            grafo.adicionarVertice(vertice);
        }
        for (Aresta aresta : repositoryAresta.findAll()) {
            grafo.adicionarAresta(aresta);
        }
        //grafo.duplicaAresta();
        
        Map<Integer, Caminho> retorno = new HashMap<>();
        ArrayList<Caminho> caminho = new ArrayList<>();
        Dijkstra foo = new Dijkstra();
        
        foo.runDijkstraSearch(origem, grafo);
        retorno = foo.showRoute(destino);
        
        while(retorno.get(destinoAux).estimativa > 0){  
            caminho.add(retorno.get(destinoAux));
            
            destinoAux = retorno.get(destinoAux).precedente;   
        }
        Page<ArrayList<Caminho>> page = new PageImpl<>(Collections.singletonList(caminho), paginacao, 1);
        
        return page;
            
    }
}

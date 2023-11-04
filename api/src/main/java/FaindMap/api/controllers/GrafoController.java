package FaindMap.api.controllers;

import FaindMap.api.Arestas.Aresta;
import FaindMap.api.Repository.ArestaRepository;
import Grafo.Dijkstra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import FaindMap.api.Repository.VerticeRepository;
import FaindMap.api.Vertice.Vertice;
import Grafo.Grafo;

@RestController
@RequestMapping("faindmap/buscar")
public class GrafoController {
    
    @Autowired
    private VerticeRepository repositoryVertice;
    @Autowired
    private ArestaRepository repositoryAresta;
    
    @GetMapping("/{origem}/{destino}") //Page<ListagemGrafo>
    public void Buscar(@PathVariable int origem, @PathVariable int destino, Pageable paginacao){
        
        Grafo grafo = new Grafo();
        for (Vertice vertice : repositoryVertice.findAll()) {
            grafo.adicionarVertice(vertice);
        }
        for (Aresta aresta : repositoryAresta.findAll()) {
            grafo.adicionarAresta(aresta);
        }
        
        Dijkstra foo = new Dijkstra();
        foo.runDijkstraSearch(origem, grafo);
        foo.showRoute(destino);
//        grafo.listaVertices();
//        System.out.println("----");
//        grafo.listaArestas();
                
    }      
}

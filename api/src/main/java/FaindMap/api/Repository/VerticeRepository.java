package FaindMap.api.Repository;

import FaindMap.api.Vertice.Vertice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerticeRepository extends JpaRepository<Vertice, Long> {
    
}

package FaindMap.api.Repository;

import FaindMap.api.Campus.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {
    
}

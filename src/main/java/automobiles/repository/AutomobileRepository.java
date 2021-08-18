package automobiles.repository;

import automobiles.model.entities.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Long> {
}

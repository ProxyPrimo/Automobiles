package automobiles.repository;

import automobiles.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    ModelEntity findByName(String name);

    @Query("SELECT m.name FROM ModelEntity m ORDER BY m.name")
    List<String> findAllNames();
}

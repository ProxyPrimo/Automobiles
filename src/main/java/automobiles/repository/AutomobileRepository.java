package automobiles.repository;

import automobiles.model.entities.AutomobileEntity;
import automobiles.model.entities.MakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Long> {

    List<AutomobileEntity> findAllByMaker(MakerEntity maker);
}

package automobiles.repository;

import automobiles.model.entities.MakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<MakerEntity, Long> {
}

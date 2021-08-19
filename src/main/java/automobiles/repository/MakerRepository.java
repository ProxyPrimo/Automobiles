package automobiles.repository;

import automobiles.model.entities.MakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakerRepository extends JpaRepository<MakerEntity, Long> {

    @Query("SELECT m FROM MakerEntity m WHERE lower(m.name) = lower(:name)")
    MakerEntity findByName(String name);

    @Query("SELECT m.name FROM MakerEntity m ORDER BY m.name")
    List<String> findAllNames();
}

package ci.digitalacademy.gestcantineada.repository;

import ci.digitalacademy.gestcantineada.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepository extends JpaRepository<Plat,Long> {
}

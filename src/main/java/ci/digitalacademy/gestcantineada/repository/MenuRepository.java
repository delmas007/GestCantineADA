package ci.digitalacademy.gestcantineada.repository;

import ci.digitalacademy.gestcantineada.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
}

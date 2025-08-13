package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoEnfermagemRepository extends JpaRepository<TecnicoEnfermagemRepository, Long>{

}

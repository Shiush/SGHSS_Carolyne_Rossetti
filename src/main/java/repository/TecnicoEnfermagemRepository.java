package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.entities.TecnicoEnfermagem;

@Repository
public interface TecnicoEnfermagemRepository extends JpaRepository<TecnicoEnfermagem, Long>{

}

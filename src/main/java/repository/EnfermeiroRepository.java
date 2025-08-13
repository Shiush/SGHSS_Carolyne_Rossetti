package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.entities.Enfermeiro;

@Repository
public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Long> {

}

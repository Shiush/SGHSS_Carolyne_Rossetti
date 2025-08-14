package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}

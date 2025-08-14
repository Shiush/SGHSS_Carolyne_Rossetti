package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entities.Agenda;

public interface AgendaRepository extends JpaRepository <Agenda, Long> {

}

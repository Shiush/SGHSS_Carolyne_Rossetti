package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import model.entities.Agenda;
import model.entities.Consulta;
import model.entities.Medico;
import model.entities.Paciente;
import model.enums.StatusAgenda;
import model.enums.TipoAtendimento;
import model.enums.TipoConsulta;
import repository.ConsultaRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;

public class Teste {
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private ConsultaRepository consultaRepository;

	public void testeBasico() {
	    // Criar paciente
	    Paciente paciente = new Paciente("Maria Silva", TipoAtendimento.PARTICULAR, "12345678900", LocalDate.of(1990, 5, 15));
	    pacienteRepository.save(paciente);

	    // Criar medico
	    Medico medico = new Medico("Dr. João", "98765432100", "CRM12345", "Cardiologia");
	    medicoRepository.save(medico);

	    // Abrir agenda para o médico (horário disponível)
	    Agenda agenda = new Agenda(LocalDateTime.of(2025, 8, 20, 10, 0), StatusAgenda.DISPONIVEL);
	    medico.adicionarAgenda(agenda);
	    medicoRepository.save(medico); // salva cascata a agenda também

	    // Marcar consulta (para teste rápido, associe diretamente)
	    Consulta consulta = new Consulta(paciente, medico, agenda, TipoConsulta.PRESENCIAL);

	    // Atualizar status da agenda para ocupado
	    agenda.setStatus(StatusAgenda.OCUPADO);
	    agenda.setConsulta(consulta);

	    paciente.adicionarConsulta(consulta);
	    medico.adicionarConsulta(consulta);

	    consultaRepository.save(consulta);

	    // Agora, busque e imprima as consultas do paciente
	    Paciente p = pacienteRepository.findById(paciente.getId()).get();
	    System.out.println("Consultas do paciente " + p.getNome() + ": " + p.getConsultas().size());

	    // Imprima agendas do médico
	    Medico m = medicoRepository.findById(medico.getId()).get();
	    System.out.println("Agendas do médico " + m.getNome() + ": " + m.getAgendas().size());
	}
}

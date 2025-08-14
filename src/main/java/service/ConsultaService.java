package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.entities.Agenda;
import model.entities.Consulta;
import model.entities.Medico;
import model.entities.Paciente;
import model.enums.StatusAgenda;
import model.enums.TipoConsulta;
import repository.AgendaRepository;
import repository.ConsultaRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;

@Service
public class ConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Transactional
    public Consulta marcarConsulta(Long pacienteId, Long medicoId, Long agendaId, TipoConsulta tipoConsulta) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
          .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Medico medico = medicoRepository.findById(medicoId)
          .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        Agenda agenda = agendaRepository.findById(agendaId)
          .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        if (agenda.getStatus() != StatusAgenda.DISPONIVEL) {
            throw new RuntimeException("Horário não disponível para agendamento");
        }

        //Atualiza status da agenda para ocupado
        agenda.setStatus(StatusAgenda.OCUPADO);
        agendaRepository.save(agenda);

        //Cria a consulta associando tudo
        Consulta consulta = new Consulta(paciente, medico, agenda, tipoConsulta);

        paciente.adicionarConsulta(consulta);
        medico.adicionarConsulta(consulta);
        agenda.setConsulta(consulta);

        return consultaRepository.save(consulta);
    }

    @Transactional
    public void cancelarConsulta(Long consultaId) {
        Consulta consulta = consultaRepository.findById(consultaId)
          .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        // Libera agenda e remove associação com consulta
        Agenda agenda = consulta.getAgenda();
        agenda.setStatus(StatusAgenda.DISPONIVEL);
        agenda.setConsulta(null);
        agendaRepository.save(agenda);

        // Remove consultas das coleções bidirecionais
        consulta.getPaciente().removerConsulta(consulta);
        consulta.getMedico().removerConsulta(consulta);

        // Remove a consulta do banco
        consultaRepository.delete(consulta);
    }
}

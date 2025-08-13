package service; 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.entities.Cadastro;
import model.entities.Enfermeiro;
import model.entities.Medico;
import model.entities.Paciente;
import model.entities.TecnicoEnfermagem;
import repository.CadastroRepository;
import repository.EnfermeiroRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;
import repository.TecnicoEnfermagemRepository;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    @Autowired
    private TecnicoEnfermagemRepository tecnicoEnfermagemRepository;

    // Salvar cadastro e entidade associada
    public Cadastro salvarCadastroComRelacionamento(Cadastro cadastro) {
        
        return cadastroRepository.save(cadastro);
    }

    // Buscar cadastro por login (usando método customizado do repositório)
    public Optional<Cadastro> buscarPorLogin(String login) {
        return cadastroRepository.findByLogin(login);
    }

    // Método para criar o cadastro com base no tipo que o usuário informar
    @Transactional
    public void criarCadastroComTipo(Cadastro cadastro, String tipo, Object dadosEspecificos) {
        // Salva o cadastro primeiro
        cadastroRepository.save(cadastro);

        switch (tipo.toLowerCase()) {
            case "paciente":
                Paciente paciente = (Paciente) dadosEspecificos; // assumir que recebeu um Paciente já preenchido
                paciente.setCadastro(cadastro);
                cadastro.setPaciente(paciente);
                pacienteRepository.save(paciente);
                break;

            case "medico":
                Medico medico = (Medico) dadosEspecificos; 
                medico.setCadastro(cadastro);
                cadastro.setProfissionalSaude(medico);
                medicoRepository.save(medico);
                break;

            case "enfermeiro":
                Enfermeiro enfermeiro = (Enfermeiro) dadosEspecificos; 
                enfermeiro.setCadastro(cadastro);
                cadastro.setProfissionalSaude(enfermeiro);
                enfermeiroRepository.save(enfermeiro);
                break;

            case "tecnico_enfermagem":
                TecnicoEnfermagem tecnico = (TecnicoEnfermagem) dadosEspecificos; 
                tecnico.setCadastro(cadastro);
                cadastro.setProfissionalSaude(tecnico);
                tecnicoEnfermagemRepository.save(tecnico);
                break;

            default:
                throw new IllegalArgumentException("Tipo de cadastro desconhecido: " + tipo);
        }
    }

    
}
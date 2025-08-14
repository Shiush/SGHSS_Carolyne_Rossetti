package model.entities;

import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;
import model.enums.TipoConsulta;

@Entity
@Table (name = "consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_id", unique = true)
    private Agenda agenda;
    
	@Column (name = "Tipo_Consulta", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoConsulta tipoConsulta;
	
    //Construtor sem parâmetro
	public Consulta() {
		
	}
	
	//Construtor com parâmetro
	public Consulta(Paciente paciente, Medico medico, Agenda agenda, TipoConsulta tipoConsulta) {
		this.paciente= paciente;
		this.medico = medico;
		this.agenda=agenda;
		this.tipoConsulta= tipoConsulta;
	}

	public Long getId() {
		return id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	
	@Override
	public String toString() {
		return "Dados consulta: \n"+
				"Médico: "+medico.getNome()+"\n"+
				"Paciente: "+paciente.getNome()+"\n"+
				"Horário: "+agenda.getDiaHora().format(DateTimeFormatter.ofPattern("HH:mm -- dd/MM/yyyy"))+"\n"+
				"Tipo de consulta: "+tipoConsulta.toString();
	}
}
	

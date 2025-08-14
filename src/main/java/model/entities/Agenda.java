package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;
import model.enums.StatusAgenda;

@Entity
@Table(name= "agendas")
public class Agenda {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "Dia_Hora", nullable = false)
	private LocalDateTime diaHora;
	
	@Column (name = "Status",nullable=false)
	@Enumerated(EnumType.STRING)
	private StatusAgenda statusAgenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id",nullable = false)
	private Medico medico;

	
    @OneToOne(mappedBy = "agenda", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Consulta consulta;
    
	//Construtor sem parâmetros
	public Agenda() {
		
	}
	
	//Construtor com parâmetros
	public Agenda(LocalDateTime diaHora, StatusAgenda statusAgenda) {
		this.diaHora = diaHora;
		this.statusAgenda=statusAgenda;
	}

	//Getters e Setters
	public Long getId() {
		return id;
	}

	public LocalDateTime getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(LocalDateTime diaHora) {
		this.diaHora = diaHora;
	}

	public StatusAgenda getStatus() {
		return statusAgenda;
	}

	public void setStatus(StatusAgenda statusAgenda) {
		this.statusAgenda = statusAgenda;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Medico getMedico() {
		return medico;
	}
	
	public Consulta getConsulta(){
		return consulta;
	}
	
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	@Override
	public String toString() {
		return diaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"))
				+" - " + statusAgenda.descricao;
				
	}
}

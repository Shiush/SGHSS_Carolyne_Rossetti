package model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "medicos")
public class Medico extends ProfissionalSaude{
	
	@Column (name = "CRM", nullable = false, length = 20)
	private String crm;
	
	@Column (name = "Especialidade", nullable = false, length = 50)
	private String especialidade;
	
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agenda> agendas = new ArrayList<>();
	
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas = new ArrayList<>();

	//Construtor sem parâmetros
	public Medico() {
		super();
	}
	
	//Construtor com parâmetros
	public Medico(String nome, String cpf, String crm, String especialidade) {
		super(nome,cpf);
		this.crm=crm;
		this.especialidade = especialidade;
	}
	
	//Getters e setters
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public List<Agenda> getAgendas() {
		return agendas;
	}
	
	//Adicionar e remover agenda
	public void adicionarAgenda(Agenda agenda) {
	    agendas.add(agenda);
	    agenda.setMedico(this);
	}
	public void removerAgenda(Agenda agenda) {
	    agendas.remove(agenda);
	    agenda.setMedico(null);
	}
	
	public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setMedico(this);
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
        consulta.setMedico(null);
    }
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Agendas:\n");
		for (Agenda agenda : agendas) {
			sb.append(" - ").append(agenda.toString()).append("\n");
		}
		return super.toString()+
				"Função: Médico(a) \n"+
				"CRM : "+crm+"\n"+
				"Especialidade: "+especialidade+"\n"+
				sb.toString();
	}
}

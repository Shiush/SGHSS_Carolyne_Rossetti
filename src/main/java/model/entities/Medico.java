package model.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Medico")
public class Medico extends ProfissionalSaude{
	
	@Column (name = "CRM", nullable = false, length = 20)
	private String crm;
	
	@Column (name = "Especialidade", nullable = false, length = 50)
	private String especialidade;
	
	
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
	
	@Override
	public String toString() {
		return super.toString()+
				"Função: Médico(a) \n"+
				"CRM : "+crm+"\n"+
				"Especialidade: "+especialidade;
	}
}

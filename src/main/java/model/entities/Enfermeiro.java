package model.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "enfermeiros")
public class Enfermeiro extends ProfissionalSaude{
	
	@Column (name = "Coren", nullable = false, length = 20)
	private String coren;
	
	//Construtor sem parâmetros
	public Enfermeiro() {
		super();
	}
	
	//construtor com parâmetros
	public Enfermeiro(String nome, String cpf, String coren) {
		super(nome,cpf);
		this.coren=coren;
	}
	public String getCoren() {
		return coren;
	}
	public void setCoren(String coren) {
		this.coren = coren;
	}
	
	@Override
	public String toString() {
		return super.toString()+
				"Função: Enfermeiro(a) \n"+
				"COREN : "+coren;
	}
	

}

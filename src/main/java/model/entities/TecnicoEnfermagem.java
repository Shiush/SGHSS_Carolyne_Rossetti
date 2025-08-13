package model.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Tecnico_Enfermagem")
public class TecnicoEnfermagem extends ProfissionalSaude{
	
	@Column (name = "Coren", nullable = false, length = 20)
	private String coren;
	
	//Construtor sem parâmetros
	public TecnicoEnfermagem() {
		super();
	}
	
	//Construtor com parâmetros
	public TecnicoEnfermagem(String nome, String cpf, String coren) {
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
				"Função: Técnico(a) de enfermagem \n"+
				"COREN : "+coren;
	}

}
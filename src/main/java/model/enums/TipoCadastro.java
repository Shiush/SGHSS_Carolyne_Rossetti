package model.enums;

public enum TipoCadastro {
	
	PACIENTE("Paciente"),
	PROFISSIONAL("Profissional"),
	ADMINISTRADOR("Administrador");
	
	public final String descricao;
	TipoCadastro(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}

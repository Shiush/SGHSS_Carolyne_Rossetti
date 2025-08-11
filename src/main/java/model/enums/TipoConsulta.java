package model.enums;

public enum TipoConsulta {
	
	PRESENCIAL("Presecial"),
	ONLINE("Online");
	
	public final String descricao;
	TipoConsulta(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

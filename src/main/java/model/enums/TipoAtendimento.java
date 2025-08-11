package model.enums;

public enum TipoAtendimento {
	
	PARTICULAR("Particular"),
	CONVENIO("Convênio"),
	SUS("SUS");
	
	public final String descricao;
	TipoAtendimento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

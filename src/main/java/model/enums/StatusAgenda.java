package model.enums;

public enum StatusAgenda {

	DISPONIVEL("Disponível"),
	OCUPADO("Ocupado"),
	INDISPONIVEL("Indisponível"),
	CANCELADO("Cancelado");
	
	public final String descricao;
	StatusAgenda(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

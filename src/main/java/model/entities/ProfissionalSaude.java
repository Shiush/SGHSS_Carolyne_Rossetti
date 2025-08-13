package model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Profissional_Saude")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProfissionalSaude {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nome",nullable=false, length = 100)
	private String nome;
	
	@Column(name="CPF",nullable=false, length = 11)
	private String cpf;
	
	@Column(name="Status_Validacao",nullable=false)
	private boolean statusValidacao;
	
	@Column(name="Data_Validacao",nullable = false)
	private LocalDateTime dataValidacao;
	
	@OneToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
	
	//Construtor sem parâmetros
	public ProfissionalSaude() {
		
	}
	
	//Construtor com parâmetros
	public ProfissionalSaude(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public boolean isStatusValidacao() {
		return statusValidacao;
	}
	public void setStatusValidacao(boolean statusValidacao) {
		this.statusValidacao = statusValidacao;
	}
	public LocalDateTime getDataValidacao() {
		return dataValidacao;
	}
	public void setDataValidacao(LocalDateTime dataValidacao) {
		this.dataValidacao = dataValidacao;
	}
	public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
	@Override
	public String toString() {
		return "Profissional Saúde: \n"+
				"Nome: "+nome+"\n"+
				"CPF: "+cpf+"\n";
	}
}

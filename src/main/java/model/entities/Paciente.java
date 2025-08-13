package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;
import model.enums.TipoAtendimento;

@Entity
@Table(name = "Pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nome", nullable = false, length = 100)
	private String nome;
	
	@Column (name = "Tipo_Atendimento",nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoAtendimento tipoAtendimento;
	
	@Column (name = "CPF",nullable = false, length = 11)
	private String cpf;
	
	@Column (name = "Data_Nascimento",nullable = false)
	private LocalDate nascimento;
	
	@OneToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
	
	public Paciente() {
		
	}
	
	public Paciente(String nome, TipoAtendimento tipoAtendimento, String cpf, LocalDate nascimento) {
		this.nome = nome;
		this.tipoAtendimento = tipoAtendimento;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}
	
	//Getters e Setters

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
	@Override
	public String toString() {
		return "Paciente \n"+
				"Nome: "+ nome+"\n"+
				"CPF: "+cpf+"\n"+
				"Data de nascimento: "+nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"\n"+
				"Tipo de atendimento: "+tipoAtendimento;
	}
	
}

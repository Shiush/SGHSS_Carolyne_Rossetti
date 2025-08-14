package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.TipoAtendimento;

@Entity
@Table(name = "pacientes")
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
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Consulta> consultas = new ArrayList<>();
	
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
    
    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setPaciente(this);
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
        consulta.setPaciente(null);
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

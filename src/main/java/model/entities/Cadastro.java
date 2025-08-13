package model.entities;

import jakarta.persistence.*;
import model.enums.TipoCadastro;

@Entity
@Table(name = "cadastros")
public class Cadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "login", nullable = false, length= 50) 
	private String login;
	
	@Column(name = "senha", nullable = false, length = 255)
	private String senha;
	
	@Column(name = "Tipo_Cadastro",nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCadastro tipoCadastro;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cadastro", optional = true)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cadastro", optional = true)
    private ProfissionalSaude profissionalSaude;
	
	//Construtor sem parâmetros
	public Cadastro() {
		
	}
	
	//Construtor com parâmetros
	public Cadastro(String login, String senha, TipoCadastro tipoCadastro) {
		this.login = login;
		this.senha = senha;
		this.tipoCadastro = tipoCadastro;
	}

	//Getters e Setters
	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoCadastro getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        if (paciente != null) {
            paciente.setCadastro(this);
        }
    }

    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
        if (profissionalSaude != null) {
            profissionalSaude.setCadastro(this);
        }
    }
    
	@Override
	public String toString() {
	    return "Cadastro\n" +
	           "Id: " + id + "\n" +
	           "Login: " + login + "\n" +
	           "Tipo de Cadastro: " + tipoCadastro + "\n";
	}
	
}

package model.entities;

import jakarta.persistence.*;
import model.enums.TipoConsulta;

@Entity
@Table (name = "consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "Tipo_Consulta", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoConsulta tipoConsulta;
	
	
}

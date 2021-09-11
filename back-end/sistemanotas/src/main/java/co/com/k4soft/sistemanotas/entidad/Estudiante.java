package co.com.k4soft.sistemanotas.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estudiante {
	
	private Integer idEstudiante;
	private String nombres;
	private String apellidos;
	private boolean activo;

}

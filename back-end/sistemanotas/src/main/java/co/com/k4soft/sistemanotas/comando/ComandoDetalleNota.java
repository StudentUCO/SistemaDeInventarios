package co.com.k4soft.sistemanotas.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoDetalleNota {
	
	private Integer idDetalleNota;
	private Integer idAsignatura;
	private Integer idEstudiante;
	private double notaParcial;
	private double notaFinal;
	private double notaSeguimiento;

}

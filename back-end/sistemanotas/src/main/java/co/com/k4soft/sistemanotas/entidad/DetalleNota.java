package co.com.k4soft.sistemanotas.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleNota {
	
	private Integer idDetalleNota;
	private Asignatura asignatura;
	private Estudiante estudiante;
	private double notaParcial;
	private double notaFinal;
	private double notaSeguimiento;
	
	public Asignatura getAsignatura() {
		if(asignatura == null) {
			asignatura = new Asignatura();
		}
		return asignatura;
	}
	
	public Estudiante getEstudiante() {
		if(estudiante == null) {
			estudiante = new Estudiante();
		}
		return estudiante;
	}
	

}

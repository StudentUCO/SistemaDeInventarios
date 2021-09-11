package co.com.k4soft.sistemanotas.converter;

import org.springframework.stereotype.Component;

import co.com.k4soft.sistemanotas.comando.ComandoDetalleNota;
import co.com.k4soft.sistemanotas.entidad.DetalleNota;
import co.com.k4soft.sistemanotas.validador.ValidadorArgumento;

@Component
public class DetalleNotaConverter {
	
	
	private static final String LA_NOTA_PARCIAL_NO_PUEDE_SER_NEGATIVA = "La nota parcial no puede ser negativa";
	private static final String EL_ID_ASIGNATURA_NO_ES_VALIDO = "El id asignatura no es válido";
	private static final String EL_ID_ESTUDIANTE_NO_ES_VALIDO = "El id estudiante no es válido";
	private static final String LA_NOTA_FINAL_NO_PUEDE_SER_NEGATIVA = "La nota final no puede ser negativa";
	private static final String LA_NOTA_SEGUIMIENTO_NO_PUEDE_SER_NEGATIVA = "La nota de seguimiento no puede ser negativa";

	public DetalleNota crear(ComandoDetalleNota comandoDetalleNota) {
		DetalleNota detalleNota = new DetalleNota();
		ValidadorArgumento.validarObligatorio(comandoDetalleNota.getIdAsignatura(), EL_ID_ASIGNATURA_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoDetalleNota.getIdEstudiante(), EL_ID_ESTUDIANTE_NO_ES_VALIDO);
		ValidadorArgumento.validarNegativo(comandoDetalleNota.getNotaParcial(), LA_NOTA_PARCIAL_NO_PUEDE_SER_NEGATIVA);
		ValidadorArgumento.validarNegativo(comandoDetalleNota.getNotaFinal(), LA_NOTA_FINAL_NO_PUEDE_SER_NEGATIVA);
		ValidadorArgumento.validarNegativo(comandoDetalleNota.getNotaSeguimiento(), LA_NOTA_SEGUIMIENTO_NO_PUEDE_SER_NEGATIVA);
		detalleNota.getAsignatura().setIdAsignatura(comandoDetalleNota.getIdAsignatura());
		detalleNota.getEstudiante().setIdEstudiante(comandoDetalleNota.getIdEstudiante());
		detalleNota.setNotaFinal(comandoDetalleNota.getNotaFinal());
		detalleNota.setNotaParcial(comandoDetalleNota.getNotaParcial());
		detalleNota.setNotaSeguimiento(comandoDetalleNota.getNotaSeguimiento());
		return detalleNota;
	}

}

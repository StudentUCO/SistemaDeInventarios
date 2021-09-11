package co.com.k4soft.sistemanotas;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.k4soft.sistemanotas.comando.ComandoDetalleNota;
import co.com.k4soft.sistemanotas.converter.DetalleNotaConverter;
import co.com.k4soft.sistemanotas.validador.excepcion.ExcepcionValorObligatorio;

class DetalleNotaConverterTest {
	
	private static final String EL_ID_ASIGNATURA_NO_ES_VALIDO = "El id asignatura no es válido";
	private static final String EL_ID_ESTUDIANTE_NO_ES_VALIDO = "El id estudiante no es válido";

	@Test
	void  crearFallaIdAsignatura() {
		var detalleNotaConverter = new DetalleNotaConverter();
		var comandoDetalleNota = new ComandoDetalleNota();
		try {
			detalleNotaConverter.crear(comandoDetalleNota);
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(EL_ID_ASIGNATURA_NO_ES_VALIDO, e.getMessage());
		}
	}
	
	@Test
	void  crearFallaIdEstudiante() {
		var detalleNotaConverter = new DetalleNotaConverter();
		var comandoDetalleNota = new ComandoDetalleNota();
		comandoDetalleNota.setIdAsignatura(1);
		try {
			detalleNotaConverter.crear(comandoDetalleNota);
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(EL_ID_ESTUDIANTE_NO_ES_VALIDO, e.getMessage());
		}
	}
	
	@Test
	void  crearObjetoDetalleNota() {
		var detalleNotaConverter = new DetalleNotaConverter();
		var comandoDetalleNota = new ComandoDetalleNota();
		comandoDetalleNota.setIdAsignatura(1);
		comandoDetalleNota.setIdEstudiante(100);
		comandoDetalleNota.setNotaFinal(4);
		comandoDetalleNota.setNotaParcial(4.5);
		comandoDetalleNota.setNotaParcial(3);
		double notaEsperada = 3;
		assertEquals(notaEsperada,detalleNotaConverter.crear(comandoDetalleNota).getNotaParcial());
	
	}

}

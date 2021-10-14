package co.com.uco.sistemainventario.servicio.persona.creacion;

import co.com.uco.sistemainventario.entidad.Persona;

public interface CreacionServicioPersona {

	/**
	 * Inserta una persona
	 * @param persona
	 * @return idPersona
	 */
	Integer ejecutar(Persona persona);

}

package co.com.uco.sistemainventario.manejador.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.PersonaDTO;
import co.com.uco.sistemainventario.converter.PersonaConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.persona.creacion.CreacionServicioPersona;


@Component
public class ManejadorCreacionPersona implements ManejadorComandoRespuesta<PersonaDTO, ComandoRespuesta<Integer>> {
	
	@Autowired
	private CreacionServicioPersona creacionServicioPersona;
	
	@Autowired
	private PersonaConverter personaConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(PersonaDTO personaDTO) {
		return new ComandoRespuesta<Integer>(creacionServicioPersona.ejecutar(personaConverter.crear(personaDTO)));
	}

}

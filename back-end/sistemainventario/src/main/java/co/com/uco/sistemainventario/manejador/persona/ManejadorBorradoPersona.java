package co.com.uco.sistemainventario.manejador.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.converter.PersonaConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.persona.borrado.BorradoServicioPersona;


@Component
public class ManejadorBorradoPersona implements ManejadorComandoRespuesta<Integer, ComandoRespuesta<Integer>> {

	@Autowired
	private BorradoServicioPersona borradoServicioPersona;

	@Autowired
	private PersonaConverter personaConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(Integer idPersona) {
		return new ComandoRespuesta<Integer>(borradoServicioPersona.ejecutar(personaConverter.borrar(idPersona)));
	}

}

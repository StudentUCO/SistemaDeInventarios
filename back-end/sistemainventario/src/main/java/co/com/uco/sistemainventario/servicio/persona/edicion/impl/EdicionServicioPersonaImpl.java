package co.com.uco.sistemainventario.servicio.persona.edicion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Persona;
import co.com.uco.sistemainventario.persistencia.PersonaRepository;
import co.com.uco.sistemainventario.servicio.persona.edicion.EdicionServicioPersona;



@Service
public class EdicionServicioPersonaImpl implements EdicionServicioPersona{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Integer ejecutar(Persona persona) {
		personaRepository.save(persona);
		return persona.getIdPersona();
	}

}

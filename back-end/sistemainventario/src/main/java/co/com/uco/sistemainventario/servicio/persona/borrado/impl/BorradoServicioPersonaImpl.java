package co.com.uco.sistemainventario.servicio.persona.borrado.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Persona;
import co.com.uco.sistemainventario.persistencia.PersonaRepository;
import co.com.uco.sistemainventario.servicio.persona.borrado.BorradoServicioPersona;



@Service
public class BorradoServicioPersonaImpl implements BorradoServicioPersona{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Integer ejecutar(Persona persona) {
		personaRepository.delete(persona);
		return persona.getIdPersona();
	}

}

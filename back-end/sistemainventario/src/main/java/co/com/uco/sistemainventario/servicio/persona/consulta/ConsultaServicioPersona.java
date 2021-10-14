package co.com.uco.sistemainventario.servicio.persona.consulta;

import co.com.uco.sistemainventario.entidad.Persona;

public interface ConsultaServicioPersona {
	


	Iterable<Persona> findAll();

	Iterable<Persona> findByActivo(boolean activo);
	
	Iterable<Persona> findByNombre(String nombre);

	Persona findById(Integer idPersona);
	
	

}

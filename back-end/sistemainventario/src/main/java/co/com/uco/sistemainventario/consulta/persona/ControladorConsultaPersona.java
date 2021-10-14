package co.com.uco.sistemainventario.consulta.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.entidad.Persona;
import co.com.uco.sistemainventario.servicio.persona.consulta.ConsultaServicioPersona;



@RestController
@RequestMapping("/v1/persona")
public class ControladorConsultaPersona {
	
	@Autowired
	private ConsultaServicioPersona consultaServicioPersona;
	
	@Secured({"ROLE_ADMIN","ROLE_CONSULTA"})
	@GetMapping
	Iterable<Persona> findAll(){
		return consultaServicioPersona.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/{idPersona}")
	Persona findById(@PathVariable Integer idPersona){
		return consultaServicioPersona.findById(idPersona);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/segun-activo/{activo}")
	Iterable<Persona> findByActivo(@PathVariable boolean activo){
		return consultaServicioPersona.findByActivo(activo);
	}
	
    @Secured({"ROLE_ADMIN"})
	@GetMapping("/segun-nombre/{nombre}")
	Iterable<Persona> findByNombre(@PathVariable String nombre){
		return consultaServicioPersona.findByNombre(nombre);
	}
	


}

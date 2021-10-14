package co.com.uco.sistemainventario.controlador.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.comando.PersonaDTO;
import co.com.uco.sistemainventario.manejador.persona.ManejadorBorradoPersona;
import co.com.uco.sistemainventario.manejador.persona.ManejadorCreacionPersona;
import co.com.uco.sistemainventario.manejador.persona.ManejadorEdicionPersona;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;


@RestController
@RequestMapping("/v1/persona")
public class ComandoControladorPersona {

	@Autowired
	private ManejadorCreacionPersona manejadorCreacionPersona;
	
	@Autowired
	private ManejadorEdicionPersona manejadorEdicionPersona;
	
	@Autowired
	private ManejadorBorradoPersona manejadorBorradoPersona;


	@Secured({"ROLE_ADMIN"})
	@PostMapping
	public ComandoRespuesta<Integer> crear(@RequestBody PersonaDTO persona) {
		return manejadorCreacionPersona.ejecutar(persona);
	}
	
	
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/{idPersona}")
	public ComandoRespuesta<Integer> actualizar(@PathVariable Integer idPersona,@RequestBody PersonaDTO persona) {
		persona.setIdPersona(idPersona);
		return manejadorEdicionPersona.ejecutar(persona);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/{idPersona}")
	public ComandoRespuesta<Integer> eliminar(@PathVariable Integer idPersona) {
		return manejadorBorradoPersona.ejecutar(idPersona);
	}
	
	

}

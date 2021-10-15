package co.com.uco.sistemainventario.controlador.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.manejador.inventario.ManejadorBorradoInventario;
import co.com.uco.sistemainventario.manejador.inventario.ManejadorCreacionInventario;
import co.com.uco.sistemainventario.manejador.inventario.ManejadorEdicionInventario;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;

@RestController
@RequestMapping("/v1/inventario")
public class ComandoControladorInventario {
	
	@Autowired
	private ManejadorCreacionInventario manejadorCreacionInventario;
	
	@Autowired
	private ManejadorEdicionInventario manejadorEdicionInventario;
	
	@Autowired
	private ManejadorBorradoInventario manejadorBorradoInventario;
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping
	public ComandoRespuesta<Integer> crear(@RequestBody ComandoInventario comandoInventario){
		return manejadorCreacionInventario.ejecutar(comandoInventario);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping
	public ComandoRespuesta<Integer> editar(@RequestBody ComandoInventario comandoInventario){
		return manejadorEdicionInventario.ejecutar(comandoInventario);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/{idInventario}")
	public ComandoRespuesta<Integer> borrar(@PathVariable Integer idInventario){
		return manejadorBorradoInventario.ejecutar(idInventario);
	}
	
}

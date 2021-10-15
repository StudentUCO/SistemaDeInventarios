package co.com.uco.sistemainventario.controlador.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.comando.ComandoProducto;
import co.com.uco.sistemainventario.manejador.producto.ManejadorBorradoProducto;
import co.com.uco.sistemainventario.manejador.producto.ManejadorCreacionProducto;
import co.com.uco.sistemainventario.manejador.producto.ManejadorEdicionProducto;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;

@RestController
@RequestMapping("/v1/producto")
public class ComandoControladorProducto {
	@Autowired
	private ManejadorCreacionProducto manejadorCreacionProducto;
	
	@Autowired
	private ManejadorEdicionProducto manejadorEdicionProducto;
	
	@Autowired
	private ManejadorBorradoProducto manejadorBorradoProducto;
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping
	public ComandoRespuesta<Integer> crear(@RequestBody ComandoProducto comandoProducto){
		return manejadorCreacionProducto.ejecutar(comandoProducto);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/{idProducto}")
	public ComandoRespuesta<Integer> actualizar(@PathVariable Integer idProducto,@RequestBody ComandoProducto comandoProducto) {
		comandoProducto.setIdProducto(idProducto);
		return manejadorEdicionProducto.ejecutar(comandoProducto);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/{idProducto}")
	public ComandoRespuesta<Integer> eliminar(@PathVariable Integer idProducto) {
		return manejadorBorradoProducto.ejecutar(idProducto);
	}
}

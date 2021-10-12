package co.com.uco.sistemainventario.controlador.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.comando.ComandoProducto;
import co.com.uco.sistemainventario.manejador.producto.ManejadorCreacionProducto;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;

@RestController
@RequestMapping("/v1/producto")
public class ComandoControladorProducto {
	@Autowired
	private ManejadorCreacionProducto manejadorCreacionProducto;
	
	@PostMapping
	public ComandoRespuesta<Integer> crear(@RequestBody ComandoProducto comandoProducto){
		return manejadorCreacionProducto.ejecutar(comandoProducto);
	}
}

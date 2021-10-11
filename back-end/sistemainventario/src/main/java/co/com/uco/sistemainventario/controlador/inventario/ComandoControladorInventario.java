package co.com.uco.sistemainventario.controlador.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.manejador.inventario.ManejadorCreacionInventario;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;

@RestController
@RequestMapping("/v1/inventario")
public class ComandoControladorInventario {
	
	@Autowired
	private ManejadorCreacionInventario manejadorCreacionInventario;
	
	@PostMapping
	public ComandoRespuesta<Integer> crear(@RequestBody ComandoInventario comandoInventario){
		return manejadorCreacionInventario.ejecutar(comandoInventario);
	}
	
}

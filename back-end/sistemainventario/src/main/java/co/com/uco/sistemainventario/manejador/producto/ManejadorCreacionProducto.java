package co.com.uco.sistemainventario.manejador.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.ComandoProducto;
import co.com.uco.sistemainventario.converter.ProductoConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.producto.creacion.CreacionServicioProducto;

@Component
public class ManejadorCreacionProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Integer>> {

	@Autowired
	private CreacionServicioProducto creacionServicioProducto;
	
	@Autowired
	private ProductoConverter productoConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(ComandoProducto comandoProducto) {
		return new ComandoRespuesta<Integer>(creacionServicioProducto.ejecutar(productoConverter.crear(comandoProducto)));
	}

}

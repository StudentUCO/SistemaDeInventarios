package co.com.uco.sistemainventario.manejador.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.converter.ProductoConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.producto.borrado.BorradoServicioProducto;

@Component
public class ManejadorBorradoProducto implements ManejadorComandoRespuesta<Integer, ComandoRespuesta<Integer>> {

	@Autowired
	private BorradoServicioProducto borradoServicioProducto;

	@Autowired
	private ProductoConverter productoConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(Integer idProducto) {
		return new ComandoRespuesta<Integer>(borradoServicioProducto.ejecutar(productoConverter.borrar(idProducto)));
	}

}
package co.com.uco.sistemainventario.manejador.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.converter.InventarioConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.inventario.borrado.BorradoServicioInventario;

@Component
public class ManejadorBorradoInventario implements ManejadorComandoRespuesta<Integer, ComandoRespuesta<Integer>> {

	@Autowired
	private BorradoServicioInventario borradoServicioInventario;
	
	@Autowired
	private InventarioConverter inventarioConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(Integer idInventario) {
		return new ComandoRespuesta<>(borradoServicioInventario.ejecutar(inventarioConverter.borrar(idInventario)));
	}
	
}

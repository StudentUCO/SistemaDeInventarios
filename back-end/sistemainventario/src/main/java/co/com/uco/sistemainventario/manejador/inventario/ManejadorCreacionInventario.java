package co.com.uco.sistemainventario.manejador.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.converter.InventarioConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.inventario.creacion.CreacionServicioInventario;

@Component
public class ManejadorCreacionInventario implements ManejadorComandoRespuesta<ComandoInventario, ComandoRespuesta<Integer>> {
	
	@Autowired
	private CreacionServicioInventario creacionServicioInventario;
	
	@Autowired
	private InventarioConverter inventarioConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(ComandoInventario comandoInventario) {
		return new ComandoRespuesta<Integer>(creacionServicioInventario.ejecutar(inventarioConverter.crear(comandoInventario)));
	}

}

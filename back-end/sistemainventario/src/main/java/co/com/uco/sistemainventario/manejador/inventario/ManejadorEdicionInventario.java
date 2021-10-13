package co.com.uco.sistemainventario.manejador.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.converter.InventarioConverter;
import co.com.uco.sistemainventario.respuesta.ComandoRespuesta;
import co.com.uco.sistemainventario.respuesta.impl.ManejadorComandoRespuesta;
import co.com.uco.sistemainventario.servicio.inventario.edicion.EdicionServicioInventario;

@Component
public class ManejadorEdicionInventario implements ManejadorComandoRespuesta<ComandoInventario, ComandoRespuesta<Integer>> {

	@Autowired
	private EdicionServicioInventario edicionServicioInventario;
	
	@Autowired
	private InventarioConverter inventarioConverter;

	@Override
	public ComandoRespuesta<Integer> ejecutar(ComandoInventario comandoInventario) {
		return new ComandoRespuesta<>(edicionServicioInventario.ejecutar(inventarioConverter.editar(comandoInventario)));
	}

}

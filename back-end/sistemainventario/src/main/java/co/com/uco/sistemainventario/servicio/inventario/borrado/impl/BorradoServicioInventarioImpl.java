package co.com.uco.sistemainventario.servicio.inventario.borrado.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.persistencia.InventarioRepository;
import co.com.uco.sistemainventario.servicio.inventario.borrado.BorradoServicioInventario;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionNoExisteRegistro;

@Service
public class BorradoServicioInventarioImpl implements BorradoServicioInventario {
	
	private static final String NO_EXISTE_INVENTARIO = "No existe el inventario";
	
	@Autowired
	private InventarioRepository inventarioRepository;

	@Override
	public Integer ejecutar(Inventario inventario) {
		inventario = buscarInventario(inventario);
		inventarioRepository.delete(inventario);
		return inventario.getIdInventario();
	}
	
	private Inventario buscarInventario(Inventario inventario) {
		return inventarioRepository.findById(inventario.getIdInventario())
				.orElseThrow(() -> new ExcepcionNoExisteRegistro(NO_EXISTE_INVENTARIO));
	}

}

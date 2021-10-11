package co.com.uco.sistemainventario.servicio.inventario.creacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.InventarioRepository;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.inventario.creacion.CreacionServicioInventario;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionNoExisteRegistro;

@Service
public class CreacionServicioInventarioImpl implements CreacionServicioInventario {
	
	private static final String NO_EXISTE_PRODUCTO = "No existe el producto";

	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Autowired ProductoRepository productoRepository;

	@Override
	public Integer ejecutar(Inventario inventario) {
		Producto producto = buscarProducto(inventario);
		inventario.setProducto(producto);
		inventarioRepository.save(inventario);
		return inventario.getIdInventario();
	}

	private Producto buscarProducto(Inventario inventario) {
		return productoRepository.findById(inventario.getProducto().getIdProducto())
				.orElseThrow(() -> new ExcepcionNoExisteRegistro(NO_EXISTE_PRODUCTO));
	}

}

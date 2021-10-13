package co.com.uco.sistemainventario.servicio.inventario.edicion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.InventarioRepository;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.inventario.edicion.EdicionServicioInventario;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionNoExisteRegistro;

@Service
public class EdicionServicioInventarioImpl implements EdicionServicioInventario{

	private static final String NO_EXISTE_INVENTARIO = "No existe el inventario";
	private static final String NO_EXISTE_PRODUCTO = "No existe el producto";

	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Autowired ProductoRepository productoRepository;

	@Override
	public Integer ejecutar(Inventario inventario) {
		Inventario inventarioAnterior = buscarInventario(inventario);
		Producto producto = buscarProducto(inventario);
		inventarioAnterior.setProducto(producto);
		inventarioAnterior.setCantidad(inventario.getCantidad());
		inventarioRepository.save(inventarioAnterior);
		return inventarioAnterior.getIdInventario();
	}
	
	private Inventario buscarInventario(Inventario inventario) {
		return inventarioRepository.findById(inventario.getIdInventario())
				.orElseThrow(() -> new ExcepcionNoExisteRegistro(NO_EXISTE_INVENTARIO));
	}

	private Producto buscarProducto(Inventario inventario) {
		return productoRepository.findById(inventario.getProducto().getIdProducto())
				.orElseThrow(() -> new ExcepcionNoExisteRegistro(NO_EXISTE_PRODUCTO));
	}

}

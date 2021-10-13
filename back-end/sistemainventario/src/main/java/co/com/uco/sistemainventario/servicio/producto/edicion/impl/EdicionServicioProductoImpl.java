package co.com.uco.sistemainventario.servicio.producto.edicion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.edicion.EdicionServicioProducto;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionNoExisteRegistro;

@Service
public class EdicionServicioProductoImpl implements EdicionServicioProducto {
	
	private static final String NO_EXISTE_PRODUCTO = "No existe el producto";
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Integer ejecutar(Producto producto) {
		Producto productoAnterior = buscarProducto(producto);
		productoAnterior.setNombre(producto.getNombre());
		productoAnterior.setCodigo(producto.getCodigo());
		productoAnterior.setActivo(producto.isActivo());
		productoRepository.save(productoAnterior);
		return producto.getIdProducto();
	}
	
	private Producto buscarProducto(Producto producto) {
		return productoRepository.findById(producto.getIdProducto())
				.orElseThrow(() -> new ExcepcionNoExisteRegistro(NO_EXISTE_PRODUCTO));
	}
}

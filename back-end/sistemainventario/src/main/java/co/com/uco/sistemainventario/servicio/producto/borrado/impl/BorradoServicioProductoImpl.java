package co.com.uco.sistemainventario.servicio.producto.borrado.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.InventarioRepository;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.borrado.BorradoServicioProducto;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionRegistroEnUso;

@Service
public class BorradoServicioProductoImpl implements BorradoServicioProducto {
	
	private static final String PRODUCTO_EN_INVENTARIO = "No se puese borrar el producto debido a que está siendo utilizado en un inventario";

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private InventarioRepository inventarioRepository;

	@Override
	public Integer ejecutar(Producto producto) {
		validarQueProductoNoEsteAsociadoAUnInventario(producto);
		productoRepository.delete(producto);
		return producto.getIdProducto();
	}
	
	private void validarQueProductoNoEsteAsociadoAUnInventario(Producto producto) {
		if (!inventarioRepository.findAllByProducto(producto).isEmpty()) {
			throw new ExcepcionRegistroEnUso(PRODUCTO_EN_INVENTARIO);
		}
	}

}

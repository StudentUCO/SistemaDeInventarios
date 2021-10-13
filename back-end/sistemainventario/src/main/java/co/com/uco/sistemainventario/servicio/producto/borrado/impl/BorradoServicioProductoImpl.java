package co.com.uco.sistemainventario.servicio.producto.borrado.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.borrado.BorradoServicioProducto;

@Service
public class BorradoServicioProductoImpl implements BorradoServicioProducto {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Integer ejecutar(Producto producto) {
		productoRepository.delete(producto);
		return producto.getIdProducto();
	}

}

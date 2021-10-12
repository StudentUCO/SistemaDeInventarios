package co.com.uco.sistemainventario.servicio.producto.creacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.creacion.CreacionServicioProducto;

@Service
public class CreacionServicioProductoImpl implements CreacionServicioProducto {

	@Autowired
	private ProductoRepository productoRepository;
	

	@Override
	public Integer ejecutar(Producto producto) {
		productoRepository.save(producto);
		return producto.getIdProducto();
	}

}

package co.com.uco.sistemainventario.servicio.producto.creacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.creacion.CreacionServicioProducto;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionRegistroEnUso;

@Service
public class CreacionServicioProductoImpl implements CreacionServicioProducto {

	private static final String CODIGO_EXISTE = "No se puese crear el producto debido a que el codigo ya existe";
	
	@Autowired
	private ProductoRepository productoRepository;
	

	@Override
	public Integer ejecutar(Producto producto) {
		validarQueProductoNoEsteAsociadoAUnCodigo(producto);
		productoRepository.save(producto);
		return producto.getIdProducto();
	}
	
	private void validarQueProductoNoEsteAsociadoAUnCodigo(Producto producto) {
		if (!productoRepository.findAllByCodigo(producto.getCodigo()).isEmpty()) {
			throw new ExcepcionRegistroEnUso(CODIGO_EXISTE);
		}
	}

}

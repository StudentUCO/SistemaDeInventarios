package co.com.uco.sistemainventario.servicio.producto.consulta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.persistencia.ProductoRepository;
import co.com.uco.sistemainventario.servicio.producto.consulta.ConsultaServicioProducto;

@Service
public class ConsultaServicioProductoImpl implements ConsultaServicioProducto {

	@Autowired
	private ProductoRepository repository;

	@Override
	public Iterable<Producto> findAll() {
		return repository.findAll();
	}
}

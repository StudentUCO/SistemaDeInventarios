package co.com.uco.sistemainventario.servicio.inventario.consulta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.persistencia.InventarioRepository;
import co.com.uco.sistemainventario.servicio.inventario.consulta.ConsultaServicioInventario;

@Service
public class ConsultaServicioInventarioImpl implements ConsultaServicioInventario{
	
	@Autowired
	private InventarioRepository repository;

	@Override
	public Iterable<Inventario> findAll() {
		return repository.findAll();
	}

}

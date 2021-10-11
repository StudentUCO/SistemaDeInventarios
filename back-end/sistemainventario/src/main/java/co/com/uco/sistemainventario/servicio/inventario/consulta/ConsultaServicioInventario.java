package co.com.uco.sistemainventario.servicio.inventario.consulta;

import co.com.uco.sistemainventario.entidad.Inventario;


public interface ConsultaServicioInventario {
	
	Iterable<Inventario> findAll();

}

package co.com.uco.sistemainventario.servicio.producto.consulta;

import co.com.uco.sistemainventario.entidad.Producto;

public interface ConsultaServicioProducto {
	Iterable<Producto> findAll();
}

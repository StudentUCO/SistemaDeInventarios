package co.com.uco.sistemainventario.consulta.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.servicio.producto.consulta.ConsultaServicioProducto;

@RestController
@RequestMapping("/v1/producto")
public class ControladorConsultaProducto {
	@Autowired
	private ConsultaServicioProducto consultaServicioProducto;
	
	@Secured({"ROLE_ADMIN","ROLE_CONSULTA"})
	@GetMapping
	Iterable<Producto> findAll() {
		return consultaServicioProducto.findAll();
	}
}

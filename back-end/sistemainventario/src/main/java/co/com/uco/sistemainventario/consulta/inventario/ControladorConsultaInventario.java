package co.com.uco.sistemainventario.consulta.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.servicio.inventario.consulta.ConsultaServicioInventario;

@RestController
@RequestMapping("/v1/inventario")
public class ControladorConsultaInventario {
	
	@Autowired
	private ConsultaServicioInventario consultaServicioInventario;
	
	@Secured({"ROLE_ADMIN","ROLE_CONSULTA"})
	@GetMapping
	Iterable<Inventario> findAll() {
		return consultaServicioInventario.findAll();
	}

}

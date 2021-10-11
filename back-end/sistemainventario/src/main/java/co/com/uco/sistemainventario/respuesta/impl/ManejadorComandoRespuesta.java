package co.com.uco.sistemainventario.respuesta.impl;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<C, R> {
	
	@Transactional
	R ejecutar(C comando);

}

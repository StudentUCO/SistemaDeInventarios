package co.com.uco.sistemainventario.respuesta.impl;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {
	
	@Transactional
	void ejecutar(C comando);

}

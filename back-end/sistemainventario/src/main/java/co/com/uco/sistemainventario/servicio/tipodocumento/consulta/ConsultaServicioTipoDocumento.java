package co.com.uco.sistemainventario.servicio.tipodocumento.consulta;

import co.com.uco.sistemainventario.entidad.TipoDocumento;

public interface ConsultaServicioTipoDocumento {

	 Iterable<TipoDocumento> findAll();

}

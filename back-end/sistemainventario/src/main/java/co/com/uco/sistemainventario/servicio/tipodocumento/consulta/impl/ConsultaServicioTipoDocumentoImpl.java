package co.com.uco.sistemainventario.servicio.tipodocumento.consulta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.uco.sistemainventario.entidad.TipoDocumento;
import co.com.uco.sistemainventario.persistencia.TipoDocumentoRepository;
import co.com.uco.sistemainventario.servicio.tipodocumento.consulta.ConsultaServicioTipoDocumento;



@Service
public class ConsultaServicioTipoDocumentoImpl implements ConsultaServicioTipoDocumento{
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Override
	public Iterable<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}

}

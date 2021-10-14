package co.com.uco.sistemainventario.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.uco.sistemainventario.entidad.TipoDocumento;


@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Integer> {

}

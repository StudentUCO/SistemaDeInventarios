package co.com.uco.sistemainventario.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.uco.sistemainventario.entidad.seguridad.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	
	Usuario findByNombreUsuario(String nombreUsuario);

}

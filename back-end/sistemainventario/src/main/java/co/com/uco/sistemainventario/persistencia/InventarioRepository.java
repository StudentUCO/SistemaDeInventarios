package co.com.uco.sistemainventario.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.uco.sistemainventario.entidad.Inventario;

@Repository
public interface InventarioRepository extends CrudRepository<Inventario, Integer>{

}

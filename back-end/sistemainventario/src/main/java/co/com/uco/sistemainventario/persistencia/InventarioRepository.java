package co.com.uco.sistemainventario.persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.entidad.Producto;

@Repository
public interface InventarioRepository extends CrudRepository<Inventario, Integer>{
	
	public List<Inventario> findAllByProducto(Producto producto);

}

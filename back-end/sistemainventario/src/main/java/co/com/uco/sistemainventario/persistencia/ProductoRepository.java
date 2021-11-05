package co.com.uco.sistemainventario.persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.uco.sistemainventario.entidad.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	public List<Producto> findAllByCodigo(String codigo);
}

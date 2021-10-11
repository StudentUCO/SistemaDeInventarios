package co.com.uco.sistemainventario.persistencia;

import org.springframework.data.repository.CrudRepository;

import co.com.uco.sistemainventario.entidad.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}

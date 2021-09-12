package co.com.uco.sistemainventario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.entidad.Producto;

class InventarioTest {
	
	@Test
	void crearProductoInventario() {
		var inventario = new Inventario();
		var producto = new Producto();
		producto.setIdProducto(1);
		inventario.setProducto(producto);
		assertEquals(producto, inventario.getProducto());
		assertEquals(producto.getIdProducto(), inventario.getProducto().getIdProducto());
	}

}

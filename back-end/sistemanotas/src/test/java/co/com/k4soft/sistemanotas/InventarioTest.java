package co.com.k4soft.sistemanotas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.k4soft.sistemanotas.entidad.Inventario;
import co.com.k4soft.sistemanotas.entidad.Producto;

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

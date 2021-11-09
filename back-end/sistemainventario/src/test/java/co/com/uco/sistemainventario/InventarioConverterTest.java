package co.com.uco.sistemainventario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.converter.InventarioConverter;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionValorObligatorio;

class InventarioConverterTest {
	
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_ID_INVENTARIO_NO_ES_VALIDO = "El id inventario no es válido";
	private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA = "La cantidad no puede ser negativa";
	
	@Test
	void crearFallaIdInventario() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		try {
			inventarioConverter.editar(comandoInventario);
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(EL_ID_INVENTARIO_NO_ES_VALIDO, e.getMessage());
		}
	}
	
	@Test
	void crearFallaIdProducto() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		comandoInventario.setIdInventario(1);
		try {
			inventarioConverter.crear(comandoInventario);
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(EL_ID_PRODUCTO_NO_ES_VALIDO, e.getMessage());
		}
	}
	
	@Test
	void crearFallaCantidadNegativa() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		comandoInventario.setIdInventario(1);
		comandoInventario.setIdProducto(1);
		comandoInventario.setCantidad(-1);
		try {
			inventarioConverter.crear(comandoInventario);
		} catch (Exception e) {
			assertEquals(LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA, e.getMessage());
		}
	}
	
	@Test
	void crearObjetoInventario() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		comandoInventario.setIdInventario(1);
		comandoInventario.setIdProducto(1);
		comandoInventario.setCantidad(100);
		Integer idInventarioEsperado = 1;
		Integer idProductoEsperado = 1;
		int cantidadEsperada = 100;
		var inventario = inventarioConverter.editar(comandoInventario);
		assertEquals(idInventarioEsperado, inventario.getIdInventario());
		assertEquals(idProductoEsperado, inventario.getProducto().getIdProducto());
		assertEquals(cantidadEsperada, inventario.getCantidad());
	}

}

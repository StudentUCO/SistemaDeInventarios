package co.com.k4soft.sistemanotas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.k4soft.sistemanotas.comando.ComandoInventario;
import co.com.k4soft.sistemanotas.converter.InventarioConverter;
import co.com.k4soft.sistemanotas.validador.excepcion.ExcepcionValorObligatorio;

class InventarioConverterTest {
	
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_ID_INVENTARIO_NO_ES_VALIDO = "El id inventario no es válido";
	
	@Test
	void crearFallaIdInventario() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		try {
			inventarioConverter.crear(comandoInventario);
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
	void crearObjetoInventario() {
		var inventarioConverter = new InventarioConverter();
		var comandoInventario = new ComandoInventario();
		comandoInventario.setIdInventario(1);
		comandoInventario.setIdProducto(1);
		comandoInventario.setCantidad(100);
		Integer idInventarioEsperado = 1;
		Integer idProductoEsperado = 1;
		int cantidadEsperada = 100;
		var inventario = inventarioConverter.crear(comandoInventario);
		assertEquals(idInventarioEsperado, inventario.getIdInventario());
		assertEquals(idProductoEsperado, inventario.getProducto().getIdProducto());
		assertEquals(cantidadEsperada, inventario.getCantidad());
	}

}

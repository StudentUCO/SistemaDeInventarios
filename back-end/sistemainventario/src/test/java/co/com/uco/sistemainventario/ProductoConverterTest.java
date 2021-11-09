package co.com.uco.sistemainventario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.com.uco.sistemainventario.comando.ComandoProducto;
import co.com.uco.sistemainventario.converter.ProductoConverter;
import co.com.uco.sistemainventario.validador.excepcion.ExcepcionValorObligatorio;

class ProductoConverterTest {

	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";

	@Test
	void crearFallaIdProducto() {
		var productoConverter = new ProductoConverter();
		var comandoProducto = new ComandoProducto();
		try {
			productoConverter.editar(comandoProducto);
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(EL_ID_PRODUCTO_NO_ES_VALIDO, e.getMessage());
		}
	}
	
	@Test
	void crearObjetoProducto() {
		var productoConverter = new ProductoConverter();
		var comandoProducto = new ComandoProducto();
		comandoProducto.setIdProducto(1);
		comandoProducto.setCodigo("0001");
		comandoProducto.setNombre("MPU6050");
		comandoProducto.setActivo(true);
		Integer idProductoEsperado = 1;
		String codigoEsperado = "0001";
		String nombreEsperado = "MPU6050";
		boolean activoEsperado = true;
		var producto = productoConverter.editar(comandoProducto);
		assertEquals(idProductoEsperado, producto.getIdProducto());
		assertEquals(codigoEsperado, producto.getCodigo());
		assertEquals(nombreEsperado, producto.getNombre());
		assertEquals(activoEsperado, producto.isActivo());
	}
	
}

package co.com.k4soft.sistemanotas.converter;

import org.springframework.stereotype.Component;

import co.com.k4soft.sistemanotas.comando.ComandoInventario;
import co.com.k4soft.sistemanotas.entidad.Inventario;
import co.com.k4soft.sistemanotas.validador.ValidadorArgumento;

@Component
public class InventarioConverter {

	private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA = "La cantidad no puede ser negativa";
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_ID_INVENTARIO_NO_ES_VALIDO = "El id inventario no es válido";

	public Inventario crear(ComandoInventario comandoInventario) {
		Inventario inventario = new Inventario();
		ValidadorArgumento.validarObligatorio(comandoInventario.getIdInventario(), EL_ID_INVENTARIO_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoInventario.getIdProducto(), EL_ID_PRODUCTO_NO_ES_VALIDO);
		ValidadorArgumento.validarNegativo(comandoInventario.getCantidad(), LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);
		inventario.setIdInventario(comandoInventario.getIdInventario());
		inventario.getProducto().setIdProducto(comandoInventario.getIdProducto());
		inventario.setCantidad(comandoInventario.getCantidad());
		return inventario;
	}
	
}

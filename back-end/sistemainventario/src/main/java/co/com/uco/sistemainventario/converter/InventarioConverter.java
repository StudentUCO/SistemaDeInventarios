package co.com.uco.sistemainventario.converter;

import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.ComandoInventario;
import co.com.uco.sistemainventario.entidad.Inventario;
import co.com.uco.sistemainventario.validador.ValidadorArgumento;

@Component
public class InventarioConverter {

	private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA = "La cantidad no puede ser negativa";
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_ID_INVENTARIO_NO_ES_VALIDO = "El id inventario no es válido";

	public Inventario crear(ComandoInventario comandoInventario) {
		Inventario inventario = new Inventario();
		ValidadorArgumento.validarObligatorio(comandoInventario.getIdProducto(), EL_ID_PRODUCTO_NO_ES_VALIDO);
		ValidadorArgumento.validarNegativo(comandoInventario.getCantidad(), LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);
		inventario.getProducto().setIdProducto(comandoInventario.getIdProducto());
		inventario.setCantidad(comandoInventario.getCantidad());
		return inventario;
	}
	
	public Inventario editar(ComandoInventario comandoInventario) {
		Inventario inventario = new Inventario();
		ValidadorArgumento.validarObligatorio(comandoInventario.getIdInventario(), EL_ID_INVENTARIO_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoInventario.getIdProducto(), EL_ID_PRODUCTO_NO_ES_VALIDO);
		ValidadorArgumento.validarNegativo(comandoInventario.getCantidad(), LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);
		inventario.setIdInventario(comandoInventario.getIdInventario());
		inventario.getProducto().setIdProducto(comandoInventario.getIdProducto());
		inventario.setCantidad(comandoInventario.getCantidad());
		return inventario;
	}
	
	public Inventario borrar(Integer idInventario) {
		ValidadorArgumento.validarPositivo(idInventario, EL_ID_INVENTARIO_NO_ES_VALIDO);
		Inventario inventario = new Inventario();
		inventario.setIdInventario(idInventario);
		return inventario;
	}
	
}

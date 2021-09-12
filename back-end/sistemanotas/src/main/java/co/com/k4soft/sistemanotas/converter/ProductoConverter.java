package co.com.k4soft.sistemanotas.converter;

import org.springframework.stereotype.Component;

import co.com.k4soft.sistemanotas.comando.ComandoProducto;
import co.com.k4soft.sistemanotas.entidad.Producto;
import co.com.k4soft.sistemanotas.validador.ValidadorArgumento;

@Component
public class ProductoConverter {
	
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_CODIGO_NO_ES_VALIDO = "El código no es válido";
	private static final String EL_NOMBRE_NO_ES_VALIDO = "El nombre no es válido";

	public Producto crear(ComandoProducto comandoProducto) {
		Producto producto = new Producto();
		ValidadorArgumento.validarObligatorio(comandoProducto.getIdProducto(), EL_ID_PRODUCTO_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoProducto.getCodigo(), EL_CODIGO_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoProducto.getNombre(), EL_NOMBRE_NO_ES_VALIDO);
		producto.setIdProducto(comandoProducto.getIdProducto());
		producto.setCodigo(comandoProducto.getCodigo());
		producto.setNombre(comandoProducto.getNombre());
		producto.setActivo(comandoProducto.isActivo());
		return producto;
	}

}

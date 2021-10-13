package co.com.uco.sistemainventario.converter;

import org.springframework.stereotype.Component;

import co.com.uco.sistemainventario.comando.ComandoProducto;
import co.com.uco.sistemainventario.entidad.Producto;
import co.com.uco.sistemainventario.validador.ValidadorArgumento;

@Component
public class ProductoConverter {
	
	private static final String EL_CODIGO_NO_ES_VALIDO = "El código no es válido";
	private static final String EL_NOMBRE_NO_ES_VALIDO = "El nombre no es válido";
	private static final String EL_ID_PRODUCTO_NO_ES_VALIDO = "El id producto no es válido";
	private static final String EL_ID_NO_ES_VALIDO = "El id no es valido";
	
	public Producto crear(ComandoProducto comandoProducto) {
		Producto producto = new Producto();
		ValidadorArgumento.validarObligatorio(comandoProducto.getCodigo(), EL_CODIGO_NO_ES_VALIDO);
		ValidadorArgumento.validarObligatorio(comandoProducto.getNombre(), EL_NOMBRE_NO_ES_VALIDO);
		producto.setCodigo(comandoProducto.getCodigo());
		producto.setNombre(comandoProducto.getNombre());
		producto.setActivo(comandoProducto.isActivo());
		return producto;
	}
	
	public Producto editar(ComandoProducto comandoProducto) {
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
	
	public Producto borrar(Integer idProducto) {
		ValidadorArgumento.validarPositivo(idProducto, EL_ID_NO_ES_VALIDO);
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		return producto;
	}

}

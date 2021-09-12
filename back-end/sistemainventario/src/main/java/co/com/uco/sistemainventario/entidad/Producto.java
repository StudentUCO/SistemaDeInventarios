package co.com.uco.sistemainventario.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

	private Integer idProducto;
	private String nombre;
	private String codigo;
	private boolean activo;
	
}

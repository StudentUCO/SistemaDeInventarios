package co.com.uco.sistemainventario.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoProducto {
	
	private Integer idProducto;
	private String nombre;
	private String codigo;
	private boolean activo;

}

package co.com.uco.sistemainventario.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventario {
	
	private Integer idInventario;
	private Producto producto;
	private int cantidad;
	
	public Producto getProducto() {
		if (producto == null) producto = new Producto();
		return producto;
	}

}

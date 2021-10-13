package co.com.uco.sistemainventario.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inventario")
@Getter
@Setter
public class Inventario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idinventario")
	private Integer idInventario;
	
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private Producto producto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	public Producto getProducto() {
		if (producto == null) producto = new Producto();
		return producto;
	}

}

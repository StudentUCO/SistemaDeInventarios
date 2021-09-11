package co.com.k4soft.sistemanotas.validador.excepcion;

public class ExcepcionSinDatos extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionSinDatos(String message) {
        super(message);
    }
}

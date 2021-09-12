package co.com.uco.sistemainventario.validador.excepcion;

public class ExcepcionNoExisteRegistro extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNoExisteRegistro(String mensaje) {
        super(mensaje);
    }
}

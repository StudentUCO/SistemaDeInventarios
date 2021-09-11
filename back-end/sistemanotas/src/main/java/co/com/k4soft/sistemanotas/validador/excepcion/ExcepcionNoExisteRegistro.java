package co.com.k4soft.sistemanotas.validador.excepcion;

public class ExcepcionNoExisteRegistro extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNoExisteRegistro(String mensaje) {
        super(mensaje);
    }
}

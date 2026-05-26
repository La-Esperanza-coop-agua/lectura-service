package cl.esperanza.lectura.exception;

public class LecturaInvalidaException 
        extends RuntimeException {

    public LecturaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
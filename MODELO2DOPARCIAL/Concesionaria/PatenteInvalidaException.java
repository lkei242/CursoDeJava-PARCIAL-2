package Concesionaria;

/**
 * Excepción personalizada que se lanza cuando se intenta crear un vehículo con un formato de
 * patente incorrecto. Al heredar de `Exception`, se convierte en una "checked exception", lo que
 * obliga a manejarla explícitamente con un bloque try-catch.
 */
public class PatenteInvalidaException extends Exception {
    /**
     * Constructor que permite crear la excepción con un mensaje de error específico.
     */
    public PatenteInvalidaException(String message) {
        super(message);
    }
}

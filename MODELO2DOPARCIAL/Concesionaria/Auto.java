package Concesionaria;

/**
 * Representa un vehículo de tipo Auto. Hereda de la clase `Vehiculo` y también implementa la
 * interfaz `Mantenimiento`, lo que le obliga a definir cómo se calcula su costo de mantenimiento.
 */
public class Auto extends Vehiculo implements Mantenimiento {
    // Atributo específico de la clase Auto.
    private int numeroDePuertas;

    /**
     * Constructor para crear un nuevo Auto. Llama al constructor de la clase padre (`Vehiculo`)
     * para inicializar los atributos comunes.
     * 
     * @param numeroDePuertas El número de puertas del auto.
     * @throws PatenteInvalidaException si la patente es inválida (propagada desde el constructor
     *         padre).
     */
    public Auto(String marca, String modelo, int anio, String patente, double kilometraje,
            int numeroDePuertas) throws PatenteInvalidaException {
        super(marca, modelo, anio, patente, kilometraje);
        this.numeroDePuertas = numeroDePuertas;
    }

    /**
     * Implementación del método abstracto `getTipo` de la clase `Vehiculo`. Devuelve una cadena que
     * identifica a esta clase como un "Auto".
     */
    @Override
    public String getTipo() {
        return "Auto";
    }

    /**
     * Implementación del método de la interfaz `Mantenimiento`. Calcula el costo de mantenimiento
     * específico para un auto, aplicando un 10% extra.
     */
    @Override
    public double calcularCostoMantenimiento(double costoPorKm) {
        return getKilometraje() * costoPorKm * 1.1; // 10% extra para autos
    }
}

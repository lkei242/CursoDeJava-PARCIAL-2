package Concesionaria;

/**
 * Representa un vehículo de tipo Camión. Hereda de la clase `Vehiculo` y también implementa la
 * interfaz `Mantenimiento`, lo que le obliga a definir cómo se calcula su costo de mantenimiento.
 */
public class Camion extends Vehiculo implements Mantenimiento {
    // Atributo específico de la clase Camion.
    private double capacidadDeCarga;

    /**
     * Constructor para crear un nuevo Camión. Llama al constructor de la clase padre (`Vehiculo`)
     * para inicializar los atributos comunes.
     * 
     * @param capacidadDeCarga La capacidad de carga del camión en toneladas.
     * @throws PatenteInvalidaException si la patente es inválida (propagada desde el constructor
     *         padre).
     */
    public Camion(String marca, String modelo, int anio, String patente, double kilometraje,
            double capacidadDeCarga) throws PatenteInvalidaException {
        super(marca, modelo, anio, patente, kilometraje);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    /**
     * Implementación del método abstracto `getTipo` de la clase `Vehiculo`. Devuelve una cadena que
     * identifica a esta clase como un "Camión".
     */
    @Override
    public String getTipo() {
        return "Camión";
    }

    /**
     * Implementación del método de la interfaz `Mantenimiento`. Calcula el costo de mantenimiento
     * específico para un camión, aplicando un 50% extra.
     */
    @Override
    public double calcularCostoMantenimiento(double costoPorKm) {
        return getKilometraje() * costoPorKm * 1.5; // 50% extra para camiones
    }
}

package Concesionaria;

/**
 * La interfaz `Mantenimiento` define un contrato para las clases que la implementen. Cualquier
 * clase que represente un tipo de vehículo que requiera un cálculo de costo de mantenimiento debe
 * implementar esta interfaz. Esto asegura que todas esas clases tendrán un método
 * `calcularCostoMantenimiento`.
 */
public interface Mantenimiento {
    /**
     * Calcula el costo de mantenimiento del vehículo basado en un costo por kilómetro.
     */
    double calcularCostoMantenimiento(double costoPorKm);
}

//Ejercicio 7.2

import java.util.Arrays;
import java.util.List;

class Estudiante72 {
    String nombre;
    double promedio;

    Estudiante72(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " - Promedio: " + promedio;
    }
}

public class Programa42 {
    public static void main(String[] args) {
        List<Estudiante72> estudiantes = Arrays.asList(
            new Estudiante72("Ana", 8.5),
            new Estudiante72("Bruno", 6.3),
            new Estudiante72("Carla", 9.0)
        );

        System.out.println("=== Estudiantes con promedio >= 7 ===");
        estudiantes.stream()
                   .filter(e -> e.getPromedio() >= 7)
                   .forEach(e -> System.out.println(e.getNombre()));

        System.out.println("\n=== Todos los promedios ===");
        estudiantes.stream()
                   .map(Estudiante72::getPromedio) //Método de referencia
                   .forEach(System.out::println);
    }
}
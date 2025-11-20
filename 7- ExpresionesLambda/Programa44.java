//Ejercicio 7.4

import java.util.Arrays;
import java.util.List;

class Arbol {
    String especie;
    int anioPlantacion;

    Arbol(String especie, int anioPlantacion) {
        this.especie = especie;
        this.anioPlantacion = anioPlantacion;
    }

    public int getEdad(int anioActual) {
        return anioActual - anioPlantacion;
    }

    @Override
    public String toString() {
        return especie + " (" + anioPlantacion + ")";
    }
}

public class Programa44 {
    public static void main(String[] args) {
        int anioActual = 2025;

        List<Arbol> arboles = Arrays.asList(
            new Arbol("Roble", 2010),
            new Arbol("Pino", 2018),
            new Arbol("Eucalipto", 2000)
        );

        System.out.println("=== Años de cada árbol en 2025 ===");
        arboles.forEach(a -> System.out.println(a.especie + ": " + a.getEdad(anioActual) + " años"));

        System.out.println("\n=== Información completa ===");
        arboles.forEach(System.out::println); // Método de referencia (toString)
    }   
}
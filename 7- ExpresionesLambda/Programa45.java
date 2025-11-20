//Ejercicio 7.5 

import java.util.Arrays;
import java.util.List;

class Empleado75 {
    String nombre;
    double sueldo;

    Empleado75(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void aumentarSueldo(double porcentaje) {
        sueldo += sueldo * porcentaje / 100;
    }

    @Override
    public String toString() {
        return nombre + " - $" + sueldo;
    }
}

public class Programa45 {
    public static void main(String[] args) {
        List<Empleado75> Empleado75s = Arrays.asList(
            new Empleado75("Ana", 180000),
            new Empleado75("Bruno", 250000),
            new Empleado75("Carla", 150000)
        );

        System.out.println("=== Aumentando sueldo en un 10% a los que ganan menos de $200.000 ===");
        Empleado75s.forEach(e -> {
            if (e.getSueldo() < 200000) {
                e.aumentarSueldo(10);
            }
        });

        System.out.println("\n=== Datos actualizados ===");
        Empleado75s.forEach(System.out::println); // Método de referencia
    }   
}
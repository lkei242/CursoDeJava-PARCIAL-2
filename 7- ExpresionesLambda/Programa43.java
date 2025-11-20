//Ejercicio 7.3

import java.util.Arrays;
import java.util.List;

class Producto73 {
    String nombre;
    double precio;

    Producto73(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}

public class Programa43 {
    public static void main(String[] args) {
        List<Producto73> Producto73s = Arrays.asList(
            new Producto73("Mouse", 5000),
            new Producto73("Teclado", 12000),
            new Producto73("Monitor", 80000)
        );

        System.out.println("=== Precios con IVA (21%) ===");
        Producto73s.forEach(p -> {
            double precioConIVA = p.getPrecio() * 1.21;
            System.out.println(p.getNombre() + ": $" + precioConIVA);
        });

        System.out.println("\n=== Precios originales ===");
        Producto73s.stream()
                 .map(Producto73::getPrecio)
                 .forEach(System.out::println);
    }   
}
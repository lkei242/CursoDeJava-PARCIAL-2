package Concesionaria;

import java.util.Scanner;

/**
 * Clase dedicada a manejar la interfaz de usuario en la consola. Su responsabilidad es mostrar el
 * menú y leer las entradas del usuario de forma robusta, evitando errores por entradas inválidas.
 */
public class MenuConsola {

    private Scanner scanner;

    /**
     * Constructor que recibe una instancia de Scanner para leer desde la consola.
     */
    public MenuConsola(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Imprime el menú principal de opciones en la consola.
     */
    public void mostrarMenu() {
        System.out.println("--- Sistema de Gestión de Flota ---");
        System.out.println("1. Registrar nuevo vehículo (Create)");
        System.out.println("2. Listar todos los vehículos (Read)");
        System.out.println("3. Actualizar kilometraje de un vehículo (Update)");
        System.out.println("4. Eliminar un vehículo (Delete)");
        System.out.println("5. Buscar vehículo por patente (Recursivo)");
        System.out.println("6. Contar vehículos por tipo (Lambda)");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee la entrada del usuario y la convierte a un entero. Incluye un bucle para reintentar en
     * caso de que el usuario ingrese texto no numérico o una línea vacía.
     */
    public int leerOpcion() {
        while (true) {
            String linea = scanner.nextLine();
            if (linea.isEmpty()) {
                System.out.print("Entrada vacía. Por favor, ingrese un número: ");
                continue;
            }
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            }
        }
    }

    /**
     * Lee la entrada del usuario y la convierte a un double. Similar a `leerOpcion`, maneja
     * entradas inválidas para evitar que el programa se detenga por un error.
     */
    public double leerDouble() {
        while (true) {
            String linea = scanner.nextLine();
            if (linea.isEmpty()) {
                System.out.print("Entrada vacía. Por favor, ingrese un número: ");
                continue;
            }
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            }
        }
    }
}

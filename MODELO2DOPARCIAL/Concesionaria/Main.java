package Concesionaria;

import java.util.Scanner;

/**
 * La clase Main es el punto de entrada de la aplicación de la concesionaria. Se encarga de
 * inicializar los componentes principales (servicios, menú, scanner) y de ejecutar el bucle
 * principal que procesa las opciones del usuario.
 */
public class Main {

    /**
     * El método main es el corazón del programa. Mantiene un bucle activo que muestra el menú, lee
     * la opción del usuario y delega la acción correspondiente al `FlotaService`.
     */
    public static void main(String[] args) {
        // Se crean las instancias de los objetos necesarios para que el programa funcione.
        Scanner scanner = new Scanner(System.in);
        MenuConsola menu = new MenuConsola(scanner);
        FlotaService flotaService = new FlotaService(scanner, menu);

        int opcion;
        do {
            menu.mostrarMenu(); // Muestra el menú de opciones.
            // Lee la opción del usuario de forma segura (manejando errores de formato).
            opcion = menu.leerOpcion();

            switch (opcion) {
                case 1:
                    flotaService.crearVehiculo();
                    break;
                case 2:
                    flotaService.listarVehiculos();
                    break;
                case 3:
                    flotaService.actualizarVehiculo();
                    break;
                case 4:
                    flotaService.eliminarVehiculo();
                    break;
                case 5:
                    flotaService.buscarVehiculoRecursivo();
                    break;
                case 6:
                    flotaService.contarVehiculosPorTipo();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println(); // Espacio para legibilidad
        } while (opcion != 7);

        // Se cierra el scanner para liberar recursos del sistema antes de terminar.
        scanner.close();
    }
}

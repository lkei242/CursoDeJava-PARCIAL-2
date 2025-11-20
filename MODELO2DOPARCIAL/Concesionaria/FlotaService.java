package Concesionaria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase de servicio que encapsula toda la lógica de negocio para gestionar la flota de vehículos.
 * Se encarga de las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y otras consultas.
 */
public class FlotaService {

    // ArrayList para almacenar todos los vehículos de la flota.
    private ArrayList<Vehiculo> flota = new ArrayList<>();
    private Scanner scanner;
    private MenuConsola menu;

    /**
     * Constructor que inicializa el servicio con las dependencias necesarias.
     * 
     * @param scanner Para leer la entrada del usuario.
     * @param menu Para interactuar con el menú de la consola.
     */
    public FlotaService(Scanner scanner, MenuConsola menu) {
        this.scanner = scanner;
        this.menu = menu;
    }

    /**
     * Gestiona la creación de un nuevo vehículo (Auto o Camión). Pide los datos al usuario, valida
     * que la patente no exista y lo añade a la flota.
     */
    public void crearVehiculo() {
        try {
            System.out.print("Tipo de vehículo (1: Auto, 2: Camión): ");
            int tipo = menu.leerOpcion();

            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Año: ");
            int anio = menu.leerOpcion();
            System.out.print("Patente (formato ABC123): ");
            String patente = scanner.nextLine().toUpperCase();

            // Se usa un stream y `anyMatch` para verificar eficientemente si ya existe
            // un vehículo con la misma patente, aprovechando el `equals` sobrescrito.
            if (flota.stream().anyMatch(veh -> veh.getPatente().equals(patente))) {
                System.out.println("Error: Ya existe un vehículo con esa patente.");
                return;
            }

            System.out.print("Kilometraje: ");
            double km = menu.leerDouble();

            Vehiculo nuevoVehiculo;

            // Según el tipo elegido, se piden los datos específicos y se crea el objeto
            // correspondiente.
            if (tipo == 1) {
                System.out.print("Número de puertas: ");
                int puertas = menu.leerOpcion();
                nuevoVehiculo = new Auto(marca, modelo, anio, patente, km, puertas);
            } else if (tipo == 2) {
                System.out.print("Capacidad de carga (toneladas): ");
                double carga = menu.leerDouble();
                nuevoVehiculo = new Camion(marca, modelo, anio, patente, km, carga);
            } else {
                System.out.println("Tipo de vehículo no válido.");
                return;
            }

            flota.add(nuevoVehiculo);
            System.out.println("Vehículo registrado exitosamente.");

        } catch (PatenteInvalidaException e) { // Maneja el error de formato de patente.
            System.out.println("Error al crear el vehículo: " + e.getMessage());
        } catch (Exception e) { // Maneja cualquier otro error inesperado.
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    /**
     * Muestra una lista numerada de todos los vehículos registrados en la flota.
     */
    public void listarVehiculos() {
        System.out.println("\n--- Listado de Vehículos en la Flota ---");
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        // AtomicInteger se usa para poder tener un contador mutable dentro de una expresión lambda.
        AtomicInteger i = new AtomicInteger(1);
        // Se recorre la flota con `forEach` y una expresión lambda para imprimir cada vehículo.
        flota.forEach(v -> {
            System.out.print(i.getAndIncrement() + ". ");
            v.mostrarInfo(true);
        });
    }

    /**
     * Permite actualizar el kilometraje de un vehículo existente, buscándolo por su patente.
     */
    public void actualizarVehiculo() {
        System.out.print("Ingrese la patente del vehículo a actualizar: ");
        String patente = scanner.nextLine().toUpperCase();

        // Se recorre la flota para encontrar el vehículo.
        for (Vehiculo v : flota) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                System.out.print("Ingrese el nuevo kilometraje: ");
                double nuevoKm = menu.leerDouble();
                if (nuevoKm > v.getKilometraje()) {
                    modificarKilometraje(v, nuevoKm);
                    System.out.println("Kilometraje actualizado.");
                } else {
                    System.out
                            .println("El nuevo kilometraje no puede ser menor o igual al actual.");
                }
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    /**
     * Método auxiliar para modificar el kilometraje de un vehículo. Separar esta lógica puede ser
     * útil para reutilización o pruebas.
     */
    public void modificarKilometraje(Vehiculo vehiculo, double nuevoKm) {
        vehiculo.setKilometraje(nuevoKm);
    }

    /**
     * Elimina un vehículo de la flota, buscándolo por su patente.
     */
    public void eliminarVehiculo() {
        System.out.print("Ingrese la patente del vehículo a eliminar: ");
        String patente = scanner.nextLine().toUpperCase();

        // `removeIf` es un método de ArrayList que elimina elementos que cumplen una condición.
        // Devuelve `true` si la lista fue modificada. Es una forma concisa de eliminar.
        boolean eliminado = flota.removeIf(v -> v.getPatente().equalsIgnoreCase(patente));

        if (eliminado) {
            System.out.println("Vehículo eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un vehículo con esa patente.");
        }
    }

    /**
     * Inicia la búsqueda de un vehículo por patente utilizando un método recursivo. Este es un
     * ejemplo de cómo aplicar recursividad a un problema de búsqueda.
     */
    public void buscarVehiculoRecursivo() {
        System.out.print("Ingrese la patente a buscar: ");
        String patente = scanner.nextLine().toUpperCase();
        Vehiculo encontrado = buscarRecursivamente(patente, 0);

        if (encontrado != null) {
            System.out.println("Vehículo encontrado:");
            encontrado.mostrarInfo(true);
        } else {
            System.out.println("No se encontró ningún vehículo con la patente " + patente);
        }
    }

    /**
     * Método privado y recursivo que busca un vehículo en la lista.
     * 
     * @param patente La patente a buscar.
     * @param index El índice actual de la lista a revisar.
     * @return El `Vehiculo` si se encuentra, o `null` si se llega al final de la lista.
     */
    private Vehiculo buscarRecursivamente(String patente, int index) {
        // Caso base: si el índice supera el tamaño de la lista, el elemento no está.
        if (index >= flota.size()) {
            return null;
        }
        // Caso base: si el elemento en el índice actual es el que buscamos, lo devolvemos.
        if (flota.get(index).getPatente().equals(patente)) {
            return flota.get(index);
        }
        // Llamada recursiva: llamamos al mismo método para el siguiente índice.
        return buscarRecursivamente(patente, index + 1);
    }

    /**
     * Cuenta cuántos vehículos de un tipo específico (ej. "Auto") hay en la flota. Este es un
     * ejemplo del uso de streams y lambdas para filtrar y contar datos.
     */
    public void contarVehiculosPorTipo() {
        System.out.print("Ingrese el tipo de vehículo a contar (ej. Auto, Camion): ");
        String tipo = scanner.nextLine();

        // `stream()` convierte la lista en un flujo de datos.
        // `filter()` se queda solo con los elementos que cumplen la condición (lambda).
        // `count()` devuelve la cantidad de elementos restantes.
        long cantidad = flota.stream().filter(v -> v.getTipo().equalsIgnoreCase(tipo)).count();

        System.out.printf("Hay %d vehículos de tipo '%s'.%n", cantidad, tipo);
    }
}

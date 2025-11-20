import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

/*
 * CONTEXTO: Sistema de gestión de vehículos para una empresa de transporte y logística.
 * La empresa necesita administrar su flota compuesta por autos, motos y colectivos.
 * Autor: [Tu Nombre]
 * Fecha: Noviembre 2024
 */

// ============= EXCEPCIÓN PERSONALIZADA =============
class PatenteInvalidaException extends Exception {
    public PatenteInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// ============= INTERFAZ =============
interface Mantenible {
    double calcularCostoMantenimiento();
    String getIdentificador();
}

// ============= CLASE ABSTRACTA VEHÍCULO =============
abstract class Vehiculo implements Mantenible {
    private String marca;
    private int modelo;
    private String patente;
    private int tipo;
    private int kilometraje;
    
    // Constructor parametrizado
    public Vehiculo(String marca, int modelo, String patente, int tipo, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
    }
    
    // Getters y Setters (Encapsulamiento)
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public int getModelo() { return modelo; }
    public void setModelo(int modelo) { this.modelo = modelo; }
    
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    
    public int getTipo() { return tipo; }
    public void setTipo(int tipo) { this.tipo = tipo; }
    
    public int getKilometraje() { return kilometraje; }
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
    
    // Sobrecarga de método
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo + " | Patente: " + patente);
    }
    
    public void mostrarInfo(boolean detallado) {
        if (detallado) {
            System.out.printf("=== INFORMACIÓN DETALLADA ===%n");
            System.out.printf("Marca: %s%n", marca);
            System.out.printf("Modelo: %d%n", modelo);
            System.out.printf("Patente: %s%n", patente);
            System.out.printf("Kilometraje: %d km%n", kilometraje);
        } else {
            mostrarInfo();
        }
    }
    
    // Redefinición de equals() y hashCode() por patente
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return Objects.equals(patente, vehiculo.patente);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }
    
    @Override
    public String getIdentificador() {
        return patente;
    }
    
    // Método abstracto para sobreescribir
    public abstract String getTipoVehiculo();
}

// ============= SUBCLASES =============
class Auto extends Vehiculo {
    private int cantPuertas;
    
    public Auto(String marca, int modelo, String patente, int kilometraje, int cantPuertas) {
        super(marca, modelo, patente, 1, kilometraje);
        this.cantPuertas = cantPuertas;
    }
    
    public int getCantPuertas() { return cantPuertas; }
    public void setCantPuertas(int cantPuertas) { this.cantPuertas = cantPuertas; }
    
    @Override
    public double calcularCostoMantenimiento() {
        return 5000 + (getKilometraje() * 0.5);
    }
    
    @Override
    public String getTipoVehiculo() {
        return "AUTO";
    }
    
    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Cantidad de puertas: %d%n", cantPuertas);
            System.out.printf("Costo mantenimiento: $%.2f%n", calcularCostoMantenimiento());
        }
    }
}

class Moto extends Vehiculo {
    private String cilindrada;
    
    public Moto(String marca, int modelo, String patente, int kilometraje, String cilindrada) {
        super(marca, modelo, patente, 2, kilometraje);
        this.cilindrada = cilindrada;
    }
    
    public String getCilindrada() { return cilindrada; }
    public void setCilindrada(String cilindrada) { this.cilindrada = cilindrada; }
    
    @Override
    public double calcularCostoMantenimiento() {
        return 3000 + (getKilometraje() * 0.3);
    }
    
    @Override
    public String getTipoVehiculo() {
        return "MOTO";
    }
    
    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Cilindrada: %s%n", cilindrada);
            System.out.printf("Costo mantenimiento: $%.2f%n", calcularCostoMantenimiento());
        }
    }
}

class Colectivo extends Vehiculo {
    private int cantAsientos;
    
    public Colectivo(String marca, int modelo, String patente, int kilometraje, int cantAsientos) {
        super(marca, modelo, patente, 3, kilometraje);
        this.cantAsientos = cantAsientos;
    }
    
    public int getCantAsientos() { return cantAsientos; }
    public void setCantAsientos(int cantAsientos) { this.cantAsientos = cantAsientos; }
    
    @Override
    public double calcularCostoMantenimiento() {
        return 15000 + (getKilometraje() * 1.2);
    }
    
    @Override
    public String getTipoVehiculo() {
        return "COLECTIVO";
    }
    
    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Cantidad de asientos: %d%n", cantAsientos);
            System.out.printf("Costo mantenimiento: $%.2f%n", calcularCostoMantenimiento());
        }
    }
}

// ============= CLASE PRINCIPAL =============
public class modeloP2_SistemaVehiculos {
    // Variable global (justificada: almacena toda la flota de vehículos)
    private static ArrayList<Vehiculo> flota = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    buscarVehiculoMenu();
                    break;
                case 4:
                    actualizarVehiculo();
                    break;
                case 5:
                    eliminarVehiculo();
                    break;
                case 6:
                    buscarRecursivo();
                    break;
                case 7:
                    filtrarPorKilometraje();
                    break;
                case 8:
                    calcularCostoTotal();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            
            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    // Método 1: Mostrar menú
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE VEHÍCULOS     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Crear vehículo");
        System.out.println("2. Listar todos los vehículos");
        System.out.println("3. Buscar vehículo por patente");
        System.out.println("4. Actualizar vehículo");
        System.out.println("5. Eliminar vehículo");
        System.out.println("6. Búsqueda recursiva");
        System.out.println("7. Filtrar por kilometraje (Lambdas)");
        System.out.println("8. Calcular costo total mantenimiento");
        System.out.println("0. Salir");
        System.out.println("════════════════════════════════════════");
    }
    
    // Método 2: Crear vehículo
    private static void crearVehiculo() {
        System.out.println("\n=== CREAR NUEVO VEHÍCULO ===");
        System.out.println("Tipo de vehículo:");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Colectivo");
        
        int tipo = leerEntero("Seleccione tipo: ");
        
        try {
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            
            int modelo = leerEntero("Año del modelo: ");
            
            scanner.nextLine();
            System.out.print("Patente: ");
            String patente = scanner.nextLine().toUpperCase();
            
            // Validación de patente
            if (patente.length() < 6 || patente.length() > 7) {
                throw new PatenteInvalidaException("La patente debe tener 6 o 7 caracteres");
            }
            
            // Verificar si ya existe
            if (existePatente(patente)) {
                throw new PatenteInvalidaException("Ya existe un vehículo con esa patente");
            }
            
            int kilometraje = leerEntero("Kilometraje: ");
            
            Vehiculo vehiculo = null;
            
            switch (tipo) {
                case 1:
                    int puertas = leerEntero("Cantidad de puertas: ");
                    vehiculo = new Auto(marca, modelo, patente, kilometraje, puertas);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Cilindrada: ");
                    String cilindrada = scanner.nextLine();
                    vehiculo = new Moto(marca, modelo, patente, kilometraje, cilindrada);
                    break;
                case 3:
                    int asientos = leerEntero("Cantidad de asientos: ");
                    vehiculo = new Colectivo(marca, modelo, patente, kilometraje, asientos);
                    break;
                default:
                    System.out.println("Tipo inválido");
                    return;
            }
            
            flota.add(vehiculo);
            System.out.println("✓ Vehículo creado exitosamente!");
            
        } catch (PatenteInvalidaException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Ocurrió un error al crear el vehículo");
        } finally {
            System.out.println("Operación de creación finalizada.");
        }
    }
    
    // Método 3: Listar vehículos
    private static void listarVehiculos() {
        System.out.println("\n=== LISTADO DE VEHÍCULOS ===");
        
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        
        // Uso de lambda: forEach
        System.out.println("\nTotal de vehículos: " + flota.size());
        System.out.println("─────────────────────────────────────");
        
        int contador = 1;
        for (Vehiculo v : flota) {
            System.out.printf("%d. [%s] ", contador++, v.getTipoVehiculo());
            v.mostrarInfo();
        }
    }
    
    // Método 4: Buscar vehículo
    private static void buscarVehiculoMenu() {
        scanner.nextLine();
        System.out.print("\nIngrese la patente a buscar: ");
        String patente = scanner.nextLine().toUpperCase();
        
        Vehiculo encontrado = null;
        
        // Usando for con break
        for (int i = 0; i < flota.size(); i++) {
            if (flota.get(i).getPatente().equals(patente)) {
                encontrado = flota.get(i);
                break;
            }
        }
        
        if (encontrado != null) {
            System.out.println("\n✓ Vehículo encontrado:");
            encontrado.mostrarInfo(true);
        } else {
            System.out.println("✗ No se encontró ningún vehículo con esa patente.");
        }
    }
    
    // Método 5: Actualizar vehículo (demuestra paso por referencia)
    private static void actualizarVehiculo() {
        scanner.nextLine();
        System.out.print("\nIngrese la patente del vehículo a actualizar: ");
        String patente = scanner.nextLine().toUpperCase();
        
        Vehiculo vehiculo = buscarPorPatente(patente);
        
        if (vehiculo == null) {
            System.out.println("✗ Vehículo no encontrado.");
            return;
        }
        
        System.out.println("\nVehículo actual:");
        vehiculo.mostrarInfo(true);
        
        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Kilometraje");
        System.out.println("2. Marca");
        System.out.println("3. Modelo");
        
        int opcion = leerEntero("Opción: ");
        
        // Paso por referencia: modificamos el objeto directamente
        modificarVehiculo(vehiculo, opcion);
        
        System.out.println("\n✓ Vehículo actualizado:");
        vehiculo.mostrarInfo(true);
    }
    
    // Método auxiliar que demuestra paso por referencia
    private static void modificarVehiculo(Vehiculo v, int opcion) {
        switch (opcion) {
            case 1:
                int km = leerEntero("Nuevo kilometraje: ");
                v.setKilometraje(km);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Nueva marca: ");
                String marca = scanner.nextLine();
                v.setMarca(marca);
                break;
            case 3:
                int modelo = leerEntero("Nuevo año: ");
                v.setModelo(modelo);
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    
    // Método 6: Eliminar vehículo
    private static void eliminarVehiculo() {
        scanner.nextLine();
        System.out.print("\nIngrese la patente del vehículo a eliminar: ");
        String patente = scanner.nextLine().toUpperCase();
        
        // Uso de lambda: removeIf
        boolean eliminado = flota.removeIf(v -> v.getPatente().equals(patente));
        
        if (eliminado) {
            System.out.println("✓ Vehículo eliminado exitosamente.");
        } else {
            System.out.println("✗ No se encontró el vehículo.");
        }
    }
    
    // FUNCIÓN RECURSIVA 1: Buscar vehículo recursivamente
    private static void buscarRecursivo() {
        scanner.nextLine();
        System.out.print("\nIngrese la patente a buscar (recursivo): ");
        String patente = scanner.nextLine().toUpperCase();
        
        int indice = buscarRecursivoAux(patente, 0);
        
        if (indice != -1) {
            System.out.println("\n✓ Vehículo encontrado en posición " + (indice + 1));
            flota.get(indice).mostrarInfo(true);
        } else {
            System.out.println("✗ Vehículo no encontrado.");
        }
    }
    
    // Función recursiva auxiliar
    private static int buscarRecursivoAux(String patente, int indice) {
        // Caso base
        if (indice >= flota.size()) {
            return -1;
        }
        
        // Si encontramos la patente
        if (flota.get(indice).getPatente().equals(patente)) {
            return indice;
        }
        
        // Llamada recursiva
        return buscarRecursivoAux(patente, indice + 1);
    }
    
    // Método con lambdas: filtrar por kilometraje
    private static void filtrarPorKilometraje() {
        int kmMinimo = leerEntero("\nIngrese kilometraje mínimo: ");
        
        System.out.println("\n=== VEHÍCULOS CON MÁS DE " + kmMinimo + " KM ===");
        
        // Lambda con filter y forEach
        flota.stream()
             .filter(v -> v.getKilometraje() > kmMinimo)
             .forEach(v -> {
                 System.out.println("─────────────────────");
                 v.mostrarInfo(true);
             });
        
        // Lambda: anyMatch
        boolean hayVehiculos = flota.stream()
                                    .anyMatch(v -> v.getKilometraje() > kmMinimo);
        
        if (!hayVehiculos) {
            System.out.println("No hay vehículos que cumplan la condición.");
        }
    }
    
    // Método adicional: calcular costo total
    private static void calcularCostoTotal() {
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos en la flota.");
            return;
        }
        
        double total = 0;
        int contador = 0;
        
        // Uso de while
        while (contador < flota.size()) {
            total += flota.get(contador).calcularCostoMantenimiento();
            contador++;
        }
        
        System.out.println("\n=== COSTOS DE MANTENIMIENTO ===");
        System.out.printf("Costo total de la flota: $%.2f%n", total);
        System.out.printf("Costo promedio por vehículo: $%.2f%n", total / flota.size());
    }
    
    // Métodos auxiliares
    private static Vehiculo buscarPorPatente(String patente) {
        for (Vehiculo v : flota) {
            if (v.getPatente().equals(patente)) {
                return v;
            }
        }
        return null;
    }
    
    private static boolean existePatente(String patente) {
        int i = 0;
        boolean existe = false;
        
        // Uso de do-while con continue
        do {
            if (i >= flota.size()) {
                break;
            }
            
            if (!flota.get(i).getPatente().contains(patente)) {
                i++;
                continue;
            }
            
            existe = true;
            break;
            
        } while (i < flota.size());
        
        return existe;
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
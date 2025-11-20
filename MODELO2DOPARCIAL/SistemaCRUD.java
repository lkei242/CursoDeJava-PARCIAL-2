import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SistemaCRUD {
    public static void main(String[] args) {
        listaVehiculo.add(new Auto("Toyota", "Corolla", 2018, "ABC123", 45000, false));
        listaVehiculo.add(new Camion("Mercedes", "Actros", 2015, "TRK900", 250000, 12.5));
        listaVehiculo.add(new Auto("Tesla", "Model 3", 2020, "TES789", 20000, false));

        System.out.println("Bienvenido al sistema de gestion de vehiculos");
        menu();

        entrada.close();
    }

    private static final ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
    private static final Scanner entrada = new Scanner(System.in);

    public static void validadPatente(String p) throws PatenteInvalidaException {
        if (p == null) {
            throw new PatenteInvalidaException("Patente nula");
        }
        String s = p.trim().toUpperCase();
        if (s.length() < 4 || s.length() > 8) {
            throw new PatenteInvalidaException("Patente longitud invalida (4-8)");
        }
        if (!s.matches("[A-Z0-9]+")) {
            throw new PatenteInvalidaException("Patente con caracteres invalidos.");
        }
    }

    private static void crearVehiculo() {
        System.out.println("Crear vehiculo. Tipos disponibles: 1-Auto, 2-Camion");
        System.out.print("Seleccione tipo (1/2): ");
        String tipo = entrada.nextLine().trim();
        try {
            System.out.print("Marca: ");
            String marca = entrada.nextLine().trim();
            System.out.print("Modelo: ");
            String modelo = entrada.nextLine().trim();
            System.out.print("Anio: ");
            int anio = Integer.parseInt(entrada.nextLine().trim());
            System.out.print("Patente: ");
            String patente = entrada.nextLine().trim();
            validadPatente(patente);
            System.out.print("Kilometraje: ");
            double km = Double.parseDouble(entrada.nextLine().trim());

            final Vehiculo[] ref = new Vehiculo[1];

            switch (tipo) {
                case "1":
                    System.out.print("¿Es electrico? (s/n): ");
                    String r = entrada.nextLine().trim();
                    boolean esEl = r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si");
                    ref[0] = new Auto(marca, modelo, anio, patente, km, esEl);
                    break;
                case "2":
                    System.out.print("Carga maxima: ");
                    double carga = Double.parseDouble(entrada.nextLine().trim());
                    ref[0] = new Camion(marca, modelo, anio, patente, km, carga);
                    break;
                default:
                    System.out.println("Tipo no reconocido.");
                    return;
            }

            boolean exists = listaVehiculo.stream().anyMatch(x -> x.equals(ref[0]));
            if (exists) {
                System.out.println("Ya existe un vehiculo con esa patente. Operacion cancelada.");
                return;
            }

            listaVehiculo.add(ref[0]);
            System.out.println("Vehiculo agregado correctamente.");
        } catch (NumberFormatException nfe) {
            System.out.println("Error en numero ingresado: " + nfe.getMessage());
        } catch (PatenteInvalidaException pie) {
            System.out.println("Patente invalida: " + pie.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado.");
        } finally {
            System.out.println("Fin de crear vehiculo.");
        }
    }


    private static Vehiculo buscarVehiculo(String patente) {
        for (Vehiculo v : listaVehiculo) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        return null;
    }

    private static Vehiculo buscarVehiculoRecursivo(String patente, int idx) {
        if (idx >= listaVehiculo.size()) {
            return null;
        }
        if (listaVehiculo.get(idx).getPatente().equalsIgnoreCase(patente)) {
            return listaVehiculo.get(idx);
        }
        return buscarVehiculoRecursivo(patente, idx + 1);
    }

    private static void eliminarVehiculo() {
        System.out.println("Ingrese patente a eliminar: ");
        String p = entrada.nextLine().trim();
        try {
            validadPatente(p);
            boolean eliminar = listaVehiculo.removeIf(v -> v.getPatente().equalsIgnoreCase(p));
            if (eliminar) {
                System.out.println("Vehiculo eliminado.");
            } else {
                System.out.println("No se encontro vehiculo con esa patente.");
            }
        } catch (PatenteInvalidaException pie) {
            System.out.println("Patente invalida: " + pie.getMessage());
        }
    }

    private static void actualizarVehiculo() {
        System.out.println("Patente del vehiculo a actualizar: ");
        String p = entrada.nextLine().trim();
        try {
            validadPatente(p);
            Vehiculo v = buscarVehiculoRecursivo(p, 0);
            if (v == null) {
                System.out.println("No encontrado.");
                return;
            }
            
            System.out.println("Vehiculo encontrado: ");
            v.mostrarDatos(true);
            System.out.println("¿Que modificar? 1-Marca 2-Modelo 3-Anio 4-Km 5-Tipo especifico (Auto/Camion) 0- Cancelar: ");
            String opcion = entrada.nextLine().trim();
            switch (opcion) {
                case "1":
                    System.out.print("Nueva Marca: ");
                    v.setMarca(entrada.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Nuevo Modelo: ");
                    v.setModelo(entrada.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Nuevo anio: ");
                    v.setAnio(Integer.parseInt(entrada.nextLine().trim()));
                    break;
                case "4":
                    System.out.print("Nuevo kilometraje: ");
                    double km = Double.parseDouble(entrada.nextLine().trim());
                    modificarKilometraje(v, km);
                    break;
                case "5":
                    if (v instanceof Auto) {
                        System.out.print("¿Es electrico? (s/n): ");
                        String r = entrada.nextLine().trim();
                        ((Auto) v).setEsElectric(r.equalsIgnoreCase("s"));
                    } else if (v instanceof Camion) {
                        System.out.print("Nueva carga maxima: ");
                        ((Camion) v).setCargaMaxima(Double.parseDouble(entrada.nextLine().trim()));
                    } else {
                        System.out.println("No aplica.");
                    }
                    break;
                case "0":
                    System.out.println("Cancelado.");
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }

            System.out.println("Actualizacion finalizada.");
        } catch (NumberFormatException nfe) {
            System.out.println("Numero invalido: " + nfe.getMessage());
        } catch (PatenteInvalidaException pie) {
            System.out.println("Patente invalido: " + pie.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado.");
        }
    }

    private static void modificarKilometraje(Vehiculo v, double nuevoKm) {
        v.setKilometraje(nuevoKm);
        System.out.println("Kilometraje actualizado a: " + nuevoKm);
    }

    private static void incrementarAnios(int meses) {
        int resultado = meses + 12;
        System.out.println("Meses + 12 = " + resultado);
    }

    private static int contarPorTipoRecursivo(String tipo, int idx) {
        if (idx >= listaVehiculo.size()) {
            return 0;
        }
        int add = listaVehiculo.get(idx).getTipo().equalsIgnoreCase(tipo) ? 1 : 0;
        return add + contarPorTipoRecursivo(tipo, idx + 1);
    }

    private static void recorrerRecursivo(int idx) {
        if (idx >= listaVehiculo.size()) {
            return;
        }
        System.out.println(" -> " + listaVehiculo.get(idx).getPatente());
        recorrerRecursivo(idx + 1);
    }

    private static void mostrarTodos() {
        if (listaVehiculo.isEmpty()) {
            System.out.println("No hay vehiculos en la lista.");
            return;
        }
        System.out.println("Listado de vehiculos: ");
        listaVehiculo.forEach(v -> v.mostrarDatos());
    }

    private static void buscarPorPatenteMenu() {
        System.out.println("Patente a buscar: ");
        String p = entrada.nextLine().trim();
        try {
            validadPatente(p);
            Vehiculo v = buscarVehiculo(p);
            if (v == null) {
                throw new VehiculoNoEncontradoException("No hay vehiculo con esa patente.");
            }
            System.out.println("Encontrado.");
            v.mostrarDatos(true);
        } catch (PatenteInvalidaException pie) {
            System.out.println(pie.getMessage());
        } catch (VehiculoNoEncontradoException vnee) {
            System.out.println(vnee.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado.");
        }
    }

    private static void demoLambdas() {
        boolean existeCamion = listaVehiculo.stream().anyMatch(v -> v instanceof Camion);
        System.out.println("¿Existe camion en la flota? " + (existeCamion ? "Si" : "No"));

        List<Vehiculo> autos = listaVehiculo.stream()
            .filter(v -> v instanceof Auto)
            .collect(Collectors.toList());
        System.out.println("Cantidad de autos: " + autos.size());

        listaVehiculo.removeIf(v -> v.getKilometraje() < 0);
    }

    private static void menu() {
        String opcion;
        do {
            System.out.println("==== MENU GESTION LISTA DE VEHICULOS ====");
            System.out.println("1. Crear vehiculo");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Buscar por patente");
            System.out.println("4. Actualizar vehiculo");
            System.out.println("5. Eliminar vehiculo");
            System.out.println("6. Buscar recursivo por patente");
            System.out.println("7. Contar por tipo");
            System.out.println("8. Recorrer recursivo");
            System.out.println("9. Demos lambdas/streams");
            System.out.println("10. Calcular costo mantenimiento de todos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = entrada.nextLine().trim();
            
            switch (opcion) {
                case "1":
                    crearVehiculo();
                    break;
                case "2":
                    mostrarTodos();
                    break;
                case "3":
                    buscarPorPatenteMenu();
                    break;
                case "4":
                    actualizarVehiculo();
                    break;
                case "5":
                    eliminarVehiculo();
                    break;
                case "6":
                    System.out.println("Patente (recursivo): ");
                    String p = entrada.nextLine().trim();
                    try {
                        validadPatente(p);
                        Vehiculo vr = buscarVehiculoRecursivo(p, 0);
                        if (vr == null) {
                            System.out.println("No encontrado.");
                        } else {
                            System.out.println("Encontrado (recursivo): ");
                            vr.mostrarDatos(true);
                        }
                    } catch (PatenteInvalidaException pie) {
                        System.out.println(pie.getMessage());
                    }
                    break;
                case "7":
                    System.out.println("Tipo a contar (Auto/Camion): ");
                    String t = entrada.nextLine().trim();
                    int cant = contarPorTipoRecursivo(t, 0);
                    System.out.println("Cantidad tipo " + t + " = " + cant);
                    break;
                case "8":
                    System.out.println("Patentes recursivo: ");
                    recorrerRecursivo(0);
                    break;
                case "9":
                    demoLambdas();
                    break;
                case "10":
                    if (listaVehiculo.isEmpty()) {
                        System.out.println("Sin vehiculos.");
                    } else {
                        listaVehiculo.forEach(v -> System.out.println(v.getPatente() + " -> costo mantenimiento: " + v.calcularCostoMantenimiento()));
                    }
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (!opcion.equals("0"));
    }
}

class PatenteInvalidaException extends Exception {
    public PatenteInvalidaException(String msg) {
        super(msg);
    }
}

class VehiculoNoEncontradoException extends Exception {
    public VehiculoNoEncontradoException(String msg) {
        super(msg);
    }
}

interface Mantenible {
    double calcularCostoMantenimiento();
}

interface Identificable {
    String getIdentificador();
}

abstract class Vehiculo implements Mantenible, Identificable {
    protected String marca;
    protected String modelo;
    protected int anio;
    protected String patente;
    protected String tipo;
    protected double kilometraje;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Vehiculo(String marca, String modelo, int anio, String patente, String tipo, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo v = (Vehiculo) o;
        return this.patente.equalsIgnoreCase(v.patente);
    }

    public int hashCode() {
        return Objects.hash(patente.toUpperCase());
    }

    public String getIdentificador() {
        return getPatente();
    }

    public void mostrarDatos() {
        System.out.println("Patente: " + patente + " | Marca: " + marca + " | Modelo: " + modelo + " | Anio: " + anio + 
            " | Tipo: " + tipo + " | Kilometraje: " + kilometraje);
    }

    public void mostrarDatos(boolean detalle) {
        mostrarDatos();
        if (detalle) {
            System.out.println(" (detalle adicional en implementacion concreta)");
        }
    }

    public abstract double calcularCostoMantenimiento();
}

class Auto extends Vehiculo {
    private boolean esElectric;

    public boolean getEsElectric() {
        return esElectric;
    }

    public void setEsElectric(boolean esElectric) {
        this.esElectric = esElectric;
    }

    public Auto(String marca, String modelo, int anio, String patente, double km, boolean esElectric) {
        super(marca, modelo, anio, patente, "Auto", km);
        this.esElectric = esElectric;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(" -> Auto: " + getModelo() + " (Electrico: " + (esElectric ? "Si" : "No") + ")");
    }

    public double calcularCostoMantenimiento() {
        double base = 100;
        if (getEsElectric()) {
            base *= 0.7;
        }
        return base + 0.02 * getKilometraje();
    }
}

class Camion extends Vehiculo {
    private double cargaMaxima;

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima; 
    }

    public Camion(String marca, String modelo, int anio, String patente, double km, double cargaMax) {
        super(marca, modelo, anio, patente, "Camion", km);
        this.cargaMaxima = cargaMax; 
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(" -> Camion carga maxima: " + cargaMaxima);
    }

    public double calcularCostoMantenimiento() {
        double base = 300;
        return base + 0.05 * getKilometraje() + 20 * cargaMaxima;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestion {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("MENU DE PRODUCTOS DE LIMPIEZA");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar productos por codigo");
            System.out.println("4. Modificar precio");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Codigo: ");
                    int codigo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Marca: ");
                    String marca = entrada.nextLine();
                    System.out.print("Precio: ");
                    double precio = entrada.nextDouble();

                    Producto nuevo = new Producto(codigo, nombre, marca, precio);
                    if (productos.contains(nuevo)) {
                        System.out.println("Ya existe un producto con ese codigo.");
                    } else {
                        productos.add(nuevo);
                        System.out.println("Producto agregados");
                    }
                    break;
                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        productos.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Codigo a buscar: ");
                    int buscarCod = entrada.nextInt();
                    Producto res = null;

                    for (Producto p : productos) {
                        if (p.getCodigo() == buscarCod) {
                            res = p;
                            break;
                        }
                    }

                    if (res != null) {
                        System.out.println(res);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Codigo a modificar: ");
                    int codMod = entrada.nextInt();

                    Producto prodMod = productos.stream()
                        .filter(p -> p.getCodigo() == codMod)
                        .findFirst()
                        .orElse(null);

                    if (prodMod == null) {
                        System.out.println("No existe un producto con ese codigo.");
                    } else {
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = entrada.nextDouble();
                        prodMod.setPrecio(nuevoPrecio);
                        System.out.println("Precio actualizado.");
                    }
                    break;
                case 5:
                    System.out.print("Codigo a eliminar: ");
                    int codEliminar = entrada.nextInt();
                    boolean eliminado = productos.removeIf(p -> p.getCodigo() == codEliminar);

                    if (eliminado) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);
        
        entrada.close();
    }
}

class Producto {
    private int codigo;
    private String nombre;
    private String marca;
    private double precio;
    
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Producto(int codigo, String nombre, String marca, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public String toString() {
        return "ID: " + codigo + " | Nombre: " + nombre + " | Marca: " + marca + " | Precio: " + precio + "";
    }

    public int hashCode() {
        return Integer.hashCode(codigo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        Producto otro = (Producto) obj;
        return this.codigo == otro.codigo; 
    }
}
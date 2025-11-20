//Ejercicio 5.2

class Producto {
    int codigo;
    String nombre;
    float precio;
    
    public Producto() {
    }

    public Producto(int codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + " | Precio: " + precio; 
    }
}

class Inventario {
    private Producto[] productos = new Producto[10];
    private int contador = 0;

    public void agregarProducto(Producto p) {
        if (contador < productos.length) {
            productos[contador] = p;
            contador++;
            System.out.println("Producto agregado.\n");
        } else {
            System.out.println("Inventario lleno, no se puede agregar más productos.");
        }
    }

    public void buscarProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                System.out.println("\nProducto encontrado: " + productos[i]);
                return;
            }
        }
    }

    public void modificarProducto(int codigo, String nuevoNombre, float nuevoPrecio) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                productos[i].nombre = nuevoNombre;
                productos[i].precio = nuevoPrecio;
                System.out.println("\nProducto modificado: " + productos[i]);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                productos[i] = productos[contador - 1];
                productos[contador - 1] = null;
                contador--;
                System.out.println("\nProducto eliminado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void listarProductos() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(productos[i]);
            }
            System.out.println("\nTotal de productos: " + contador);
        }
    }
}

public class Programa28 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto(1, "Laptop", 1500.00f));
        inventario.agregarProducto(new Producto(2, "Smartphone", 800.00f));

        inventario.listarProductos();
        inventario.buscarProducto(1);
        
        inventario.modificarProducto(2, "Smartphone Pro", 950.00f);
        inventario.eliminarProducto(1);
        
        inventario.listarProductos();
    }
}
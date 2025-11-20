package GuiaDeEjercicios;

class Producto {
    int codigo;
    String nombre;
    double precio;

    Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + " | Precio: $" + precio;
    }
}

class Inventario {
    private Producto[] productos = new Producto[10];
    private int contador = 0;

    public void agregarProducto(Producto p) {
        if (contador < productos.length) {
            productos[contador] = p;
            contador++;
            System.out.println("Producto agregado.");
        } else {
            System.out.println("Inventario lleno.");
        }
    }

    public void buscarProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                System.out.println("Producto encontrado: " + productos[i]);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void modificarPrecio(int codigo, double nuevoPrecio) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                productos[i].precio = nuevoPrecio;
                System.out.println("Precio modificado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].nombre.equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contador - 1] = null;
                contador--;
                System.out.println("Producto eliminado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void listarProductos() {
        if (contador == 0) {
            System.out.println("Inventario vacío.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i]);
        }
    }
}

public class InventarioApp {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto(101, "Laptop", 1200.50));
        inv.agregarProducto(new Producto(102, "Mouse", 25.00));

        inv.listarProductos();

        inv.buscarProducto(101);
        inv.modificarPrecio(102, 30.00);

        inv.eliminarProducto("Laptop");
        inv.listarProductos();
    }
}

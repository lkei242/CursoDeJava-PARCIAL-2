abstract class ProductoTienda {
    protected int id;
    protected double precio;
    protected int stock;
    
    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public ProductoTienda(int id, double precio, int stock) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    public String toString() {
        return "ID: " + id + ", Precio: $" + precio + ", Stock: " + stock;
    }
}

class Accesorio extends ProductoTienda {
    public Accesorio(int id, double precio, int stock) {
        super(id, precio, stock);
    } 
}

class Indumentaria extends ProductoTienda {
    protected String talle;

    public Indumentaria(int id, double precio, int stock, String talle) {
        super(id, precio, stock);
        this.talle = talle;
    } 

    public String toString() {
        return super.toString() + ", Talle: " + talle;
    } 
} 

class Zapatos extends Indumentaria {
    public Zapatos(int id, double precio, int stock, String talle) {
        super(id, precio, stock, talle);
    } 
} 

class Ropa extends Indumentaria {
    public Ropa(int id, double precio, int stock, String talle) {
        super(id, precio, stock, talle);
    } 
} 

abstract class Persona {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    } 

    public String toString() {
        return "Nombre: " + nombre;
    }
} 

class Cliente extends Persona {
    public Cliente(String nombre) {
        super(nombre);
    }

    public String toString() {
        return "Cliente - " + super.toString();
    }
}

class Vendedor extends Persona {
    private Sucursal sucursal;

    public Vendedor(String nombre, Sucursal sucursal) {
        super(nombre);
        this.sucursal = sucursal;
    }

    public String toString() {
        return "Vendedor - " + super.toString() + ", Sucursal: " + sucursal.mostrarDatos();
    }
}

class Sucursal {
    private String nombre;
    private String direccion;

    public Sucursal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String mostrarDatos() {
        return nombre + " - " + direccion;
    } 
}

public class Programa30 {
    public static void main(String[] args) {
        Sucursal sucursal = new Sucursal("Sucursal centro", "Av. Alberdi 239");

        ProductoTienda accesorio = new Accesorio(1, 500, 10);
        ProductoTienda zapato = new Zapatos(2, 1500, 5, "43");
        ProductoTienda ropa = new Ropa(3, 1000, 20, "L");

        Vendedor vendedor = new Vendedor ("Gersom Tomas Hotchkyss", sucursal);
        Cliente cliente = new Cliente("Juan Perez Canal");

        System.out.println(accesorio);
        System.out.println("\n--- PRODUCTOS ---");
        System.out.println(zapato);
        System.out.println(ropa);

        System.out.println("\n--- PERSONAS ---");
        System.out.println(vendedor);
        System.out.println(cliente);
    }
}
import modelos.*;
import servicios.*;

public class Principal {
    public static void main(String[] args) {
        Administracion admin = new Administracion();
        admin.mostrarMensaje();

        Articulo detergente = new Limpieza("Detergente", 1200.0, "Líquido");
        Articulo escoba = new Limpieza("Escoba", 800.0, "Cepillo");
        Articulo silla = new Hogar("Silla de comedor", 7500.0, "Madera");
        Articulo plato = new Hogar("Plato cerámico", 450.0, "Cerámica");

        Venta venta = new Venta();
        venta.realizarVenta(detergente);
        venta.realizarVenta(silla);

        System.out.println();
        System.out.println(detergente);
        System.out.println(escoba);
        System.out.println(silla);
        System.out.println(plato);
    }
}
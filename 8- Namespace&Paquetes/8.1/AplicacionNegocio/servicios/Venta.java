package servicios;
import modelos.Articulo;

public class Venta {
    public void realizarVenta(Articulo a) {
        System.out.println("Vendiendo: " + a.getNombre() + " por $" + a.getPrecio());
    }
}
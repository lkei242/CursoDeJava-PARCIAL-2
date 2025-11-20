package modelos;

public class Limpieza extends Articulo {
    private String tipo; 

    public Limpieza(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() { 
        return tipo; 
    }

    public String toString() {
        return super.toString() + " | Tipo: " + tipo;
    }
}
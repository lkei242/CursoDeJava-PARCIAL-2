package modelos;

public class Hogar extends Articulo {
    private String material; 

    public Hogar(String nombre, double precio, String material) {
        super(nombre, precio);
        this.material = material;
    }

    public String getMaterial() { 
        return material; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Material: " + material;
    }
}
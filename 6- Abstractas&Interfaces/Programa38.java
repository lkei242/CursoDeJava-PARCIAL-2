//Ejercicio 6.8

abstract class Electrodomestico {
    protected float precio;
    protected char consumo;

    public Electrodomestico(float precio, char consumo) {
        this.precio = precio;
        this.consumo = consumo;
    }
}

interface EficienciaEnergetica {
    void mostrarEtiqueta();
}

class Heladera extends Electrodomestico implements EficienciaEnergetica {
    public Heladera(float precio, char consumo) {
        super(precio, consumo);
    }

    public void mostrarEtiqueta() {
        System.out.println("Heladera - Consumo: " + consumo + " | Precio : $" + precio);
    }
}

class Lavarropas extends Electrodomestico implements EficienciaEnergetica {
    public Lavarropas(float precio, char consumo) {
        super(precio, consumo);
    }

    public void mostrarEtiqueta() {
        System.out.println("Lavarropas - Consumo: " + consumo + " | Precio : $" + precio);
    }
}

public class Programa38 {
    public static void main(String[] args) {
        Heladera heladera = new Heladera(2000, 'A');
        Lavarropas lavarropas = new Lavarropas(1500, 'B');

        heladera.mostrarEtiqueta();
        lavarropas.mostrarEtiqueta();
    }
}
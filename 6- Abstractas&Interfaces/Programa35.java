//Ejercicio 6.5

abstract class Instrumento {
    protected String nombre;

    public Instrumento(String nombre) {
        this.nombre = nombre;
    }

    public abstract void tocar();

    public String toString() {
        return "Instrumento: " + nombre;
    }
}

interface Afinable {
    void afinar();
}

class Guitarra extends Instrumento implements Afinable {
    public Guitarra(String nombre) {
        super(nombre);
    }

    public void tocar() {
        System.out.println(nombre + " está tocando un solo de acústico.");
    }
    
    public void afinar() {
        System.out.println(nombre + " está afinando las cuerdas de la guitarra.");
    }
}

class Piano extends Instrumento implements Afinable {
    public Piano(String nombre) {
        super(nombre);
    }

    public void tocar() {
        System.out.println(nombre + " está tocando una melodía clasica.");
    }

    public void afinar() {
        System.out.println(nombre + " está afinando las teclas del piano.");
    }
}

public class Programa35 {
    public static void main(String[] args) {
        Instrumento guitarra = new Guitarra("Guitarra Gibson");
        Instrumento piano = new Piano("Piano Yamaha");

        Afinable i1 = (Afinable) guitarra;
        Afinable i2 = (Afinable) piano;

        System.out.println("Prueba de Instrumentos");
        guitarra.tocar();
        i1.afinar();

        piano.tocar();
        i2.afinar();
    }
}
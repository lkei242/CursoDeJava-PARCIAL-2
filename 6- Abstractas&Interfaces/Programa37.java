//Ejercicio 6.7

abstract class Personaje {
    protected String nombre;
    protected int nivel;

    public Personaje(String nombre, int nivel)  {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public abstract void atacar();

    public String toString() {
        return "Personaje: " + nombre + " (Nivel "  + nivel  + ")";
    }
}

interface Movible {
    void mover();
}

class Guerrero extends Personaje implements Movible {
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel);
    }

    public void atacar() {
        System.out.println(nombre + " ataca con su espada");
    }

    public void mover() {
        System.out.println(nombre + " se mueve hacia la posición de su enemigo");
    }
}

class Mago extends Personaje implements Movible {
    public Mago(String nombre, int nivel) {
        super(nombre, nivel);
    }

    public void atacar() {
        System.out.println(nombre + " ataca con su hechizo de fuego");
    }

    public void mover() {
        System.out.println(nombre + " se mueve con su técnica de teletransportación");
    }
}

public class Programa37 {
    public static void main(String[] args) {
        Personaje guerrero = new Guerrero("Artorias", 50);
        Personaje mago  = new Mago("Griggs", 35);

        Movible p1 = (Movible) guerrero;
        Movible p2 = (Movible) mago;

        System.out.println("PERSONAJES");
        System.out.println(guerrero);
        guerrero.atacar();
        p1.mover();

        System.out.println();

        System.out.println(mago);
        mago.atacar();
        p2.mover();
    }
}
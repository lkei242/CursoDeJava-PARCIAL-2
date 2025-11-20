//Ejercicio 6.2

abstract class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void hacerSonido();
}

interface MascotaInterfaz {
    void jugar();
}

class Perro extends Animal implements MascotaInterfaz {
    public Perro(String nombre) {
        super(nombre);
    }

    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau Guau!");
    }

    public void jugar() {
        System.out.println(nombre + " está jugando a traer la pelota");
    }
}

class Gato extends Animal implements MascotaInterfaz {
    public Gato(String nombre) {
        super(nombre);
    }

    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }

    public void jugar() {
        System.out.println(nombre + " está jugando con un ovillo de lana");
    }
}

public class Programa32 {
    public static void main(String[] args)  {
        Animal perro = new Perro("Milo");
        Animal gato = new Gato("Micho");

        MascotaInterfaz mascota1 = (MascotaInterfaz) perro;
        MascotaInterfaz mascota2 = (MascotaInterfaz) gato;

        perro.hacerSonido();
        gato.hacerSonido();

        mascota1.jugar();
        mascota2.jugar();
    }
}
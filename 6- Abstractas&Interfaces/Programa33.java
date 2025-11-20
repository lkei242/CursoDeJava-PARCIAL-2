//Ejercicio 6.3

abstract class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract void acelerar();

    public String toString() {
        return "Marca: " + marca + "| Modelo: " + modelo;
    }
}

interface Recargable {
    void recargarCombustible();
}

class Auto extends Vehiculo implements Recargable {
    public Auto(String marca, String modelo) {
        super(marca, modelo);
    }
    
    public void acelerar() {
        System.out.println("El auto " + marca + " " + modelo + " está acelerando.");
    }

    public void recargarCombustible() {
        System.out.println("El auto " + marca + " " + modelo + " está recargando combustible.");
    }
}

class Moto extends Vehiculo implements Recargable {
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    public void acelerar() {
        System.out.println("La moto " + marca + " " + modelo + " está acelerando.");
    }

    public void recargarCombustible() {
        System.out.println("La moto " + marca + " " + modelo + " está recargando combustible.");
    }
}

public class Programa33 {
  public static void main(String[] args) {
    Vehiculo auto = new Auto("Fiat", "Toro");
    Vehiculo moto = new Moto("Honda", "CBR600");

    Recargable r1 = (Recargable) auto;
    Recargable r2 = (Recargable) moto;

    System.out.println(auto);
    auto.acelerar();
    r1.recargarCombustible();

    System.out.println();

    System.out.println(moto);
    moto.acelerar();
    r2.recargarCombustible();
  }  
}
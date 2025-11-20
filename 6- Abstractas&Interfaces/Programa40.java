//Ejercicio 6.10

abstract class Transporte {
    protected int capacidad;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Transporte(int capacidad) {
        this.capacidad = capacidad;
    }

    public abstract void iniciarViaje();
}

interface Mantenible {
    void realizarMantenimiento();
}

class Colectivo extends Transporte implements Mantenible {
    public Colectivo(int capacidad) {
        super(capacidad);
    }

    public void iniciarViaje() {
        System.out.println("El colectivo ha iniciado su viaje con " + capacidad + " pasajeros.");
    }

    public void realizarMantenimiento() {
        System.out.println("El colectivo está realizando mantenimiento.");
    }
}

class Tren extends Transporte implements Mantenible {
    public Tren(int capacidad) {
        super(capacidad);
    }

    public void iniciarViaje() {
        System.out.println("El tren ha iniciado su viaje con " + capacidad + " pasajeros.");
    }

    public void realizarMantenimiento() {
        System.out.println("El tren está realizando mantenimiento.");
    }
}

public class Programa40 {
    public static void main(String[] args) {
        Colectivo colectivo = new Colectivo(50);
        Tren tren = new Tren(200);

        colectivo.iniciarViaje();
        colectivo.realizarMantenimiento();

        tren.iniciarViaje();
        tren.realizarMantenimiento();
    }
}
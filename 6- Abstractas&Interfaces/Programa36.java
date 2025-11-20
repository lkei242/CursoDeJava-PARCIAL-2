//Ejercicio 6.6

abstract class Dispositivo {
    protected String marca;

    public Dispositivo(String marca) {
        this.marca = marca;
    }

    public abstract void encender();
    public abstract void apagar();

    public String toString() {
        return "Dispositivo marca: "  +  marca;
    }
}

interface Conectable {
    void conectarWifi();
    void desconectarWifi();
}

class Televisor extends Dispositivo implements Conectable {
    public Televisor(String marca) {
        super(marca);
    }

    public void encender() {
        System.out.println("El televisor " + marca + " se ha encendido");
    }

    public void apagar() {
        System.out.println("El televisor " + marca + " se ha apagado");
    }

    public void conectarWifi() {
        System.out.println("El televisor " + marca + " está conectado al Wi-Fi");
    }

    public void desconectarWifi() {
        System.out.println("El televisor " + marca + " se ha desconectado del Wi-Fi");
    }
}

class Computadora extends Dispositivo implements Conectable {
    public Computadora(String marca) {
        super(marca);
    }

    public void encender() {
        System.out.println("La computadora " + marca + " se ha encendido");
    }

    public void apagar() {
        System.out.println("La computadora " + marca + " se ha apagado");
    }

    public void conectarWifi() {
        System.out.println("La computadora " + marca + " está conectado al Wi-Fi");
    }

    public void desconectarWifi() {
        System.out.println("La computadora " + marca + " se ha desconectado del Wi-Fi");
    }
}

public class Programa36 {
    public static void main(String[] args) {
        Dispositivo tv = new Televisor("Admiral");
        Dispositivo pc = new Computadora("Lenovo");

        Conectable c1 = (Conectable) tv;
        Conectable c2 = (Conectable) pc;

        System.out.println("PRUEBA DE DISPOSITIVOS");
        tv.encender();
        c1.conectarWifi();
        c1.desconectarWifi();
        tv.apagar();

        System.out.println();

        pc.encender();
        c2.conectarWifi();
        c2.desconectarWifi();
        pc.apagar();
    }   
}
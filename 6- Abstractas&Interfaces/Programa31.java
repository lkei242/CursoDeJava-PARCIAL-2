//Ejercicio 6.1

abstract class Figura {
    public abstract double calcularArea();
}

interface Dibujable {
    void dibujar();
}

class Circulo extends Figura implements Dibujable {
    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public void dibujar() {
        System.out.println("Dibujando un círculo de radio " + radio);
    }
}

class Rectangulo extends Figura implements Dibujable {
    private double base;
    private double altura;

    public Rectangulo() {
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public void dibujar() {
        System.out.println("Dibujando un rectángulo de base " + base + " y altura " + altura);
    }

}

public class Programa31 {
    public static void main(String[] args) {
        Figura circulo = new Circulo(5);
        Figura rectangulo = new Rectangulo(4, 6);
        
        Dibujable dibujo1 = (Dibujable) circulo;
        Dibujable dibujo2 = (Dibujable) rectangulo;

        System.out.println("Área del círculo: " + circulo.calcularArea());
        dibujo1.dibujar();

        System.out.println("Área del rectángulo: "  + rectangulo.calcularArea());
        dibujo2.dibujar();
    }
}
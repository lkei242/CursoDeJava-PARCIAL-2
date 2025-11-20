//Ejercicio 6.4

abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public String toString() {
        return "Empleado: " + nombre;
    }
}

interface Imprimible {
    void imprimirRecibo();
}

class EmpleadoPorHora extends Empleado implements Imprimible {
    private double valorHora;
    private int horasTrabajadas;
    
    public EmpleadoPorHora(String nombre, double valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    } 

    public double calcularSueldo() {
        return valorHora * horasTrabajadas;
    }

    public void imprimirRecibo() {
        System.out.println("=== RECIBO DE SUELDO POR HORA ===");
        System.out.println(toString());
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Valor por hora: $" + valorHora);
        System.out.println("Sueldo total: $" + calcularSueldo());
        System.out.println("===============================");   
    }
}

class EmpleadoAsalariado extends Empleado implements Imprimible {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    public double calcularSueldo() {
        return salarioMensual;
    } 

    public void imprimirRecibo() {
        System.out.println("=== RECIBO DE SUELDO ASALARIADO ===");
        System.out.println(toString());
        System.out.println("Sueldo mensual: $" + calcularSueldo());
        System.out.println("===============================");
    }
}

public class Programa34 {
    public static void main(String[] args) {
        Empleado e1 = new EmpleadoPorHora("Gersom", 1500, 160);
        Empleado e2 = new EmpleadoAsalariado("Juampa", 100000);

        Imprimible r1 = (Imprimible) e1;
        Imprimible r2 = (Imprimible) e2;

        r1.imprimirRecibo();
        r2.imprimirRecibo();
    }
}
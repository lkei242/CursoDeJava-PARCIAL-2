//Ejercicio 7.1

class Persona {
    private String nombre;
    private int anioNacimiento;

    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }
}

// Interfaz funcional para usar con expresión lambda
interface Filtro {
    boolean aplicar(Persona p);
}

public class Programa41 {
    public static void main(String[] args) {
        int anioActual = 2025;

        // Crear arreglo de personas
        Persona[] personas = {
            new Persona("Ana", 2010),
            new Persona("Bruno", 1995),
            new Persona("Carla", 2008),
            new Persona("David", 2003),
            new Persona("Elena", 1988),
            new Persona("Facundo", 1984),
        };

        // Expresión Lambda que filtra mayores o iguales a 18 años
        Filtro filtroMayores = p -> p.getEdad(anioActual) >= 18;

        System.out.println("=== Personas mayores o iguales a 18 años ===");

        // Aplicar filtro y mostrar resultados
        for (Persona p : personas) {
            if (filtroMayores.aplicar(p)) {
                System.out.println(p.getNombre().toUpperCase() + " - " + p.getEdad(anioActual) + " años");
            }
        }
    }
}
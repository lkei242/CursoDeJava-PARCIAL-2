//Ejercicio 5.1

class Estudiante {
    String nombre;
    int edad;
    float promedio;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, float promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nPromedio: " + promedio;
    }
}

class ColeccionDeEstudiantes{
    private Estudiante[] estudiantes = new Estudiante[5];
    private int contador = 0;

    public void agregarEstudiante(Estudiante e) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = e;
            contador++;
            System.out.println("Estudiante agregado.");
        } else {
            System.out.println("No se pueden agregar más estudiantes.");
        }
    }

    public void mostrarEstudiantes() {
        if (contador == 0) {
            System.out.println("No hay estudiantes en la lista.");
            return;
        } 
        
        for (int i = 0; i < contador; i++) {
            System.out.println(estudiantes[i]);
        }
    }

    public void modificarEstudiante(String nuevoNombre, int nuevaEdad, float nuevoPromedio) {
        if (contador == 0) {
            System.out.println("No hay estudiantes para modificar.");
        }
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].nombre.equalsIgnoreCase(nuevoNombre)) {
                estudiantes[i].edad = nuevaEdad;
                estudiantes[i].promedio = nuevoPromedio;
                System.out.println("Datos del estudiante modificados.");
                return;
            }
        }
    }

    public void eliminarEstudiante(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].nombre.equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                estudiantes[contador - 1] = null;
                contador--;
                System.out.println("Estudiante eliminado.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
}

public class Programa27 {
    public static void main(String[] args) {
        ColeccionDeEstudiantes coleccion = new ColeccionDeEstudiantes();

        coleccion.agregarEstudiante(new Estudiante("Gersom", 18, 8.66f));
        coleccion.agregarEstudiante(new Estudiante("Juampa", 20, 7.53f));

        System.out.println("Estudiantes actuales:");
        coleccion.mostrarEstudiantes();

        coleccion.modificarEstudiante("Gersom", 19, 9.17f);
        System.out.println("\nEstudiantes después de la modificación:");
        coleccion.mostrarEstudiantes();

        coleccion.eliminarEstudiante("Juampa");
        System.out.println("\nEstudiantes después de la eliminación:");
        coleccion.mostrarEstudiantes(); 
    }
}   
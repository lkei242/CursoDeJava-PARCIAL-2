package GuiaDeEjercicios;

class Estudiante {
    String nombre;
    int edad;
    double promedio;

    Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Promedio: " + promedio;
    }
}

class ColeccionDeEstudiantes {
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

    public void listarEstudiantes() {
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(estudiantes[i]);
        }
    }

    public void modificarEstudiante(String nombre, int nuevaEdad, double nuevoPromedio) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].nombre.equalsIgnoreCase(nombre)) {
                estudiantes[i].edad = nuevaEdad;
                estudiantes[i].promedio = nuevoPromedio;
                System.out.println("Datos modificados.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    public void eliminarEstudiante(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].nombre.equalsIgnoreCase(nombre)) {
                // Mover los elementos hacia atrás
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

public class GestionEstudiantes {
    public static void main(String[] args) {
        ColeccionDeEstudiantes coleccion = new ColeccionDeEstudiantes();
        coleccion.agregarEstudiante(new Estudiante("Gersom", 19, 8.5));
        coleccion.agregarEstudiante(new Estudiante("Gaston", 22, 7.9));

        coleccion.listarEstudiantes();

        coleccion.modificarEstudiante("Gersom", 20, 9.0);
        coleccion.listarEstudiantes();

        coleccion.eliminarEstudiante("Gaston");
        coleccion.listarEstudiantes();
    }
}

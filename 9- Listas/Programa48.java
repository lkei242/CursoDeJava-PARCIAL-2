/*9.3) Transformar 
Modificar este programa para que en vez de números enteros se pueda almacenar 
Personas que tengan los datos nombre, apellido, dni (index), edad.*/
public class Programa48 {
    public static void main(String[] args) {
        DatosEstaticos lista = new DatosEstaticos(10);
        lista.add(new Persona("Juan", "Perez", 12345678, 30));
        lista.add(new Persona("Ana", "Lopez", 87654321, 25));
        lista.add(new Persona("Carlos", "Garcia", 45678912, 40));
        lista.add(new Persona("Lucia", "Martinez", 13579246, 19));
        lista.add(new Persona("Maria", "Fernandez", 99999999, 50));

        System.out.println("Lista inicial:");
        lista.printAll();

        System.out.println("Eliminar DNI 45678912: " + lista.removeByDni(45678912));
        lista.printAll();

        int indice = 3;
        Persona persona = lista.get(indice);

        if (persona == null) {
            System.out.println("Indice " + indice + " no valido");
        } else {
            System.out.println("Persona en indice " + indice + ": " + persona);
        }
    }
}

class DatosEstaticos {
    private Persona[] datos;
    private int size;

    public DatosEstaticos(int capacidad) {
        this.datos = new Persona[capacidad];
        this.size = 0;
    }

    public boolean add(Persona p) {
        if (size < datos.length) {
            datos[size] = p;
            size++;
            return true;
        } else {
            System.out.println("Lista llena, no se puede agregar mas personas.");
            return false;
        }
    }

    public boolean removeIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            datos[i] = datos[i + 1];
        }
        size--;
        return true;
    }

    public boolean removeByDni(int dni) {
        for (int i = 0; i < size; i++) {
            if (datos[i].getDni() == dni) {
                return removeIndex(i);
            }
        }
        return false;
    }

    public Persona get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return datos[index];
    }

    public int size() {
        return size;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(datos[i]);
        }
        System.out.println();
    }
}

class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;

    public Persona(String nombre, String apellido, int dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public String toString() {
        return nombre + " " + apellido + " | DNI: " + dni + " | Edad: " + edad;
    }
}
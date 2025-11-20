//Ejercicio 5.3

class Mascota {
    String nombre, especie;
    int edad;

    public Mascota() {
    }

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String toString() {
        return "Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años";
    }
}

class Veterinaria {
    private Mascota[] mascotas = new Mascota[7];
    private int contador = 0;

    public int getContador() {
        return contador;
    }

    public void agregarMascota(Mascota m) {
        if (contador < mascotas.length) {
            mascotas[contador] = m;
            contador++;
            System.out.println("\nMascota agredada.");
        } else {
            System.out.println("\nNo se pueden agregar más mascotas.");
        }
    }

    public void listarMascotas() {
        if (contador == 0) {
            System.out.println("\nNo hay mascotas registradas.");
        } else {
            System.out.println("\nListado de mascotas: ");
            for (int i = 0; i < contador; i++) {
                System.out.println(mascotas[i]);
            }
        }
    }

    public void buscarMascota(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (mascotas[i].nombre.equalsIgnoreCase(nombre)) {
                System.out.println("\nMascota encontrada: " + mascotas[i]);
                return;
            }
        }
        System.out.println("\nMascota no encontrada");
    }

    public void modificarMascota(String nombre, int nuevaEdad) {
        for (int i = 0; i < contador; i++) {
            if (mascotas[i].nombre.equalsIgnoreCase(nombre)) {
                mascotas[i].edad = nuevaEdad;
                System.out.println("\nEdad de la mascota actualizada.");
                return;
            }
        }
        System.out.println("\nMascota no encontrada.");
    }

    public void eliminarMascota(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (mascotas[i].nombre.equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    mascotas[j] = mascotas[j + 1];
                }
                mascotas[contador - 1] = null;
                contador--;
                System.out.println("\nMascota eliminada.");
                return;
            }
        }
        System.out.println("\nMascota no encontrada.");
    }
}

public class Programa29 {
    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();

        veterinaria.agregarMascota(new Mascota("Milo", "Perro", 2));
        veterinaria.agregarMascota(new Mascota("Leyla", "Perro", 15));
        veterinaria.agregarMascota(new Mascota("Michi", "Gato", 3));

        veterinaria.listarMascotas();
        veterinaria.buscarMascota("Milo");
        veterinaria.modificarMascota("Milo", 3);
        
        veterinaria.eliminarMascota("Leyla");
        veterinaria.listarMascotas();

        System.out.println("\nTotal de mascotas registradas: " + veterinaria.getContador());
    }
}
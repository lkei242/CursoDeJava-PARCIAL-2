package GuiaDeEjercicios;

class Mascota {
    String nombre;
    String especie;
    int edad;

    Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Especie: " + especie + " | Edad: " + edad;
    }
}

class Veterinaria {
    private Mascota[] mascotas = new Mascota[7];
    private int contador = 0;

    public void registrarMascota(Mascota m) {
        if (contador < mascotas.length) {
            mascotas[contador] = m;
            contador++;
            System.out.println("Mascota registrada.");
        } else {
            System.out.println("No se pueden registrar más mascotas.");
        }
    }

    
    public void mostrarMascotas() {
        if (contador == 0) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(mascotas[i]);
        }
    }

    public void modificarEdad(String nombre, int nuevaEdad) {
        for (int i = 0; i < contador; i++) {
            if (mascotas[i].nombre.equalsIgnoreCase(nombre)) {
                mascotas[i].edad = nuevaEdad;
                System.out.println("Edad modificada.");
                return;
            }
        }
        System.out.println("Mascota no encontrada.");
    }

    public void eliminarMascota(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (mascotas[i].nombre.equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    mascotas[j] = mascotas[j + 1];
                }
                mascotas[contador - 1] = null;
                contador--;
                System.out.println("Mascota eliminada.");
                return;
            }
        }
        System.out.println("Mascota no encontrada.");
    }

    public void contarMascotas() {
        System.out.println("Total de mascotas registradas: " + contador);
    }
}

public class VeterinariaApp {
    public static void main(String[] args) {
        Veterinaria vet = new Veterinaria();
        vet.registrarMascota(new Mascota("Firulais", "Perro", 3));
        vet.registrarMascota(new Mascota("Mishi", "Gato", 2));

        vet.mostrarMascotas();
        vet.modificarEdad("Mishi", 3);

        vet.eliminarMascota("Firulais");
        vet.mostrarMascotas();

        vet.contarMascotas();
    }
}


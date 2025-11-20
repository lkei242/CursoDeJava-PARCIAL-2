public class ExcepcionesJava8 {

    public static void main(String[] args) {
        System.out.println("=== Ejemplos de excepciones más comunes en Java 8 ===");

        // Descomenta la excepción que quieras probar:

        // ejemploNullPointerException();
        // ejemploNumberFormatException();
        // ejemploArrayIndexOutOfBoundsException();
        // ejemploStringIndexOutOfBoundsException();
        // ejemploArithmeticException();
        // ejemploClassCastException();
        // ejemploIllegalArgumentException();
        // ejemploIllegalStateException();
        // ejemploIOException();
        // ejemploFileNotFoundException();
        // ejemploNoSuchElementException();
    }

    // 1. NullPointerException
    // Ocurre cuando intentas usar un objeto que en realidad es null.
    static void ejemploNullPointerException() {
        String s = null;
        System.out.println(s.length()); // s es null → excepción
    }

    // 2. NumberFormatException
    // Se lanza cuando intentas convertir texto a número y el texto no es válido.
    static void ejemploNumberFormatException() {
        Integer.parseInt("abc"); // "abc" no es un número
    }

    // 3. ArrayIndexOutOfBoundsException
    // Ocurre si intentas acceder a una posición inexistente en un array.
    static void ejemploArrayIndexOutOfBoundsException() {
        int[] nums = {1, 2};
        System.out.println(nums[10]); // índice fuera del tamaño del array
    }

    // 4. StringIndexOutOfBoundsException
    // Similar a la anterior, pero en Strings: acceder a un índice no existente.
    static void ejemploStringIndexOutOfBoundsException() {
        String t = "hola";
        System.out.println(t.charAt(50)); // índice 50 no existe
    }

    // 5. ArithmeticException
    // Ocurre por operaciones matemáticas inválidas, como dividir por cero.
    static void ejemploArithmeticException() {
        int x = 10 / 0; // división entre cero
    }

    // 6. ClassCastException
    // Se lanza cuando intentas convertir (cast) un objeto a un tipo incompatible.
    static void ejemploClassCastException() {
        Object x = "texto";
        Integer y = (Integer) x; // cast imposible: String → Integer
    }

    // 7. IllegalArgumentException
    // Se lanza cuando un método recibe un argumento incorrecto o inválido.
    static void ejemploIllegalArgumentException() {
        usarValor(-5); // -5 no es válido
    }

    static void usarValor(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Valor negativo no permitido.");
        }
    }

    // 8. IllegalStateException
    // Se lanza cuando un objeto está en un estado inválido para realizar la acción.
    static void ejemploIllegalStateException() {
        DemoEstado d = new DemoEstado();
        d.cerrar();
        d.usar(); // el objeto ya fue cerrado → estado inválido
    }

    static class DemoEstado {
        private boolean cerrado = false;

        void cerrar() {
            cerrado = true;
        }

        void usar() {
            if (cerrado) {
                throw new IllegalStateException("El objeto ya está cerrado.");
            }
        }
    }

    // 9. IOException
    // Cubre errores de entrada/salida: archivos, streams, etc.
    static void ejemploIOException() {
        try {
            java.io.FileReader fr = new java.io.FileReader("archivo.txt");
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 10. FileNotFoundException
    // Se lanza cuando intentas abrir un archivo que no existe.
    static void ejemploFileNotFoundException() {
        try {
            new java.io.FileInputStream("no-existe.txt");
        } catch (java.io.FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 11. NoSuchElementException
    // Aparece cuando intentas obtener algo que no existe, por ejemplo leer con Scanner un input vacío.
    static void ejemploNoSuchElementException() {
        java.util.Scanner sc = new java.util.Scanner("");
        System.out.println(sc.nextLine()); // no hay líneas → excepción
    }
}

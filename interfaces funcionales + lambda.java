public class EjemplosLambda {

    // Interfaz funcional con un parámetro
    interface Uno {
        int aplicar(int x);
    }

    // Interfaz funcional con dos parámetros
    interface Dos {
        int operar(int a, int b);
    }

    // Interfaz funcional sin parámetros
    interface Cero {
        void ejecutar();
    }

    public static void main(String[] args) {

        // -------------------------------
        //     FORMAS DE DECLARAR LAMBDAS
        // -------------------------------

        // 1) Sin parámetros, una línea
        Cero l1 = () -> System.out.println("Sin parámetros");

        // 2) Sin parámetros, varias líneas
        Cero l2 = () -> {
            System.out.println("Inicio");
            System.out.println("Fin");
        };

        // 3) Un parámetro, sin tipo explícito
        Uno l3 = x -> x * 2;

        // 4) Un parámetro, con tipo explícito
        Uno l4 = (int x) -> x + 10;

        // 5) Varios parámetros, sin tipos
        Dos l5 = (a, b) -> a + b;

        // 6) Varios parámetros, con tipos explícitos
        Dos l6 = (int a, int b) -> a * b;

        // 7) Varios parámetros, cuerpo de varias líneas con return
        Dos l7 = (a, b) -> {
            int r = a - b;
            return r;
        };

        // -------------------------------
        //     PRUEBAS DE IMPRESIÓN
        // -------------------------------

        l1.ejecutar();
        l2.ejecutar();
        System.out.println("l3: " + l3.aplicar(5));
        System.out.println("l4: " + l4.aplicar(5));
        System.out.println("l5: " + l5.operar(3, 4));
        System.out.println("l6: " + l6.operar(3, 4));
        System.out.println("l7: " + l7.operar(10, 4));
    }
}

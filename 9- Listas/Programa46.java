/*9.1) insertar
Desarrolle un método que permita insertar un nuevo elemento en una posición específica colocando el índice de la lista. 
Si el índice es inválido (menor a 0 o mayor que el tamaño actual), no se debe modificar la lista.*/
import java.util.ArrayList;
import java.util.List;

public class Programa46 {

    public static void insertarElemento(List<Integer> lista, int indice, int elemento) {
        if (indice >= 0 && indice <= lista.size()) {
            lista.add(indice, elemento);
        } else {
            System.out.println("Indice invalido. No se modifico la lista.");
        }
    }

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        System.out.println("Lista original: " + numeros);

        insertarElemento(numeros, 1, 15); //Se inserta el 15 en la posición 1
        System.out.println("Lista modificada: " + numeros);

        insertarElemento(numeros, 10, 99); //Índice inválido
        System.out.println("Lista final: " + numeros);
    }
}
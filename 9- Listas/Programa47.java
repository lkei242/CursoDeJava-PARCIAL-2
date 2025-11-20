/*9.2) Máximo
Implementa un método que devuelva el mayor elemento de la lista. 
El método debe funcionar si los elementos son numéricos Integer. Si la lista está vacía debe devolver null. */
import java.util.List;
import java.util.ArrayList;

public class Programa47 {

    public static Integer maximo(List<Integer> lista) {
        if (lista.isEmpty()) {
            return null;
        }

        Integer max = lista.get(0);
        for (Integer num : lista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(45);
        numeros.add(12);
        numeros.add(89);
        numeros.add(33);

        System.out.println("Lista: " + numeros);
        System.out.println("Maximo: " + maximo(numeros));

        //Caso con lista vacía
        List<Integer> vacia = new ArrayList<>();
        System.out.println("Maximo de lista vacia: " + maximo(vacia));
    }
}
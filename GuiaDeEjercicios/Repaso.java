package GuiaDeEjercicios;

public class Repaso {
    public static void main(String[] args) {
        String texto = "La luna llena ilumina el lago y las luciérnagas lo rodean";
        String[] palabras = texto.split("\\s+");
        int contador = 0;
        for (String palabra: palabras) {
            if (palabra.toLowerCase().startsWith("l")) {
                contador++;
            }
        }
        
        String[] arregloConL = new String[contador];
        String stringConL = "";
        int indice = 0;
        for (String palabra : palabras) {
            if (palabra.toLowerCase().startsWith("l")) {
                arregloConL[indice] = palabra;
                stringConL += (stringConL.isEmpty() ?  "" : " " + palabra);
                indice++;
            }
        }

        System.out.println("Arreglo: ");
        for (String p : arregloConL) {
            System.out.println(p);
        }
    }
}
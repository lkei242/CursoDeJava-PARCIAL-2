public class CartaFigura extends CartaConPalo {
    private char letra;
    
    public CartaFigura(char letra, Palo palo) {
        super(palo);
        this.letra = letra;
    }
    
    public String getRepresentacion() {
        return letra + super.getRepresentacion();
    }
}
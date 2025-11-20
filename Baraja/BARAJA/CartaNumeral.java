public class CartaNumeral extends CartaConPalo {
    private int numero;
    
    public CartaNumeral(int numero, Palo palo) {
        super(palo);
        this.numero = numero;
    }
    
    public String getRepresentacion() {
        return numero + super.getRepresentacion();
    }
}
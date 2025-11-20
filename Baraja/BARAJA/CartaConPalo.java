public abstract class CartaConPalo extends Carta {
    private Palo palo;
    
    public Palo getPalo() {
        return palo;
    }
    
    public CartaConPalo(Palo palo) {
        this.palo = palo;
    }
    
    public String getRepresentacion() {
        return " de " + palo;
    }
}
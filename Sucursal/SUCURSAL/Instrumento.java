public class Instrumento {
    private String ID;
    private double precio;
    private TipoInstrumento tipoinstrumento;
    
    public String getID() {
        return ID;
    }
    
    public TipoInstrumento getTipo() {
        return tipoinstrumento;
    }
    
    public Instrumento() {
        
    }
    
    public Instrumento(String ID, double precio, TipoInstrumento tipoinstrumento) {
     this.ID = ID;
     this.precio = precio;
     this.tipoinstrumento = tipoinstrumento;
    }
    
    public String toString() {
        return "Instrumento{" + "ID=" + ID + ", precio=" + precio + ", tipo=" + tipoinstrumento + '}';
    }
}
public abstract class Examen implements Aprobable {
    private String fecha;
    
    public Examen() {
        
    }
    
    public Examen(String fecha) {
        this.fecha = fecha;
    }
    
    public abstract boolean aprobo();
}
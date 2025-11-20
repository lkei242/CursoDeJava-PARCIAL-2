public class ExamenOral extends Examen {
    private NivelSatisfaccion nivelSatisfaccion;
    
    public ExamenOral(NivelSatisfaccion nivelSatisfaccion, String fecha) {
        super(fecha);
        this.nivelSatisfaccion = nivelSatisfaccion;
    }
    
    public boolean aprobo() {
        return nivelSatisfaccion.ordinal() >= NivelSatisfaccion.SUFICIENTE.ordinal();
    }
}
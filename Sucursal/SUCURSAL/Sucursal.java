import java.util.ArrayList;

public class Sucursal {
    private ArrayList<Instrumento> instrumentos;
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }
    
    public Sucursal() {
        
    }
    
    public Sucursal(String nombre) {
        this.nombre = nombre;
        instrumentos = new ArrayList<>();
    }
    
    public void agregarInstrumento(Instrumento ins) {
        this.instrumentos.add(ins);
    }
    
    public void listarInstrumentos() {
        for (Instrumento instrumento : instrumentos) {
            System.out.println(instrumento);
        }
    }
    
    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> insEncontrados = new ArrayList<>();
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getTipo() == tipo) {
                insEncontrados.add(instrumento);
            }
        }
        return insEncontrados;
    }
    
    public Instrumento borrarInstrumento(String ID) {
        Instrumento insABorrar = buscarInstrumento(ID);
        this.instrumentos.remove(insABorrar);
        return insABorrar;
    }
    
    private Instrumento buscarInstrumento(String ID) {
        int i = 0;
        Instrumento insEncontrado = null;
        while (i < instrumentos.size() && !this.instrumentos.get(i).getID().equalsIgnoreCase(ID)) {
            i++;
        }
        if (i < instrumentos.size()) {
            insEncontrado = this.instrumentos.get(i);
        }
        return insEncontrado;
    }
    
    public double[] porcInstrumentosPorTipo() {
        final int CANT_INSTRUMENTOS = TipoInstrumento.values().length;
        double[] porcentajes = new double[CANT_INSTRUMENTOS];
        for (Instrumento instrumento : instrumentos) {
            porcentajes[instrumento.getTipo().ordinal()]++;
        }
        absolutoPorcentaje(porcentajes);
        return porcentajes;
    }
    
    private void absolutoPorcentaje(double[] porcentajes) {
        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = (porcentajes[i] * 100) / instrumentos.size();
        }
    }
}
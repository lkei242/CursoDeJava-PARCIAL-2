import java.util.ArrayList;

public class Fabrica {
    private ArrayList<Sucursal> sucursales;
    
    public Fabrica() {
        this.sucursales = new ArrayList<>();
    }
    
    public void agregarSucursal(Sucursal suc) {
        this.sucursales.add(suc);
    }
    
    public void listarInstrumentos() {
        for (Sucursal sucursal : sucursales) {
            System.out.println(sucursal.getNombre());
            sucursal.listarInstrumentos();
        }
    }
    
    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> insEncontrados = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            insEncontrados.addAll(sucursal.instrumentosPorTipo(tipo));
        }
        return insEncontrados;
    }
    
    public Instrumento borrarInstrumento(String ID) {
        Instrumento borrado = null;
        int i = 0;
        while (i < sucursales.size() && borrado == null) {
            borrado = sucursales.get(i).borrarInstrumento(ID);
            i++;
        }
        return borrado;
    }
    
    public double[] porcInstrumentosPorTipo(String nombreSucursal) {
        double[] porcentajes = null;
        Sucursal sucEncontrada = buscarSucursal(nombreSucursal);
        if (sucEncontrada != null) {
            porcentajes = sucEncontrada.porcInstrumentosPorTipo();
        }
        return porcentajes;
    }
    
    private Sucursal buscarSucursal(String nombreSucursal) {
        int i = 0;
        Sucursal sucEncontrado = null;
        while (i < sucursales.size() && !this.sucursales.get(i).getNombre().equalsIgnoreCase(nombreSucursal)) {
            i++;
        }
        if (i < sucursales.size()) {
            sucEncontrado = this.sucursales.get(i);
        }
        return sucEncontrado;
    }
}
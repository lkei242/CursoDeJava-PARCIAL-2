import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {    
        Fabrica f = new Fabrica();
        cargarFabrica(f);
        
        f.listarInstrumentos();
        System.out.println("");
        ArrayList<Instrumento> lista = f.instrumentosPorTipo(TipoInstrumento.PERCUSION);
        for (Instrumento instrumento : lista) {
            System.out.println(instrumento);
        }
        
        Instrumento borrado = f.borrarInstrumento("DEF456");
        System.out.println("Se borro: " + borrado);
        System.out.println("");
        f.listarInstrumentos();
        
        System.out.println("");
        double[] porcs = f.porcInstrumentosPorTipo("Sucursal A");
        for (int i = 0; i < porcs.length; i++) {
            System.out.println(porcs[i]);
        }
        System.out.println("");
        
        double[] porcs2 = f.porcInstrumentosPorTipo("Sucursal B");
        for (int i = 0; i < porcs2.length; i++) {
            System.out.println(porcs2[i]);
        }
    }
    
    public static void cargarFabrica(Fabrica f) {
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");

        s1.agregarInstrumento(new Instrumento("ABC123", 13214, TipoInstrumento.CUERDA));
        s1.agregarInstrumento(new Instrumento("DEF456", 13432, TipoInstrumento.VIENTO));
        s1.agregarInstrumento(new Instrumento("GHI789", 15464, TipoInstrumento.PERCUSION));
    
        s2.agregarInstrumento(new Instrumento("BCD123", 52432, TipoInstrumento.CUERDA));
        s2.agregarInstrumento(new Instrumento("EFG456", 45645, TipoInstrumento.VIENTO));
                
        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }
}
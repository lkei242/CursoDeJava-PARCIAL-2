import java.util.ArrayList;

public class CentroEducativo {
    private ArrayList<Alumno> alumnos;
    
    public CentroEducativo() {
        this.alumnos = new ArrayList<>();
    }
    
    public void agregarAlumno(Alumno alum) {
        this.alumnos.add(alum);
    }
    
    public int cantAprobados() {
        int cant = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.aprobo()) {
                cant++;
            }
        }
        return cant;
    }
}
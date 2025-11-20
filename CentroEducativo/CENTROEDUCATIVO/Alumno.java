import java.util.ArrayList;

public class Alumno implements Aprobable {
    private String DNI;
    private String nombre;
    private String apellido;
    private ArrayList<Examen> examenes;
    
    public Alumno() {
    
    }
    
    public Alumno(String DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.examenes = new ArrayList<>();
    }
    
    public void agregarExamen(Examen e) {
        this.examenes.add(e);
    }
    
    public boolean aprobo() {
        int i = 0;
        while(i < this.examenes.size() && this.examenes.get(i).aprobo()) {
            i++;
        }
        return i == this.examenes.size();
    }
}
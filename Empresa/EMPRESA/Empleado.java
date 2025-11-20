import java.time.LocalDate;

public abstract class Empleado {
    private String DNI;
    private String nombre;
    private String apellido;
    private int anioIngreso;
    
    public Empleado() {
        
    }
    
    public Empleado(String DNI, String nombre, String apellido, int anioIngreso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }
    
    public abstract double getSalario();
    
    public String nombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public int antiguedadEnAnios() {
        int anioActual = LocalDate.now().getYear();
        return anioActual - anioIngreso;
    }
}
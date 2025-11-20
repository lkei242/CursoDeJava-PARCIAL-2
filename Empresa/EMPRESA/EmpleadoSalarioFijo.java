public class EmpleadoSalarioFijo extends Empleado {
    private final double PORC1 = 0.05;
    private final double PORC2 = 0.1;
    private final int ANIO1 = 2;
    private final int ANIO2 = 5;
    private double sueldoBasico;
    
    public EmpleadoSalarioFijo() {
        
    }
    
    public EmpleadoSalarioFijo(String DNI, String nombre, String apellido, int anioIngreso, double sueldoBasico) {
        super(DNI, nombre, apellido, anioIngreso);
        this.sueldoBasico = sueldoBasico;
    }
    
    public double getSalario() {
        return sueldoBasico + sueldoBasico * porcAdicional();
    }
    
    private double porcAdicional() {
        int antiguedad = antiguedadEnAnios();
        double porc = 0;
        if (antiguedad > ANIO2) {
            porc = PORC2;
        } else if (antiguedad >= ANIO1) {
            porc = PORC1;
        }
        return porc;
    }
}
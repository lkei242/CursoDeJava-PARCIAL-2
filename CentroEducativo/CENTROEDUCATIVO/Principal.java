public class Principal {
    public static void main(String[] args) {
        CentroEducativo ce = new CentroEducativo();
        
        Alumno gersom = new Alumno("123", "Hotchkyss", "Gersom");
        Alumno luka = new Alumno("124", "Burgos", "Luka");
        Alumno gero = new Alumno("125", "Cespedes", "Geronimo");
        
        gersom.agregarExamen(new ExamenEscrito(40, 7, "00/00/0000"));
        gersom.agregarExamen(new ExamenOral(NivelSatisfaccion.SUFICIENTE, "00/00/0000"));
    
        luka.agregarExamen(new ExamenEscrito(60, 4, "00/00/0000"));
        luka.agregarExamen(new ExamenEscrito(65, 8, "00/00/0000"));
        luka.agregarExamen(new ExamenOral(NivelSatisfaccion.EXCELENTE, "00/00/0000"));
        
        gero.agregarExamen(new ExamenEscrito(100, 9, "00/00/0000"));
        gero.agregarExamen(new ExamenOral(NivelSatisfaccion.INSUFICIENTE, "00/00/0000"));
        gero.agregarExamen(new ExamenOral(NivelSatisfaccion.EXCELENTE, "00/00/0000"));
        
        ce.agregarAlumno(gersom);
        ce.agregarAlumno(luka);
        ce.agregarAlumno(gero);
        
        System.out.println("Cantidad de aprobados: " + ce.cantAprobados());
    }
}
public class Principal {
    public static void main(String[] args) {
        Empresa emp = new Empresa();
        
        emp.agregarEmpleado(new EmpleadoSalarioFijo("123", "Gersom", "Hotchkyss", 2024, 45000));
        emp.agregarEmpleado(new EmpleadoAComision("234", "Fabri", "Alfonsi", 2024, 35000, 100, 500));
        emp.agregarEmpleado(new EmpleadoSalarioFijo("456", "Juampa", "Perez Canal", 2023, 50000));
        emp.agregarEmpleado(new EmpleadoAComision("345", "Gero", "Cespedes", 2024, 30000, 200, 100));
        emp.agregarEmpleado(new EmpleadoSalarioFijo("789", "Guille", "Portillo", 2018, 100000));
    
        emp.mostrarSalarios();
        System.out.println("");
        
        System.out.println(emp.empleadoConMasClientes().nombreCompleto());
    }
}
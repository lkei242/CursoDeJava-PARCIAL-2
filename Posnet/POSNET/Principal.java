public class Principal {
    public static void main(String[] args) {
        Posnet posnet = new Posnet();
        Persona p = new Persona("47224296", "Gersom", "Hotchkyss", "3624696606", "gersomtomasosky@gmail.com");
        TarjetaCredito t = new TarjetaCredito("FakeBank", "1234567890123456", 15000, p, EntidadFinanciera.BIRZA);
    
        System.out.println("Tarjeta antes del pago");
        System.out.println(t);
        
        System.out.println("Ticket tras pagar...");
        Ticket ticketGenerado = posnet.efectuarPago(t, 10000, 5);
        System.out.println(ticketGenerado);
        
        System.out.println("Tarjeta despues del pago");
        System.out.println(t);
    }
}
public class TarjetaCredito {
    private String entidadBancaria;
    private String nroTarjeta;
    private double saldo;
    private EntidadFinanciera entidadFinanciera;
    private Persona titular;
    
    public TarjetaCredito() {
        
    }
    
    public TarjetaCredito(String entidadBancaria, String nroTarjeta, double saldo, Persona titular, EntidadFinanciera entidadFinanciera) {
        this.entidadBancaria = entidadBancaria;
        this.nroTarjeta = nroTarjeta;
        this.saldo = saldo;
        this.titular = titular;
        this.entidadFinanciera = entidadFinanciera;
    }
    
    public boolean tieneSaldoDisponible(double monto) {
        return saldo >= monto;
    }
    
    public void descontar(double monto) {
        saldo -= monto;
    }
    
    public String nombreCompletoDeTitular() {
        return titular.nombreCompleto();
    }
    
    public String toString() {
        return "TarjetaDeCredito{" + "entidadBancaria=" + entidadBancaria + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", entidadFinanciera=" + entidadFinanciera + ", titular=" + titular + '}';
    }
}
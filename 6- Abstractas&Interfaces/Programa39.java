//Ejercicio 6.9

abstract class MetodoPago {
    public abstract void pagar(double monto);
}

interface Reembolsable {
    void reembolsar(double monto);
}

class TarjetaCredito extends MetodoPago implements Reembolsable {
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con tarjeta de crédito");
    }

    public void reembolsar(double monto) {
        System.out.println("Reembolsando $" + monto +  " a la tarjeta de crédito");
    }
}

class TransferenciaBancaria extends MetodoPago {
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " mediante transferencia bancaria");
    }
}

public class Programa39 {
    public static void main(String[] args) {
        MetodoPago pago1 = new TarjetaCredito();
        MetodoPago pago2 = new TransferenciaBancaria();
        Reembolsable tarjeta = new TarjetaCredito();

        pago1.pagar(4500);
        pago2.pagar(8000);
        tarjeta.reembolsar(700);
    }
}
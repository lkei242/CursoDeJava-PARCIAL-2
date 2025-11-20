
/*
empresa de transporte desea un sistema para gestionar su flota de vehículos.
*/
import java.util.ArrayList;
import java.util.Scanner;


abstract class Vehiculo
{
    private String marca;
    private String modelo;
    private int año;
    private int cantidad_ruedas;
    private int cantidad_puertas;
    private double precio;
    private double peso;

    // Setters y Getters:
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }  
    public void setAño(int año) {
        this.año = año;
    }

    public int getCantidad_ruedas() {
        return cantidad_ruedas;
    }
    public void setCantidad_ruedas(int cantidad_ruedas) {
        this.cantidad_ruedas = cantidad_ruedas;
    }

    public int getCantidad_puertas() {
        return cantidad_puertas;
    }
    public void setCantidad_puertas(int cantidad_puertas) {
        this.cantidad_puertas = cantidad_puertas;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Constructores
    public Vehiculo() {}
    public Vehiculo(String marca, String modelo, int año) 
    {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }






    public abstract void mostrarDetalles();
    //modificar el tostring()
}



class Auto extends Vehiculo
{
    //Accesores

    //Constructores
    public Auto() {}
    public Auto (String marca, String modelo, int año, int cantidad_puertas, double precio, double peso)
    {
        super (marca, modelo, año);
        this.setCantidad_puertas(cantidad_puertas);
        this.setPrecio(precio);
        this.setPeso(peso);
    }

    //Metodos
    public void mostrarDetalles()
    {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Año: " + this.getAño());
        System.out.println("Cantidad de puertas: " + this.getCantidad_puertas());
        System.out.println("Precio: " + this.getPrecio());
        System.out.println("Peso: " + this.getPeso());
    }

}

class Moto extends Vehiculo
{
    //Accesores

    //Constructores
    public Moto() {}
    public Moto (String marca, String modelo, int año, double precio, double peso)
    {
        super (marca, modelo, año);
        this.setCantidad_puertas(0);
        this.setPrecio(precio);
        this.setPeso(peso);
    }
    //Metodos
    public void mostrarDetalles()
    {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Año: " + this.getAño());
        System.out.println("Cantidad de puertas: " + this.getCantidad_puertas());
        System.out.println("Precio: " + this.getPrecio());
        System.out.println("Peso: " + this.getPeso());
    }

}


class Camion extends Vehiculo
{
    //Accesores

    //Constructores
    public Camion() {}
    public Camion (String marca, String modelo, int año, int cantidad_puertas, double precio, double peso)
    {
        super (marca, modelo, año);
        this.setCantidad_puertas(cantidad_puertas);
        this.setPrecio(precio);
        this.setPeso(peso);
    }
    //Metodos
    public void mostrarDetalles()
    {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Año: " + this.getAño());
        System.out.println("Cantidad de puertas: " + this.getCantidad_puertas());
        System.out.println("Precio: " + this.getPrecio());
        System.out.println("Peso: " + this.getPeso());
    }

}


class Colectivo extends Vehiculo
{


    //Accesores

    //Constructores
    public Colectivo() {}
    public Colectivo (String marca, String modelo, int año, int cantidad_puertas, double precio, double peso)
    {
        super (marca, modelo, año);
        this.setCantidad_puertas(cantidad_puertas);
        this.setPrecio(precio);
        this.setPeso(peso);
    }

    //Metodos

    public void mostrarDetalles()
    {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Año: " + this.getAño());
        System.out.println("Cantidad de puertas: " + this.getCantidad_puertas());
        System.out.println("Precio: " + this.getPrecio());
        System.out.println("Peso: " + this.getPeso());
    }

}


class GestiónFlota
{


    public static <T extends Vehiculo> void agregarVehiculo (T vehiculo, ArrayList<T> flota) 
    {
        flota.add(vehiculo);
    }

    // Buscar vehículo por criterio (tipo, marca, modelo)
    public static <T extends Vehiculo> T buscarVehiculo (String tipo, String marca, String modelo, ArrayList<T> flota)
    {
        boolean encontrado = false;
        for (T vehiculo : flota) 
        {
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)) 
            {
                if (vehiculo instanceof Auto && tipo.equalsIgnoreCase("Auto")) 
                {
                    encontrado = true;
                    return vehiculo;
                } 
                else if (vehiculo instanceof Moto && tipo.equalsIgnoreCase("Moto")) 
                {
                    encontrado = true;
                    return vehiculo;
                } 
                else if (vehiculo instanceof Camion && tipo.equalsIgnoreCase("Camion")) 
                {
                    encontrado = true;
                    return vehiculo;
                } 
                else if (vehiculo instanceof Colectivo && tipo.equalsIgnoreCase("Colectivo")) 
                {
                    encontrado = true;
                    return vehiculo;
                }
            }   
        }  
        if (encontrado == false)
        { 
            System.out.println("Vehículo no encontrado.");
            return null;
        }
        return null;
    }

    public static <T extends Vehiculo> void modificarVehiculo (T Vehiculo, ArrayList<T> flota) 
    {

    }

    public static <T extends Vehiculo> void eliminarVehiculo (T Vehiculo, ArrayList<T> flota) 
    {

    }

    public static Vehiculo entradaUsuario(Scanner escaner)
    {
        int predeterminado = 1;

        //Despues hacer un try catch por si ingresa mal los datos
        System.out.print("¿Desea usar valores predeterminados para el vehículo? (1=Sí, 0=No): ");
        predeterminado = escaner.nextInt();
        escaner.nextLine(); // Limpiar el buffer

        if (predeterminado == 1)
        {
            System.out.println("Usando valores predeterminados para el vehículo.");
            Vehiculo vehiculoPredeterminado = new Auto( "Toyota", "Corolla", 2020, 4, 20000.0, 1300.0);
            return vehiculoPredeterminado;
        }
        else
        {
            //Despues hacer un try catch por si ingresa mal los datos
            System.out.println("Ingrese los detalles del vehículo:");

            System.out.print("Ingrese el tipo de vehículo (1=Auto,2=Moto,3=Camion,4=Colectivo): ");
            int tipo = escaner.nextInt();
            escaner.nextLine();
            
            System.out.print("Marca: ");
            String marca = escaner.nextLine();

            System.out.print("Modelo: ");
            String modelo = escaner.nextLine();

            System.out.print("Año: ");
            int year = escaner.nextInt();
            escaner.nextLine();

            System.out.print("Precio: ");
            double precio = escaner.nextDouble();
            escaner.nextLine();

            System.out.print("Peso: ");
            double peso = escaner.nextDouble();
            escaner.nextLine();


            switch (tipo)
            {
                case 1:
                    System.out.print("Cantidad de puertas: ");
                    int puertasAuto = escaner.nextInt();
                    escaner.nextLine();
                    return new Auto(marca, modelo, year, puertasAuto, precio, peso);
                case 2:
                    // Moto tiene 0 puertas por diseño
                    return new Moto(marca, modelo, year, precio, peso);
                case 3:
                    System.out.print("Cantidad de puertas: ");
                    int puertasCamion = escaner.nextInt();
                    escaner.nextLine();
                    return new Camion(marca, modelo, year, puertasCamion, precio, peso);
                case 4:
                    System.out.print("Cantidad de puertas: ");
                    int puertasColectivo = escaner.nextInt();
                    escaner.nextLine();
                    return new Colectivo(marca, modelo, year, puertasColectivo, precio, peso);
                default:
                    System.out.println("Tipo no reconocido, usando vehículo predeterminado.");
                    return new Auto("Toyota", "Corolla", 2020, 4, 20000.0, 1300.0);
            }
        }
    }

}








public class modeloP2_solucion_Mia 
{
    public static ArrayList<Vehiculo> flota = new ArrayList<Vehiculo>();
    
    public static void main (String[] args)
    {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Bienvenido al Sistema de Gestión de Flota de Vehículos");
        int deseo = 1;
        while (deseo == 1)
        {
            System.out.println("-----------------------------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Buscar vehículo");
            System.out.println("3. Modificar vehículo");
            System.out.println("4. Eliminar vehículo");
            int opcion = 0;
            //Despues hacer un try catch por si no ingresa un numero
            opcion = escaner.nextInt();
            escaner.nextLine(); // Limpiar el buffer

            switch (opcion)
            {
                case 1:
                    System.out.println("Agregar vehículo seleccionado.");
                    //Llamar a la funcion agregar vehiculo
                    Vehiculo vehiculoNuevo = GestiónFlota.entradaUsuario(escaner);
                    GestiónFlota.agregarVehiculo(vehiculoNuevo, flota);
                    break;
                case 2:
                    System.out.println("Buscar vehículo seleccionado.");
                    //Llamar a la funcion buscar vehiculo
                    break;
                case 3:
                    System.out.println("Modificar vehículo seleccionado.");
                    //Llamar a la funcion modificar vehiculo
                    break;
                case 4:
                    System.out.println("Eliminar vehículo seleccionado.");
                    //Llamar a la funcion eliminar vehiculo
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 4.");
                    break;
            
            }

            System.out.println("¿Desea realizar otra operación? (1: Sí, 0: No)");
            deseo = escaner.nextInt();
            escaner.nextLine();
        }




        


        

    }
}

package Concesionaria;

/**
 * Clase abstracta que sirve como base para todos los vehículos de la flota. Define los atributos
 * comunes como marca, modelo, patente, etc. No se pueden crear objetos directamente de `Vehiculo`,
 * solo de sus clases hijas.
 */
public abstract class Vehiculo {
    // Atributos protegidos para ser accesibles desde las clases hijas.
    private String marca;
    private String modelo;
    private int anio;
    private String patente; // Formato: ABC123
    private double kilometraje;

    /**
     * Constructor para inicializar un nuevo vehículo. Valida que el formato de la patente sea
     * correcto (3 letras y 3 números).
     * 
     * @param marca La marca del vehículo.
     * @param modelo El modelo del vehículo.
     * @param anio El año de fabricación.
     * @param patente La patente única del vehículo.
     * @param kilometraje El kilometraje actual.
     * @throws PatenteInvalidaException si la patente no cumple con el formato "ABC123".
     */
    public Vehiculo(String marca, String modelo, int anio, String patente, double kilometraje)
            throws PatenteInvalidaException {
        // Se utiliza una expresión regular para validar el formato de la patente.
        if (!patente.matches("[A-Z]{3}[0-9]{3}")) {
            // Si el formato no es válido, se lanza una excepción personalizada.
            throw new PatenteInvalidaException(
                    "La patente '" + patente + "' no es válida. Debe tener el formato ABC123.");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters para acceder y modificar los atributos de la clase.
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * Método abstracto que obliga a las clases hijas a implementar una forma de identificarse,
     * devolviendo su tipo (ej. "Auto", "Camión").
     */
    public abstract String getTipo();

    /**
     * Muestra la información básica del vehículo en la consola.
     */
    public void mostrarInfo() {
        System.out.printf("Patente: %s, Marca: %s, Modelo: %s, Año: %d, Km: %.1f%n", patente, marca,
                modelo, anio, kilometraje);
    }

    /**
     * Sobrecarga del método `mostrarInfo` que permite opcionalmente incluir el tipo de vehículo.
     * 
     * @param conTipo Si es `true`, se muestra el tipo de vehículo.
     */
    public void mostrarInfo(boolean conTipo) {
        if (conTipo) {
            System.out.printf("Patente: %s, Tipo: %s, Marca: %s, Modelo: %s, Año: %d, Km: %.1f%n",
                    patente, getTipo(), marca, modelo, anio, kilometraje);
        } else {
            mostrarInfo();
        }
    }

    /**
     * Sobrescribe el método `equals` para que dos vehículos se consideren iguales si tienen la
     * misma patente. Es fundamental para evitar duplicados y para las búsquedas.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || !(o instanceof Vehiculo))
            return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return patente.equals(vehiculo.patente);
    }

    /**
     * Sobrescribe el método `hashCode`. Es una buena práctica que si se sobrescribe `equals`,
     * también se sobrescriba `hashCode`. Se basa en la patente para ser consistente con el método
     * `equals`.
     */
    @Override
    public int hashCode() {
        return patente.hashCode();
    }
}

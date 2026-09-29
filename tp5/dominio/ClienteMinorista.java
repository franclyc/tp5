package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Clientes {

    private int dni;
    private boolean tienePami;

    public ClienteMinorista() {
        super();
    }

    public ClienteMinorista(String direccion, String nombre, String apellido,
                            String contrasenia, int dni, boolean tienePami) {
        super(direccion, nombre, apellido, contrasenia);
        this.dni = dni;
        this.tienePami = tienePami;
    }

    @Override
    public int obtenerCodCliente() {
        return dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isTienePami() {
        return tienePami;
    }

    public void setTienePami(boolean tienePami) {
        this.tienePami = tienePami;
    }

    @Override
    public String toString() {
        return "ClienteMinorista{" +
                "dni=" + dni +
                ", tienePami=" + tienePami +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}'; 
    }
}
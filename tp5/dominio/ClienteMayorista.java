package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Clientes {

    private int codCliente;

    public ClienteMayorista() {
        super();
    }

    public ClienteMayorista(String direccion, String nombre, String apellido,
                            String contrasenia, int codCliente) {
        super(direccion, nombre, apellido, contrasenia);
        this.codCliente = codCliente;
    }

    @Override
    public int obtenerCodCliente() {
        return codCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "ClienteMayorista{" +
                "codCliente=" + codCliente +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}'; 
    }
}
package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleados {

    protected int codigo;
    protected String nombre;
    protected String contrasenia;

    public Empleados() { }

    public Empleados(int codigo, String nombre, String contrasenia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nombre: " + nombre;
    }
}
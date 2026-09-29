package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Clientes {// agregar la clase ClienteMayorista para poder crear instancias de esta clase y heredar de la clase Clientes

    private int codCliente;// crear un atributo para poder almacenar el codigo del cliente mayorista

    public ClienteMayorista() {// crear un constructor sin parametros para poder crear instancias de la clase ClienteMayorista
        super();// llamar al constructor de la clase padre Clientes para inicializar los atributos heredados
    }

    public ClienteMayorista(String direccion, String nombre, String apellido,  // agregar un constructor con parametros para poder crear instancias de la clase ClienteMayorista
                            String contrasenia, int codCliente) { // agregar un constructor con parametros para poder crear instancias de la clase ClienteMayorista
        super(direccion, nombre, apellido, contrasenia);// llamar al constructor de la clase padre Clientes para inicializar los atributos heredados con los valores ingresados
        this.codCliente = codCliente;
    }// agregar un constructor con parametros para poder crear instancias de la clase ClienteMayorista

    @Override// indicar que se esta sobreescribiendo el metodo obtenerCodCliente de la clase padre Clientes
    public int obtenerCodCliente() {//
        return codCliente;
    }// agregar un metodo para poder obtener el codigo del cliente mayorista

    public int getCodCliente() {// agregar un metodo para poder obtener el codigo del cliente mayorista
        return codCliente;// retornar el codigo del cliente mayorista
    }

    public void setCodCliente(int codCliente) {// agregar un metodo para poder establecer el codigo del cliente mayorista
        this.codCliente = codCliente;// establecer el codigo del cliente mayorista con el valor ingresado
    }

    @Override// indicar que se esta sobreescribiendo el metodo toString de la clase padre Clientes
    public String toString() {// crear un metodo para poder mostrar la informacion del cliente mayorista
        return "ClienteMayorista{" +//  retornar la informacion del cliente mayorista concatenando el string "ClienteMayorista{" con los atributos del cliente mayorista
                "codCliente=" + codCliente +// concatenar el string "codCliente=" con el valor del atributo codCliente
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}'; // retornar la informacion del cliente mayorista concatenando el string "}" con los atributos del cliente mayorista
    }
}
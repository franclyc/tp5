package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Clientes {// agregar la clase ClienteMinorista para poder crear instancias de esta clase y heredar de la clase Clientes

    private int dni;// crear un atributo para poder almacenar el dni del cliente minorista
    private boolean tienePami;// crear un atributo para poder almacenar si el cliente minorista tiene pami o no

    public ClienteMinorista() {// crear un constructor sin parametros para poder crear instancias de la clase ClienteMinorista
        super();// llamar al constructor de la clase padre Clientes para inicializar los atributos heredados
    }

    public ClienteMinorista(String direccion, String nombre, String apellido,// agregar un constructor con parametros para poder crear instancias de la clase ClienteMinorista
                            String contrasenia, int dni, boolean tienePami) {// agregar un constructor con parametros para poder crear instancias de la clase ClienteMinorista
        super(direccion, nombre, apellido, contrasenia);// llamar al constructor de la clase padre Clientes para inicializar los atributos heredados con los valores ingresados
        this.dni = dni;// establecer el dni del cliente minorista con el valor ingresado
        this.tienePami = tienePami;// establecer si el cliente minorista tiene pami o no con el valor ingresado
    }

    @Override// indicar que se esta sobreescribiendo el metodo obtenerCodCliente de la clase padre Clientes
    public int obtenerCodCliente() {// crear un metodo para poder obtener el dni del cliente minorista
        return dni;
    }// agregar un metodo para poder obtener el dni del cliente minorista

    public int getDni() {// agregar un metodo para poder obtener el dni del cliente minorista
        return dni;// retornar el dni del cliente minorista
    }

    public void setDni(int dni) {// agregar un metodo para poder establecer el dni del cliente minorista
        this.dni = dni; 
    }// agregar un metodo para poder establecer el dni del cliente minorista

    public boolean isTienePami() {// agregar un metodo para poder obtener si el cliente minorista tiene pami o no
        return tienePami;// retornar si el cliente minorista tiene pami o no
    }

    public void setTienePami(boolean tienePami) {// agregar un metodo para poder establecer si el cliente minorista tiene pami o no
        this.tienePami = tienePami;// establecer si el cliente minorista tiene pami o no con el valor ingresado
    }

    @Override// indicar que se esta sobreescribiendo el metodo toString de la clase padre Clientes
    public String toString() {// crear un metodo para poder mostrar la informacion del cliente minorista
        return "ClienteMinorista{" +
                "dni=" + dni +
                ", tienePami=" + tienePami +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}'; 
    }// agregar un metodo para poder mostrar la informacion del cliente minorista
}// finalizar la clase ClienteMinorista
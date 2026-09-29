package ar.edu.unju.escmi.tp5.collections; // se agrego el package para que funcione correctamente la clase CollectionCliente

import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista; // importar la clase ClienteMayorista para poder crear instancias de esta clase
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;// importar la clase ClienteMinorista para poder crear instancias de esta clase
import ar.edu.unju.escmi.tp5.dominio.Clientes;// importar la clase Clientes para poder crear instancias de esta clase
import java.util.ArrayList; //import java.util.List; // importar la clase List para poder utilizar listas en la clase CollectionCliente
import java.util.List; //

public class CollectionCliente { // agregar la clase CollectionCliente para poder manejar la lista de clientes

    public static List<Clientes> Clientes = new ArrayList<>();// crear una lista de clientes para poder almacenar los clientes creados

    public static boolean autenticacion(int cod, String contrasenia) {// crear un metodo para poder autenticar a los clientes

        Clientes cliente = buscarCliente(cod);// buscar el cliente en la lista de clientes utilizando el codigo del cliente

        return cliente != null// verificar que el cliente no sea nulo y que la contraseña ingresada sea igual a la contraseña del cliente
                && cliente.getContrasenia() != null// verificar que la contraseña del cliente no sea nula
                && cliente.getContrasenia().equals(contrasenia);// verificar que la contraseña ingresada sea igual a la contraseña del cliente
    }

    public static void precargarCliente() {// crear un metodo para poder precargar clientes en la lista de clientes

        Clientes.clear();// limpiar la lista de clientes para evitar duplicados

        Clientes.add(new ClienteMayorista(//    agregar un cliente mayorista a la lista de clientes
                "Av. Belgrano 123",
                "Juan",
                "Perez",
                "1234",
                1001
        ));

        Clientes.add(new ClienteMinorista(// agregar un cliente minorista a la lista de clientes
                "San Martin 456",
                "Maria",
                "Gomez",
                "5678",
                20310458,
                true
        ));

        Clientes.add(new ClienteMinorista(// agregar otro cliente minorista a la lista de clientes
                "Alvear 789",
                "Carlos",
                "Lopez",
                "abcd",
                25123456,
                false
        )); //terminar de agregar otro cliente minorista a la lista de clientes
    }

    public static Clientes buscarCliente(int cod) {// crear un metodo para poder buscar un cliente en la lista de clientes utilizando el codigo del cliente

        for (Clientes cliente : Clientes) {// recorrer la lista de clientes utilizando un bucle for-each para poder buscar el cliente con el codigo ingresado

            if (cliente.obtenerCodCliente() == cod) {// verificar si el codigo del cliente es igual al codigo ingresado
                return cliente;// retornar el cliente encontrado
            }
        }

        return null;// retornar null si no se encuentra el cliente con el codigo ingresado
    }
}
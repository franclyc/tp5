package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
import ar.edu.unju.escmi.tp5.dominio.Clientes;
import java.util.ArrayList;
import java.util.List;

public class CollectionCliente {

    public static List<Clientes> Clientes = new ArrayList<>();

    public static boolean autenticacion(int cod, String contrasenia) {

        Clientes cliente = buscarCliente(cod);

        return cliente != null
                && cliente.getContrasenia() != null
                && cliente.getContrasenia().equals(contrasenia);
    }

    public static void precargarCliente() {

        Clientes.clear();

        Clientes.add(new ClienteMayorista(
                "Av. Belgrano 123",
                "Juan",
                "Perez",
                "1234",
                1001
        ));

        Clientes.add(new ClienteMinorista(
                "San Martin 456",
                "Maria",
                "Gomez",
                "5678",
                20310458,
                true
        ));

        Clientes.add(new ClienteMinorista(
                "Alvear 789",
                "Carlos",
                "Lopez",
                "abcd",
                25123456,
                false
        ));
    }

    public static Clientes buscarCliente(int cod) {

        for (Clientes cliente : Clientes) {

            if (cliente.obtenerCodCliente() == cod) {
                return cliente;
            }
        }

        return null;
    }
}
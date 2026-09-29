package ar.edu.unju.escmi.tp5.collections;//

import java.util.ArrayList;//
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Facturas;

public class CollectionFactura { // agregar la clase CollectionFactura para poder manejar la lista de facturas

    public static List<Facturas> facturas = new ArrayList<>();// crear una lista de facturas para poder almacenar las facturas creadas

    private static int ultimoNumero = 0;// crear una variable para poder almacenar el ultimo numero de factura creado

    public static int siguienteNumero() {// crear un metodo para poder obtener el siguiente numero de factura a crear
        ultimoNumero++;// incrementar el ultimo numero de factura creado en 1
        return ultimoNumero;// retornar el siguiente numero de factura a crear
    }

    public static void agregar(Facturas f) {// crear un metodo para poder agregar una factura a la lista de facturas
        if (f != null && buscar(f.getNroFactura()) == null) {// verificar que la factura no sea nula y que no exista una factura con el mismo numero de factura en la lista de facturas
            facturas.add(f);// agregar la factura a la lista de facturas
        }
    }

    public static Facturas buscar(int nroFactura) {// crear un metodo para poder buscar una factura en la lista de facturas utilizando el numero de factura
        for (Facturas f : facturas) {// recorrer la lista de facturas utilizando un bucle for-each para poder buscar la factura con el numero de factura ingresado
            if (f.getNroFactura() == nroFactura) {// verificar si el numero de factura es igual al numero de factura ingresado
                return f;// retornar la factura encontrada
            }
        }
        return null;// retornar null si no se encuentra la factura con el numero de factura ingresado
    }

    public static double totalVentas() {// crear un metodo para poder obtener el total de ventas realizadas sumando el total de cada factura en la lista de facturas
        double suma = 0;// crear una variable para poder almacenar la suma del total de ventas realizadas
        for (Facturas f : facturas) {// recorrer la lista de facturas utilizando un bucle for-each para poder sumar el total de cada factura en la lista de facturas
            suma += f.getTotal();// sumar el total de cada factura en la lista de facturas a la variable suma
        }
        return suma;// retornar la suma del total de ventas realizadas
    }

    public static void mostrar() {// crear un metodo para poder mostrar todas las facturas registradas en la lista de facturas
        if (facturas.isEmpty()) {
            System.out.println("No hay ventas registradas.");   
            return;// retornar si la lista de facturas esta vacia
        }
        for (Facturas f : facturas) {// recorrer la lista de facturas utilizando un bucle for-each para poder mostrar todas las facturas registradas en la lista de facturas
            System.out.println(f);// mostrar la factura en la consola
        }
    }
}

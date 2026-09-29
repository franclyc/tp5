package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Facturas;

public class CollectionFactura {

    public static List<Facturas> facturas = new ArrayList<>();

    private static int ultimoNumero = 0;

    public static int siguienteNumero() {
        ultimoNumero++;
        return ultimoNumero;
    }

    public static void agregar(Facturas f) {
        if (f != null && buscar(f.getNroFactura()) == null) {
            facturas.add(f);
        }
    }

    public static Facturas buscar(int nroFactura) {
        for (Facturas f : facturas) {
            if (f.getNroFactura() == nroFactura) {
                return f;
            }
        }
        return null;
    }

    public static double totalVentas() {
        double suma = 0;
        for (Facturas f : facturas) {
            suma += f.getTotal();
        }
        return suma;
    }

    public static void mostrar() {
        if (facturas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Facturas f : facturas) {
            System.out.println(f);
        }
    }
}

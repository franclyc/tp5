package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Empleados;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;

public class CollectionEmpleados {

    public static List<Empleados> Empleados = new ArrayList<>();

    public static boolean autenticacion(String nombre, String contrasenia) {
        for (Empleados empleado : Empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static String obtenerTipoEmpleado(String nombre, String contrasenia) {
        Empleados empleado = buscarEmpleado(nombre, contrasenia);
        if (empleado instanceof EncargadoVentas) {
            return "Encargado de ventas";
        } else if (empleado instanceof AgenteAdministrativo) {
            return "Agente administrativo";
        }
        return null;
    }

    public static Empleados buscarEmpleado(String nombre, String contrasenia) {
        for (Empleados empleado : Empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getContrasenia().equals(contrasenia)) {
                return empleado;
            }
        }
        return null;
    }

    public static void precargarEmpleado() {

        Empleados.clear();

        Empleados.add(new EncargadoVentas(1, "marcos", "1234"));
        Empleados.add(new AgenteAdministrativo(2, "lucia", "5678"));
        Empleados.add(new AgenteAdministrativo(3, "diego", "9012"));
    }
}
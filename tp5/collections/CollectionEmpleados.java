package ar.edu.unju.escmi.tp5.collections;// se agrego el package para que funcione correctamente la clase CollectionEmpleados

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Empleados;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;

public class CollectionEmpleados {// agregar la clase CollectionEmpleados para poder manejar la lista de empleados

    public static List<Empleados> Empleados = new ArrayList<>();// crear una lista de empleados para poder almacenar los empleados creados

    public static boolean autenticacion(String nombre, String contrasenia) {// crear un metodo para poder autenticar a los empleados
        for (Empleados empleado : Empleados) {// recorrer la lista de empleados utilizando un bucle for-each para poder buscar el empleado con el nombre y contraseña ingresados
            if (empleado.getNombre().equals(nombre) && empleado.getContrasenia().equals(contrasenia)) {// verificar si el nombre y la contraseña del empleado son iguales al nombre y la contraseña ingresados
                return true;// retornar true si se encuentra el empleado con el nombre y la contraseña ingresados
            }
        }
        return false;// retornar false si no se encuentra el empleado con el nombre y la contraseña ingresados
    }

    public static String obtenerTipoEmpleado(String nombre, String contrasenia) {// crear un metodo para poder obtener el tipo de empleado (Encargado de ventas o Agente administrativo) utilizando el nombre y la contraseña ingresados
        Empleados empleado = buscarEmpleado(nombre, contrasenia);// buscar el empleado en la lista de empleados utilizando el nombre y la contraseña ingresados
        if (empleado instanceof EncargadoVentas) {// verificar si el empleado es una instancia de la clase EncargadoVentas
            return "Encargado de ventas";// retornar "Encargado de ventas" si el empleado es una instancia de la clase EncargadoVentas
        } else if (empleado instanceof AgenteAdministrativo) {// verificar si el empleado es una instancia de la clase AgenteAdministrativo
            return "Agente administrativo";// retornar "Agente administrativo" si el empleado es una instancia de la clase AgenteAdministrativo
        }
        return null;// retornar null si el empleado no es una instancia de ninguna de las clases EncargadoVentas o AgenteAdministrativo
    }

    public static Empleados buscarEmpleado(String nombre, String contrasenia) {// crear un metodo para poder buscar un empleado en la lista de empleados utilizando el nombre y la contraseña ingresados
        for (Empleados empleado : Empleados) {//    recorrer la lista de empleados utilizando un bucle for-each para poder buscar el empleado con el nombre y la contraseña ingresados
            if (empleado.getNombre().equals(nombre) && empleado.getContrasenia().equals(contrasenia)) {// verificar si el nombre y la contraseña del empleado son iguales al nombre y la contraseña ingresados
                return empleado;// retornar el empleado encontrado
            }
        }
        return null;// retornar null si no se encuentra el empleado con el nombre y la contraseña ingresados
    }

    public static void precargarEmpleado() {// crear un metodo para poder precargar empleados en la lista de empleados

        Empleados.clear();// limpiar la lista de empleados para evitar duplicados

        Empleados.add(new EncargadoVentas(1, "marcos", "1234"));// agregar un encargado de ventas a la lista de empleados
        Empleados.add(new AgenteAdministrativo(2, "lucia", "5678"));// agregar un agente administrativo a la lista de empleados
        Empleados.add(new AgenteAdministrativo(3, "diego", "9012"));// agregar un agente administrativo a la lista de empleados
    }
}
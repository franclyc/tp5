package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.Clientes;
import ar.edu.unju.escmi.tp5.dominio.Productos;
import java.util.ArrayList;
import java.util.List;

public class CollectionProducto {// agregar la clase CollectionProducto para poder manejar la lista de productos

    public static List<Productos> Productos = new ArrayList<>();// crear una lista de productos para poder almacenar los productos creados

    public static int verificarStock(int cod) {// crear un metodo para poder verificar el stock de un producto utilizando el codigo del producto

        Productos producto = buscar(cod);// buscar el producto en la lista de productos utilizando el codigo del producto

        if (producto != null) {// verificar que el producto no sea nulo
            return producto.getStock();// retornar el stock del producto encontrado
        }// retornar 0 si el producto es nulo

        return 0;// retornar 0 si el producto es nulo
    }

    public static Productos buscar(int codProducto) {// crear un metodo para poder buscar un producto en la lista de productos utilizando el codigo del producto

        for (Productos producto : Productos) {// recorrer la lista de productos utilizando un bucle for-each para poder buscar el producto con el codigo ingresado

            if (producto.getCodigo() == codProducto) {// verificar si el codigo del producto es igual al codigo ingresado
                return producto;// retornar el producto encontrado
            }
        }

        return null;//  retornar null si no se encuentra el producto con el codigo ingresado
    }

    public static void agregar(Productos p) {// crear un metodo para poder agregar un producto a la lista de productos

        if (p == null) {// verificar que el producto no sea nulo
            return;// retornar si el producto es nulo
        }

        if (buscar(p.getCodigo()) == null) {// verificar que no exista un producto con el mismo codigo en la lista de productos
            Productos.add(p);// agregar el producto a la lista de productos
        }
    }

    public static boolean comprobarStockVenta(Clientes c, Productos p, int cantidad) {// crear un metodo para poder comprobar si un cliente puede realizar una venta de un producto en una cantidad determinada
        if (c == null || p == null || cantidad <= 0) {// verificar que el cliente, el producto y la cantidad no sean nulos o menores o iguales a 0
            return false;// retornar false si el cliente, el producto o la cantidad son nulos o menores o iguales a 0
        }

        Productos producto = buscar(p.getCodigo());// buscar el producto en la lista de productos utilizando el codigo del producto

        if (producto == null || producto.getStock() < cantidad) {// verificar que el producto no sea nulo y que el stock del producto sea mayor o igual a la cantidad ingresada
            return false;
        }// retornar false si el producto es nulo o si el stock del producto es menor a la cantidad ingresada

        if (c instanceof ClienteMayorista && cantidad % 10 != 0) {// verificar que si el cliente es un cliente mayorista, la cantidad ingresada sea un multiplo de 10
            return false;
        }// retornar false si el cliente es un cliente mayorista y la cantidad ingresada no es un multiplo de 10

        return true;// retornar true si el cliente puede realizar la venta del producto en la cantidad ingresada
    }

    public static boolean descontarStock(int codigo, int cantidad) {// crear un metodo para poder descontar el stock de un producto en una cantidad determinada
        Productos producto = buscar(codigo);// buscar el producto en la lista de productos utilizando el codigo del producto

        if (producto == null || cantidad <= 0 || producto.getStock() < cantidad) {//    verificar que el producto no sea nulo, que la cantidad ingresada sea mayor a 0 y que el stock del producto sea mayor o igual a la cantidad ingresada
            return false;// retornar false si el producto es nulo, si la cantidad ingresada es menor o igual a 0 o si el stock del producto es menor a la cantidad ingresada
        }

        producto.setStock(producto.getStock() - cantidad);// descontar la cantidad ingresada del stock del producto encontrado
        return true;//  
    }// retornar true si se descuenta el stock del producto encontrado
}
package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

public class EncargadoVentas extends Empleados {

    public EncargadoVentas() {
        super();
    }

    public EncargadoVentas(int codigo, String nombre, String contrasenia) {
        super(codigo, nombre, contrasenia);
    }

    public void mostrarVentas() {
        CollectionFactura.mostrar();
    }

    public void mostrarTotalVentas() {
        System.out.println("Total de todas las ventas: $" + CollectionFactura.totalVentas());
    }

    public void verificarStock(int codigoProducto) {
        Productos producto = CollectionProducto.buscar(codigoProducto);
        if (producto != null) {
            System.out.println("Producto: " + producto.getDescripcion());
            System.out.println("Stock disponible: " + producto.getStock());
        } else {
            System.out.println("No existe un producto con el codigo " + codigoProducto);
        }
    }

    @Override
    public String toString() {
        return "Encargado de ventas -> " + super.toString();
    }
}
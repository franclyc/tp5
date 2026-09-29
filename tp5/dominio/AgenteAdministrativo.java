package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
   import java.util.HashMap;
   import java.util.Map;

public class AgenteAdministrativo extends Empleados {// agregar la clase AgenteAdministrativo que hereda de la clase Empleados para poder crear instancias de esta clase

    public AgenteAdministrativo() {// crear un constructor vacio para poder crear instancias de la clase AgenteAdministrativo
        super();// llamar al constructor de la clase padre Empleados para inicializar los atributos heredados
    }

    public AgenteAdministrativo(int codigo, String nombre, String contrasenia) {// crear un constructor con parametros para poder crear instancias de la clase AgenteAdministrativo
        super(codigo, nombre, contrasenia);
    }// llamar al constructor de la clase padre Empleados para inicializar los atributos heredados con los valores ingresados

    public void agregarProducto(Productos p) {// crear un metodo para poder agregar un producto a la lista de productos
        if (p == null) {// verificar que el producto no sea nulo
            System.out.println("El producto no es valido");// retornar si el producto es nulo
            return;
        }
        if (CollectionProducto.buscar(p.getCodigo()) == null) {// verificar que no exista un producto con el mismo codigo en la lista de productos
            CollectionProducto.agregar(p);// agregar el producto a la lista de productos
            System.out.println("Producto agregado correctamente");  //agregar un mensaje para indicar que el producto se agrego correctamente
        } else {// si ya existe un producto con el mismo codigo en la lista de productos
            System.out.println("Ya existe un producto con el codigo " + p.getCodigo());// agregar un mensaje para indicar que ya existe un producto con el mismo codigo
        }
    }// crear un metodo para poder realizar una venta de productos a un cliente y registrar la factura correspondiente

    public boolean realizarVenta(Facturas factura) {// crear un metodo para poder realizar una venta de productos a un cliente y registrar la factura correspondiente
    if (factura == null || factura.getCliente() == null) {// verificar que la factura y el cliente no sean nulos
        System.out.println("La factura debe tener un cliente.");// retornar false si la factura o el cliente son nulos
        return false;
    }

    if (factura.getDetalles() == null || factura.getDetalles().isEmpty()) {// verificar que la factura tenga al menos un detalle de producto
        System.out.println("La factura debe tener al menos un producto.");// retornar false si la factura no tiene detalles de producto
        return false;// retornar false si la factura no tiene detalles de producto
    }

    if (CollectionFactura.buscar(factura.getNroFactura()) != null) {// verificar que no exista una factura con el mismo numero de factura en la lista de facturas
        System.out.println("Ya existe una factura con ese numero.");// retornar false si ya existe una factura con el mismo numero de factura en la lista de facturas
        return false;// retornar false si ya existe una factura con el mismo numero de factura en la lista de facturas
    }

       Map<Integer, Integer> necesario = new HashMap<>();// crear un mapa para almacenar la cantidad de cada producto necesario para realizar la venta
       for (Detalles d : factura.getDetalles()) {// recorrer la lista de detalles de la factura para verificar el stock de cada producto necesario para realizar la venta
           necesario.merge(d.getProducto().getCodigo(), d.getCantidad(), Integer::sum);// agregar la cantidad de cada producto necesario para realizar la venta al mapa, sumando las cantidades si ya existe el producto en el mapa
       }
       for (Map.Entry<Integer, Integer> e : necesario.entrySet()) {// recorrer el mapa de productos necesarios para verificar el stock de cada producto necesario para realizar la venta
           if (CollectionProducto.verificarStock(e.getKey()) < e.getValue()) {// verificar que el stock de cada producto necesario para realizar la venta sea mayor o igual a la cantidad necesaria para realizar la venta
               System.out.println("Stock insuficiente para el producto " + e.getKey() + ". Venta cancelada.");// retornar false si el stock de algun producto necesario para realizar la venta es menor a la cantidad necesaria para realizar la venta
               return false;// retornar false si el stock de algun producto necesario para realizar la venta es menor a la cantidad necesaria para realizar la venta
           }
       }

       for (Detalles d : factura.getDetalles()) {// recorrer la lista de detalles de la factura para descontar el stock de cada producto vendido
           CollectionProducto.descontarStock(d.getProducto().getCodigo(), d.getCantidad());// descontar el stock de cada producto vendido en la cantidad vendida
       }

    CollectionFactura.agregar(factura);// agregar la factura a la lista de facturas
    System.out.println("Venta realizada correctamente.");// agregar un mensaje para indicar que la venta se realizo correctamente
    return true;// retornar true si la venta se realizo correctamente
    }
}

    @Override// indicar que se esta sobreescribiendo el metodo toString de la clase padre Empleados
    public String toString() {// crear un metodo para poder mostrar la informacion del agente administrativo
        return "Agente administrativo -> " + super.toString();// retornar la informacion del agente administrativo concatenando el string "Agente administrativo -> " con la informacion del empleado obtenida del metodo toString de la clase padre Empleados
    }
}
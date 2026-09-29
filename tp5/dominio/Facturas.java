package ar.edu.unju.escmi.tp5.dominio;  // Paquete que contiene la clase Facturas

import ar.edu.unju.escmi.tp5.collections.CollectionProducto; // Importa la clase CollectionProducto que se encuentra en el paquete ar.edu.unju.escmi.tp5.collections
import java.time.LocalDate;// Importa la clase LocalDate que se encuentra en el paquete java.time
import java.util.ArrayList;// Importa la clase ArrayList que se encuentra en el paquete java.util
import java.util.List;// Importa la clase List que se encuentra en el paquete java.util

public class Facturas {// Clase que representa una factura con sus atributos y métodos

    private static final double DESCUENTO_PAMI = 0.10;// Constante que representa el descuento aplicado a clientes con PAMI

    private int nroFactura;// Atributo que representa el número de la factura
    private LocalDate fecha;// Atributo que representa la fecha de emisión de la factura
    private double total;// Atributo que representa el total de la factura
    private Clientes cliente;// Atributo que representa el cliente al que se le emite la factura
    private boolean presentoDni;// Atributo que indica si el cliente presentó su DNI al momento de la compra
    private List<Detalles> detalles = new ArrayList<>();// Atributo que representa la lista de detalles de la factura, inicializada como un ArrayList vacío

    public Facturas() {// Constructor vacío de la clase Facturas
    }

    public Facturas(int nroFactura, LocalDate fecha, Clientes cliente) {// Constructor que inicializa los atributos de la clase Facturas
        this.nroFactura = nroFactura;// Inicializa el número de la factura con el valor proporcionado
        this.fecha = fecha;// Inicializa la fecha de emisión de la factura con el valor proporcionado
        this.cliente = cliente;// Inicializa el cliente al que se le emite la factura con el valor proporcionado
        this.presentoDni = false;// Inicializa el atributo presentoDni como false, indicando que el cliente no presentó su DNI al momento de la compra
    }

    public Facturas(int nroFactura, LocalDate fecha, Clientes cliente, boolean presentoDni) {// Constructor que inicializa los atributos de la clase Facturas, incluyendo el atributo presentoDni
        this.nroFactura = nroFactura;// Inicializa el número de la factura con el valor proporcionado
        this.fecha = fecha;// Inicializa la fecha de emisión de la factura con el valor proporcionado
        this.cliente = cliente;//   Inicializa el cliente al que se le emite la factura con el valor proporcionado
        this.presentoDni = presentoDni;// Inicializa el atributo presentoDni con el valor proporcionado, indicando si el cliente presentó su DNI al momento de la compra
    }

   
public boolean agregarDetalle(Productos p, int cantidad) {// Método que agrega un detalle a la factura, dado un producto y una cantidad
    if (p == null || cliente == null || cantidad <= 0) {// Verifica si el producto es nulo, el cliente es nulo o la cantidad es menor o igual a cero
        return false;// Si alguna de las condiciones anteriores se cumple, retorna false indicando que no se pudo agregar el detalle
    }

    Productos producto = CollectionProducto.buscar(p.getCodigo());// Busca el producto en la colección de productos utilizando su código
    if (producto == null) {// Verifica si el producto no se encuentra en la colección de productos
        return false;// Si el producto no se encuentra, retorna false indicando que no se pudo agregar el detalle
    }

        int unidadesReales = cantidad;// Inicializa la variable unidadesReales con el valor de cantidad, que representa la cantidad de unidades del producto a agregar al detalle
    double precio = producto.getPrecioUnitario();// Inicializa la variable precio con el valor del precio unitario del producto, que representa el precio de cada unidad del producto a agregar al detalle
    if (cliente instanceof ClienteMayorista) {// Verifica si el cliente es una instancia de ClienteMayorista
        unidadesReales = cantidad * 10;// Si el cliente es mayorista, multiplica la cantidad por 10 para obtener las unidades reales a agregar al detalle
        precio = precio / 2.0;// Si el cliente es mayorista, divide el precio unitario del producto entre 2 para obtener el precio de cada unidad del producto a agregar al detalle
    }

    int yaEnFactura = 0;// Inicializa la variable yaEnFactura con el valor 0, que representa la cantidad de unidades del producto que ya se encuentran en la factura
    for (Detalles d : detalles) {// Itera sobre cada detalle en la lista de detalles de la factura
        if (d.getProducto().getCodigo() == producto.getCodigo()) {// Verifica si el código del producto en el detalle es igual al código del producto que se está agregando
            yaEnFactura += d.getCantidad();// Si el código del producto es igual, suma la cantidad de unidades del producto en el detalle a la variable yaEnFactura
        }
    }
    if (!CollectionProducto.comprobarStockVenta(cliente, producto, yaEnFactura + unidadesReales)) {// Verifica si la cantidad total de unidades del producto que se desea agregar a la factura (ya en la factura más las nuevas unidades) supera el stock disponible para la venta al cliente
        return false;// Si la cantidad total de unidades supera el stock disponible, retorna false indicando que no se pudo agregar el detalle
    }

    detalles.add(new Detalles(producto, unidadesReales, precio));// Agrega un nuevo detalle a la lista de detalles de la factura, creando una instancia de Detalles con el producto, las unidades reales y el precio unitario
    calcularTotal();// Llama al método calcularTotal() para actualizar el total de la factura después de agregar el nuevo detalle
    return true;// Retorna true indicando que se pudo agregar el detalle correctamente
}
    public double calcularTotal() {
        double suma = 0;
        for (Detalles d : detalles) {
            suma += d.calcularSubtotal();
        }

        if (cliente instanceof ClienteMinorista) {
            ClienteMinorista minorista = (ClienteMinorista) cliente;
            if (presentoDni && minorista.isTienePami()) {
                suma -= suma * DESCUENTO_PAMI;
            }
        }

        total = suma;
        return total;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        if (!detalles.isEmpty()) {
            return;
        }
        this.cliente = cliente;
    }

    public boolean isPresentoDni() {
        return presentoDni;
    }

    public void setPresentoDni(boolean presentoDni) {
    this.presentoDni = presentoDni;
    calcularTotal();
}

    public List<Detalles> getDetalles() {
        return new ArrayList<>(detalles);
    }

    @Override
    public String toString() {
        String texto = "==============================================\n";
        texto += "FACTURA Nro: " + nroFactura + "   Fecha: " + fecha + "\n";
        if (cliente != null) {
            texto += "Cliente: " + cliente.getApellido() + ", " + cliente.getNombre()
                    + " - " + cliente.getDireccion() + "\n";
        }
        texto += "----------------------------------------------\n";
        for (Detalles d : detalles) {
            texto += d + "\n";
        }
        texto += "----------------------------------------------\n";
        texto += "TOTAL: $" + total + "\n";
        texto += "==============================================";
        return texto;
    }
}

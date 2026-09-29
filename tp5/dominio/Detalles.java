// Indica el paquete al que pertenece esta clase.
package ar.edu.unju.escmi.tp5.dominio;

// Declara la clase pública Detalles.
public class Detalles {

    // Guarda la cantidad de unidades vendidas.
    private int cantidad;

    // Guarda el precio por unidad aplicado en la venta.
    private double precioUnitario;

    // Guarda el importe del detalle después del descuento del producto.
    private double subtotal;

    // Guarda la referencia al producto vendido.
    private Productos producto;

    // Constructor vacío: permite crear un detalle sin pasar datos.
    public Detalles() {
        // Los atributos quedan con sus valores iniciales: 0 y null.
    } // Finaliza el constructor vacío.

    // Constructor que recibe el producto, la cantidad y el precio aplicado.
    public Detalles(Productos producto, int cantidad, double precioUnitario) {

        // Asigna el producto recibido al atributo de este objeto.
        this.producto = producto;

        // Asigna la cantidad recibida al atributo de este objeto.
        this.cantidad = cantidad;

        // Asigna el precio recibido al atributo de este objeto.
        this.precioUnitario = precioUnitario;

        // Calcula y guarda el subtotal usando los datos asignados.
        calcularSubtotal();

    } // Finaliza el constructor con parámetros.

    // Declara un método público que calcula y devuelve un número decimal.
    public double calcularSubtotal() {

        // Calcula el importe antes de aplicar el descuento.
        double importe = cantidad * precioUnitario;

        // Comprueba que exista un producto y que tenga descuento.
        // && evita consultar el descuento si producto es null.
        if (producto != null && producto.getDescuento() > 0) {

            // Resta el porcentaje de descuento al importe.
            // Por ejemplo, un descuento de 25 resta el 25 %.
            importe -= importe * producto.getDescuento() / 100.0;

        } // Finaliza la comprobación del descuento.

        // Guarda el importe calculado en el atributo subtotal.
        subtotal = importe;

        // Devuelve el subtotal a quien llamó al método.
        return subtotal;

    } // Finaliza calcularSubtotal.

    // Declara el método que permite consultar la cantidad.
    public int getCantidad() {

        // Devuelve la cantidad guardada.
        return cantidad;

    } // Finaliza getCantidad.

    // Declara el método que permite consultar el precio unitario.
    public double getPrecioUnitario() {

        // Devuelve el precio aplicado por unidad.
        return precioUnitario;

    } // Finaliza getPrecioUnitario.

    // Declara el método que permite consultar el subtotal guardado.
    public double getSubtotal() {

        // Devuelve el subtotal sin volver a calcularlo.
        return subtotal;

    } // Finaliza getSubtotal.

    // Declara el método que permite consultar el producto del detalle.
    public Productos getProducto() {

        // Devuelve la referencia al producto.
        return producto;

    } // Finaliza getProducto.

    // Indica que se redefine un método heredado de Object.
    @Override

    // Devuelve una representación del detalle como texto.
    public String toString() {

        // Usa "-" como descripción inicial si no hay producto.
        String desc = "-";

        // Usa 0 como descuento inicial si no hay producto.
        int dto = 0;

        // Comprueba que el detalle tenga un producto asociado.
        if (producto != null) {

            // Obtiene la descripción del producto.
            desc = producto.getDescripcion();

            // Obtiene el porcentaje de descuento del producto.
            dto = producto.getDescuento();

        } // Finaliza la comprobación del producto.

        // Comienza el texto con la cantidad y la descripción.
        return "  " + cantidad + " x " + desc

                // Añade el precio por unidad al mismo texto.
                + " | precio unit.: $" + precioUnitario

                // Añade el porcentaje de descuento del producto.
                + " | dto. producto: " + dto + "%"

                // Añade el subtotal y termina la sentencia return.
                + " | importe: $" + subtotal;

    } // Finaliza toString.

} // Finaliza la clase Detalles.

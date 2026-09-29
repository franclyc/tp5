package ar.edu.unju.escmi.tp5.dominio;

public class Detalles {

    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private Productos producto;

    public Detalles() {
    }

    public Detalles(Productos producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    public double calcularSubtotal() {
        double importe = cantidad * precioUnitario;

        if (producto != null && producto.getDescuento() > 0) {
            importe -= importe * producto.getDescuento() / 100.0;
        }

        subtotal = importe;
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Productos getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        String desc = "-";
        int dto = 0;

        if (producto != null) {
            desc = producto.getDescripcion();
            dto = producto.getDescuento();
        }

        return "  " + cantidad + " x " + desc
                + " | precio unit.: $" + precioUnitario
                + " | dto. producto: " + dto + "%"
                + " | importe: $" + subtotal;
    }
}

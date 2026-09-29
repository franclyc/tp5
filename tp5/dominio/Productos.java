package ar.edu.unju.escmi.tp5.dominio;

public class Productos {// Clase que representa un producto con sus atributos y métodos

    private int codigo;// Atributo que representa el código del producto
    private String descripcion;// Atributo que representa la descripción del producto
    private double precioUnitario;// Atributo que representa el precio unitario del producto
    private int descuento;// Atributo que representa el descuento aplicado al producto
    private int stock;// Atributo que representa la cantidad de stock disponible del producto

    public Productos() {// Constructor vacío de la clase Productos
    }

    public Productos(int codigo, String descripcion, double precioUnitario, // Constructor que inicializa los atributos de la clase Productos
                     int descuento, int stock) { // Constructor que inicializa los atributos de la clase Productos
        this.codigo = codigo;   // Inicializa el código del producto con el valor proporcionado
        this.descripcion = descripcion;//   Inicializa la descripción del producto con el valor proporcionado
        this.precioUnitario = precioUnitario;// Inicializa el precio unitario del producto con el valor proporcionado
        this.descuento = descuento;// Inicializa el descuento del producto con el valor proporcionado
        this.stock = stock;// Inicializa el stock del producto con el valor proporcionado
    }

    public int getCodigo() {// Método que devuelve el código del producto
        return codigo;// Devuelve el valor del atributo código del producto
    }

    public void setCodigo(int codigo) {// Método que establece el código del producto
        this.codigo = codigo;// Asigna el valor proporcionado al atributo código del producto
    }

    public String getDescripcion() {// Método que devuelve la descripción del producto
        return descripcion;// Devuelve el valor del atributo descripción del producto
    }

    public void setDescripcion(String descripcion) {// Método que establece la descripción del producto
        this.descripcion = descripcion;// Asigna el valor proporcionado al atributo descripción del producto
    }

    public double getPrecioUnitario() {// Método que devuelve el precio unitario del producto
        return precioUnitario;// Devuelve el valor del atributo precio unitario del producto
    }

    public void setPrecioUnitario(double precioUnitario) {// Método que establece el precio unitario del producto
        this.precioUnitario = precioUnitario;// Asigna el valor proporcionado al atributo precio unitario del producto
    }

    public int getDescuento() {// Método que devuelve el descuento aplicado al producto
        return descuento;// Devuelve el valor del atributo descuento del producto
    }

    public void setDescuento(int descuento) {// Método que establece el descuento aplicado al producto
        this.descuento = descuento;// Asigna el valor proporcionado al atributo descuento del producto
    }

    public int getStock() {// Método que devuelve la cantidad de stock disponible del producto
        return stock;// Devuelve el valor del atributo stock del producto
    }

    public void setStock(int stock) {// Método que establece la cantidad de stock disponible del producto
        this.stock = stock;// Asigna el valor proporcionado al atributo stock del producto
    }

    @Override// Método que devuelve una representación en forma de cadena del objeto Productos
    public String toString() {// Método que devuelve una representación en forma de cadena del objeto Productos
        return "Productos{" +// Devuelve una cadena que representa el objeto Productos con sus atributos y valores
                "codigo=" + codigo +//      Devuelve el valor del atributo código del producto
                ", descripcion='" + descripcion + '\'' +//      Devuelve el valor del atributo descripción del producto
                ", precioUnitario=" + precioUnitario +//      Devuelve el valor del atributo precio unitario del producto
                ", descuento=" + descuento +//      Devuelve el valor del atributo descuento del producto
                ", stock=" + stock +//      Devuelve el valor del atributo stock del producto
                '}';
    }
}
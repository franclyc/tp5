// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp5.dominio;

// Importa la clase que administra las facturas registradas.
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

// Importa la clase que administra y busca los productos.
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

// Declara EncargadoVentas como subclase de Empleados.
// Hereda sus atributos y métodos accesibles.
public class EncargadoVentas extends Empleados {

    // Constructor vacío del encargado de ventas.
    public EncargadoVentas() {

        // Llama al constructor vacío de la clase padre, Empleados.
        super();

    } // Finaliza el constructor vacío.

    // Constructor que recibe el código, el nombre y la contraseña.
    public EncargadoVentas(int codigo, String nombre, String contrasenia) {

        // Llama al constructor de Empleados para asignar los datos recibidos.
        super(codigo, nombre, contrasenia);

    } // Finaliza el constructor con parámetros.

    // Declara un método público para mostrar las ventas.
    // void indica que no devuelve un valor.
    public void mostrarVentas() {

        // Llama al método estático que imprime las facturas registradas.
        CollectionFactura.mostrar();

    } // Finaliza mostrarVentas.

    // Declara un método público para mostrar el importe total de las ventas.
    public void mostrarTotalVentas() {

        // Obtiene la suma de las ventas y la imprime junto al mensaje.
        System.out.println("Total de todas las ventas: $" + CollectionFactura.totalVentas());

    } // Finaliza mostrarTotalVentas.

    // Recibe el código de un producto para consultar sus unidades disponibles.
    public void verificarStock(int codigoProducto) {

        // Busca el producto por su código y guarda el resultado.
        // Si no existe, buscar devuelve null.
        Productos producto = CollectionProducto.buscar(codigoProducto);

        // Comprueba que se haya encontrado el producto.
        if (producto != null) {

            // Imprime la descripción del producto encontrado.
            System.out.println("Producto: " + producto.getDescripcion());

            // Imprime la cantidad de unidades disponibles del producto.
            System.out.println("Stock disponible: " + producto.getStock());

        // Ejecuta este bloque si el producto no existe.
        } else {

            // Informa que no se encontró un producto con el código recibido.
            System.out.println("No existe un producto con el codigo " + codigoProducto);

        } // Finaliza el if/else.

    } // Finaliza verificarStock.

    // Indica que se redefine el método toString heredado de Empleados.
    @Override

    // Devuelve una representación del encargado como texto.
    public String toString() {

        // Añade el cargo al texto que devuelve Empleados.toString().
        // super.toString() devuelve el código y el nombre del empleado.
        return "Encargado de ventas -> " + super.toString();

    } // Finaliza toString.

} // Finaliza la clase EncargadoVentas.

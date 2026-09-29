// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp5.dominio;

// Importa la clase que permite buscar las facturas registradas.
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

// Declara una clase abstracta: no se puede crear directamente con new Clientes().
public abstract class Clientes {

    // Guarda la dirección; protected permite acceder desde el paquete y las subclases.
    protected String direccion;

    // Guarda el nombre del cliente.
    protected String nombre;

    // Guarda el apellido del cliente.
    protected String apellido;

    // Guarda la contraseña del cliente.
    protected String contrasenia;

    // Constructor vacío, que pueden llamar los constructores de las subclases.
    public Clientes() {
    } // Finaliza el constructor vacío.

    // Constructor que recibe los datos comunes a todos los clientes.
    public Clientes(String direccion, String nombre, String apellido, String contrasenia) {

        // Asigna la dirección recibida al atributo de este objeto.
        this.direccion = direccion;

        // Asigna el nombre recibido al atributo de este objeto.
        this.nombre = nombre;

        // Asigna el apellido recibido al atributo de este objeto.
        this.apellido = apellido;

        // Asigna la contraseña recibida al atributo de este objeto.
        this.contrasenia = contrasenia;

    } // Finaliza el constructor con parámetros.

    // Busca una factura por su número y devuelve un objeto Facturas o null.
    public Facturas buscarFactura(int nroFactura) {

        // Busca la factura en la colección y guarda el resultado.
        Facturas factura = CollectionFactura.buscar(nroFactura);

        // Comprueba que exista y que su cliente sea este mismo objeto.
        // && evita consultar el cliente si la factura es null.
        if (factura != null && factura.getCliente() == this) {

            // Devuelve la factura porque pertenece a este cliente.
            return factura;

        } // Finaliza la comprobación.

        // Devuelve null si no existe o pertenece a otro cliente.
        return null;

    } // Finaliza buscarFactura.

    // Obliga a las subclases a implementar cómo obtener su código.
    // Mayorista devuelve codCliente y minorista devuelve dni.
    public abstract int obtenerCodCliente();

    // Permite consultar la dirección.
    public String getDireccion() {

        // Devuelve la dirección guardada.
        return direccion;

    } // Finaliza getDireccion.

    // Permite modificar la dirección.
    public void setDireccion(String direccion) {

        // Reemplaza la dirección del objeto por la recibida.
        this.direccion = direccion;

    } // Finaliza setDireccion.

    // Permite consultar el nombre.
    public String getNombre() {

        // Devuelve el nombre guardado.
        return nombre;

    } // Finaliza getNombre.

    // Permite modificar el nombre.
    public void setNombre(String nombre) {

        // Reemplaza el nombre del objeto por el recibido.
        this.nombre = nombre;

    } // Finaliza setNombre.

    // Permite consultar el apellido.
    public String getApellido() {

        // Devuelve el apellido guardado.
        return apellido;

    } // Finaliza getApellido.

    // Permite modificar el apellido.
    public void setApellido(String apellido) {

        // Reemplaza el apellido del objeto por el recibido.
        this.apellido = apellido;

    } // Finaliza setApellido.

    // Permite consultar la contraseña, por ejemplo para autenticar al cliente.
    public String getContrasenia() {

        // Devuelve la contraseña guardada.
        return contrasenia;

    } // Finaliza getContrasenia.

    // Permite modificar la contraseña.
    public void setContrasenia(String contrasenia) {

        // Reemplaza la contraseña del objeto por la recibida.
        this.contrasenia = contrasenia;

    } // Finaliza setContrasenia.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve los datos del cliente como texto, sin mostrar la contraseña.
    public String toString() {

        // Comienza el texto con el nombre de la clase.
        return "Clientes{" +

                // Añade la dirección; '\'' representa una comilla simple.
                "direccion='" + direccion + '\'' +

                // Añade el nombre al texto.
                ", nombre='" + nombre + '\'' +

                // Añade el apellido al texto.
                ", apellido='" + apellido + '\'' +

                // Añade la llave de cierre y termina la sentencia return.
                '}';

    } // Finaliza toString.

} // Finaliza la clase Clientes.

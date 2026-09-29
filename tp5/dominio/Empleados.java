// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp5.dominio;

// Declara una clase abstracta: no se puede crear directamente con new Empleados().
// Es la clase base de AgenteAdministrativo y EncargadoVentas.
public abstract class Empleados {

    // Guarda el código del empleado.
    // protected permite acceder desde el mismo paquete y desde las subclases.
    protected int codigo;

    // Guarda el nombre del empleado.
    protected String nombre;

    // Guarda la contraseña utilizada para iniciar sesión.
    protected String contrasenia;

    // Constructor vacío: deja codigo en 0 y los String en null.
    public Empleados() { }

    // Constructor que recibe el código, el nombre y la contraseña.
    public Empleados(int codigo, String nombre, String contrasenia) {

        // Asigna el código recibido al atributo de este objeto.
        this.codigo = codigo;

        // Asigna el nombre recibido al atributo de este objeto.
        this.nombre = nombre;

        // Asigna la contraseña recibida al atributo de este objeto.
        this.contrasenia = contrasenia;

    } // Finaliza el constructor con parámetros.

    // Declara un método público para consultar el código.
    public int getCodigo() {

        // Devuelve el código guardado.
        return codigo;

    } // Finaliza getCodigo.

    // Permite modificar el código; void indica que no devuelve un valor.
    public void setCodigo(int codigo) {

        // Reemplaza el código del objeto por el recibido.
        this.codigo = codigo;

    } // Finaliza setCodigo.

    // Declara un método público para consultar el nombre.
    public String getNombre() {

        // Devuelve el nombre guardado.
        return nombre;

    } // Finaliza getNombre.

    // Permite modificar el nombre y no devuelve un valor.
    public void setNombre(String nombre) {

        // Reemplaza el nombre del objeto por el recibido.
        this.nombre = nombre;

    } // Finaliza setNombre.

    // Permite consultar la contraseña, por ejemplo para autenticar al empleado.
    public String getContrasenia() {

        // Devuelve la contraseña guardada.
        return contrasenia;

    } // Finaliza getContrasenia.

    // Permite modificar la contraseña y no devuelve un valor.
    public void setContrasenia(String contrasenia) {

        // Reemplaza la contraseña del objeto por la recibida.
        this.contrasenia = contrasenia;

    } // Finaliza setContrasenia.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve una representación del empleado como texto.
    public String toString() {

        // Une el código y el nombre en un texto, sin mostrar la contraseña.
        return "Codigo: " + codigo + " | Nombre: " + nombre;

    } // Finaliza toString.

} // Finaliza la clase Empleados.

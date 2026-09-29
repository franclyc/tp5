package ar.edu.unju.escmi.tp5.principal;    // Clase principal del sistema de ventas

import ar.edu.unju.escmi.tp5.collections.CollectionCliente; // Clase que maneja la colección de clientes
import ar.edu.unju.escmi.tp5.collections.CollectionEmpleados;// Clase que maneja la colección de empleados
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;//  Clase que maneja la colección de facturas
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;// Clase que maneja la colección de productos
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;// Clase que representa a un agente administrativo
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;// Clase que representa a un cliente mayorista
import ar.edu.unju.escmi.tp5.dominio.Clientes;
import ar.edu.unju.escmi.tp5.dominio.Empleados;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;
import ar.edu.unju.escmi.tp5.dominio.Facturas;
import ar.edu.unju.escmi.tp5.dominio.Productos;
import java.time.LocalDate;// Clase para manejar fechas
import java.util.Scanner; // Clase para leer la entrada del usuario
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista; // Clase que representa a un cliente minorista

public class Principal { // Clase principal del sistema de ventas

    private static Scanner sc = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario

    public static void main(String[] args) {// Método principal que inicia el sistema de ventas

        CollectionCliente.precargarCliente();// Precarga de clientes en la colección
        CollectionEmpleados.precargarEmpleado();// Precarga de empleados en la colección
        precargarProductos();// Precarga de productos en la colección

        int opcion;// Variable para almacenar la opción seleccionada por el usuario

        do { // Bucle principal del sistema de ventas
            System.out.println("\n===== SISTEMA DE VENTAS ====="); 
            System.out.println("1 - Ingresar como cliente");
            System.out.println("2 - Ingresar como empleado");
            System.out.println("0 - Salir");
            opcion = leerEntero("Ingrese una opcion: ");

            switch (opcion) { //Manejo de las opciones seleccionadas por el usuario
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuEmpleado();
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 0);

        sc.close();
    }

    // ---------------------- CLIENTE ----------------------

    private static void menuCliente() { // Menu para el cliente, donde puede buscar facturas

        int cod = leerEntero("Codigo de cliente (o DNI): ");// Lee el código del cliente o DNI
        System.out.print("Contrasenia: "); // Lee la contraseña del cliente 
        String contrasenia = sc.nextLine(); //transforma la entrada del usuario en una cadena de texto

        if (!CollectionCliente.autenticacion(cod, contrasenia)) { // Verifica si el código y la contraseña son correctos
            System.out.println("Codigo o contrasenia incorrectos"); //a
            return; //retornamos al menu principal si la autenticacion falla
        }

        Clientes cliente = CollectionCliente.buscarCliente(cod);// Busca el cliente en la colección de clientes
        int opcion; // Variable para almacenar la opción seleccionada por el cliente

        do {
            System.out.println("\n----- MENU CLIENTE -----");
            System.out.println("1 - Buscar factura");
            System.out.println("0 - Volver");
            opcion = leerEntero("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    int nroFactura = leerEntero("Numero de factura: "); // Lee el número de factura que desea buscar
                    Facturas factura = cliente.buscarFactura(nroFactura);// Busca la factura en la colección de facturas del cliente
                    if (factura != null) {// Si la factura existe, la muestra por pantalla
                        System.out.println(factura);
                    } else {// Si la factura no existe, muestra un mensaje de error
                        System.out.println("No existe la factura " + nroFactura);
                    }
                    break;
                case 0:
                    break;
                default:// Si la opción ingresada no es válida, muestra un mensaje de error
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 0);
    }

    // ---------------------- EMPLEADOS ----------------------

    private static void menuEmpleado() {// Menu para el empleado, donde puede realizar diferentes acciones según su tipo

        System.out.print("Nombre: ");// Lee el nombre del empleado
        String nombre = sc.nextLine();// Lee la entrada del usuario y la almacena en la variable nombre
        System.out.print("Contrasenia: ");// Lee la contraseña del empleado
        String contrasenia = sc.nextLine(); // Lee la entrada del usuario y la almacena en la variable contrasenia

        if (!CollectionEmpleados.autenticacion(nombre, contrasenia)) { // Verifica si el nombre y la contraseña son correctos
            System.out.println("Nombre o contrasenia incorrectos"); 
            return;// Retorna al menú principal si la autenticación falla
        }

        String tipo = CollectionEmpleados.obtenerTipoEmpleado(nombre, contrasenia);// Obtiene el tipo de empleado (Encargado de Ventas o Agente Administrativo) según el nombre y la contraseña ingresados
        Empleados empleado = CollectionEmpleados.buscarEmpleado(nombre, contrasenia);// Busca el empleado en la colección de empleados según el nombre y la contraseña ingresados
        System.out.println("Bienvenido/a " + tipo);// Muestra un mensaje de bienvenida al empleado según su tipo

        if (empleado instanceof EncargadoVentas) {// Si el empleado es un Encargado de Ventas, llama al menú correspondiente
            menuEncargadoVentas((EncargadoVentas) empleado);
        } else if (empleado instanceof AgenteAdministrativo) {// Si el empleado es un Agente Administrativo, llama al menú correspondiente
            menuAgenteAdministrativo((AgenteAdministrativo) empleado); 
        }
    }

    private static void menuEncargadoVentas(EncargadoVentas encargado) {// Menu para el Encargado de Ventas, donde puede realizar diferentes acciones según su tipo

        int opcion;

        do {
            System.out.println("\n----- MENU ENCARGADO DE VENTAS -----");
            System.out.println("1 - Mostrar las ventas");
            System.out.println("2 - Mostrar el total de todas las ventas");
            System.out.println("3 - Verificar stock de un producto");
            System.out.println("0 - Volver");
            opcion = leerEntero("Ingrese una opcion: ");

            switch (opcion) { // Manejo de las opciones seleccionadas por el Encargado de Ventas
                case 1:
                    encargado.mostrarVentas();
                    break;
                case 2:
                    encargado.mostrarTotalVentas();
                    break;
                case 3:
                    int codigo = leerEntero("Codigo de producto: ");
                    encargado.verificarStock(codigo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 0);
    }

    private static void menuAgenteAdministrativo(AgenteAdministrativo agente) {// Menu para el Agente Administrativo, donde puede realizar diferentes acciones según su tipo

        int opcion;//   Variable para almacenar la opción seleccionada por el Agente Administrativo

        do {
            System.out.println("\n----- MENU AGENTE ADMINISTRATIVO -----");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Realizar venta");
            System.out.println("0 - Volver");
            opcion = leerEntero("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    altaProducto(agente);
                    break;
                case 2:
                    realizarVenta(agente);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 0);
    }

    private static void altaProducto(AgenteAdministrativo agente) {// Menu para el Agente Administrativo, donde puede dar de alta un producto en la colección de productos

        int codigo = leerEntero("Codigo de producto: ");// Lee el código del producto que desea dar de alta
        System.out.print("Descripcion: ");// Lee la descripción del producto que desea dar de alta
        String descripcion = sc.nextLine();// Lee la entrada del usuario y la almacena en la variable descripcion
        double precioUnitario = leerDouble("Precio unitario: ");// Lee el precio unitario del producto que desea dar de alta

        int descuento = leerEntero("Descuento (0, 25 o 30): ");// Lee el descuento del producto que desea dar de alta
        while (descuento != 0 && descuento != 25 && descuento != 30) {// Valida que el descuento ingresado sea 0, 25 o 30
            System.out.println("El descuento solo puede ser 0, 25 o 30");// Muestra un mensaje de error si el descuento no es válido
            descuento = leerEntero("Descuento (0, 25 o 30): ");// Lee nuevamente el descuento del producto que desea dar de alta
        }

        int stock = leerEntero("Stock inicial: ");// Lee el stock inicial del producto que desea dar de alta

        agente.agregarProducto(new Productos(codigo, descripcion, precioUnitario, descuento, stock));// Llama al método agregarProducto del Agente Administrativo para dar de alta el producto en la colección de productos
    }

    private static void realizarVenta(AgenteAdministrativo agente) {// Menu para el Agente Administrativo, donde puede realizar una venta a un cliente

        int codCliente = leerEntero("Codigo del cliente (o DNI): ");// Lee el código del cliente o DNI que desea realizar la venta
        Clientes cliente = CollectionCliente.buscarCliente(codCliente);// Busca el cliente en la colección de clientes según el código o DNI ingresado

        if (cliente == null) {// Si el cliente no existe, muestra un mensaje de error y retorna al menú del Agente Administrativo
            System.out.println("No existe un cliente con ese codigo");// Muestra un mensaje de error si el cliente no existe    
            return;
        }

        Facturas factura = new Facturas();// Crea un objeto Facturas para almacenar la información de la venta que se va a realizar
        factura.setCliente(cliente);// Asigna el cliente a la factura

        if (cliente instanceof ClienteMinorista) {// Si el cliente es un Cliente Minorista, pregunta si presentó DNI y asigna el valor a la factura
    ClienteMinorista minorista = (ClienteMinorista) cliente;// Castea el cliente a ClienteMinorista para poder acceder al método isTienePami()

    if (minorista.isTienePami()) {// Si el cliente tiene PAMI, pregunta si presentó DNI y asigna el valor a la factura
        System.out.print("¿Presentó DNI? (s/n): ");// Muestra un mensaje para preguntar si el cliente presentó DNI
        factura.setPresentoDni(sc.nextLine().trim().equalsIgnoreCase("s"));// Asigna el valor a la factura según la respuesta del cliente
    }
}
        factura.setFecha(LocalDate.now());// Asigna la fecha actual a la factura

        boolean hayDetalle = false;// Variable para controlar si se agregaron productos a la venta
        String seguir;// Variable para controlar si se desea agregar otro producto a la venta

        do {
            int codProducto = leerEntero("Codigo de producto: ");// Lee el código del producto que desea agregar a la venta
            Productos producto = CollectionProducto.buscar(codProducto);// Busca el producto en la colección de productos según el código ingresado

            if (producto == null) {// Si el producto no existe, muestra un mensaje de error y pregunta si se desea agregar otro producto a la venta
                System.out.println("No existe un producto con el codigo " + codProducto);// Muestra un mensaje de error si el producto no existe
            } else {// Si el producto existe, pregunta la cantidad que desea agregar a la venta y llama al método agregarDetalle de la factura para agregar el producto a la venta
                                 System.out.println(cliente instanceof ClienteMayorista
                           ? "Ingrese cantidad de bultos (10 unidades cada uno)"
                           : "Ingrese cantidad de unidades");
                int cantidad = leerEntero("Cantidad: ");// Lee la cantidad de unidades o bultos que desea agregar a la venta
                if (factura.agregarDetalle(producto, cantidad)) {// Si se pudo agregar el producto a la venta, muestra un mensaje de éxito y asigna true a la variable hayDetalle
                    hayDetalle = true;// Asigna true a la variable hayDetalle para indicar que se agregaron productos a la venta
                    System.out.println("Producto agregado a la venta");// Muestra un mensaje de éxito si se pudo agregar el producto a la venta
                } else {
                System.out.println("No se pudo agregar el producto. Verifique la cantidad y el stock.");}// Muestra un mensaje de error si no se pudo agregar el producto a la venta
            }

            System.out.print("Desea agregar otro producto? (s/n): ");// Pregunta si se desea agregar otro producto a la venta
            seguir = sc.nextLine();// Lee la entrada del usuario y la almacena en la variable seguir
        } while (seguir.equalsIgnoreCase("s"));// Si la respuesta es "s", se repite el bucle para agregar otro producto a la venta

        if (hayDetalle) {// Si se agregaron productos a la venta, asigna el número de factura y llama al método realizarVenta del Agente Administrativo para procesar la venta
            factura.setNroFactura(CollectionFactura.siguienteNumero());// Asigna el número de factura siguiente a la factura
                           if (agente.realizarVenta(factura)) {// Si se pudo procesar la venta, muestra un mensaje de éxito y la información de la factura
                   System.out.println(factura);// Muestra la información de la factura si se pudo procesar la venta
               }
        } else {
            System.out.println("Venta cancelada, no se cargo ningun producto");// Muestra un mensaje de cancelación si no se agregaron productos a la venta
        }
    }

    // ---------------------- PRECARGA Y LECTURA ----------------------

    private static void precargarProductos() {// Método para precargar productos en la colección de productos
        CollectionProducto.agregar(new Productos(1002, "Fideo Knorr Spaghetti x 500 gr", 1200.00, 0, 5000));// Agrega un producto a la colección de productos
        CollectionProducto.agregar(new Productos(1003, "Arroz Gallo Oro x 1 kg", 1500.00, 25, 3000));// Agrega un producto a la colección de productos
        CollectionProducto.agregar(new Productos(1004, "Aceite Cocinero x 900 ml", 2500.00, 30, 2000));//   Agrega un producto a la colección de productos
        CollectionProducto.agregar(new Productos(1005, "Galletitas Oreo x 118 gr", 900.00, 0, 4000));// Agrega un producto a la colección de productos
    }

    private static int leerEntero(String mensaje) {//   Método para leer un número entero desde la entrada del usuario, mostrando un mensaje de solicitud
        while (true) {// Bucle infinito hasta que se ingrese un número entero válido
            System.out.print(mensaje);// Muestra el mensaje de solicitud al usuario
            try {// Intenta leer un número entero desde la entrada del usuario
                return Integer.parseInt(sc.nextLine().trim());// Lee la entrada del usuario, la convierte a un número entero y la retorna
            } catch (NumberFormatException e) {// Si ocurre una excepción al intentar convertir la entrada a un número entero, muestra un mensaje de error y repite el bucle
                System.out.println("Debe ingresar un numero entero");// Muestra un mensaje de error si la entrada no es un número entero válido
            }
        }
    }

    private static double leerDouble(String mensaje) {//    Método para leer un número decimal desde la entrada del usuario, mostrando un mensaje de solicitud
        while (true) {// Bucle infinito hasta que se ingrese un número decimal válido
            System.out.print(mensaje);// Muestra el mensaje de solicitud al usuario
            try {// Intenta leer un número decimal desde la entrada del usuario
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));//    Lee la entrada del usuario, reemplaza las comas por puntos, la convierte a un número decimal y la retorna
            } catch (NumberFormatException e) {// Si ocurre una excepción al intentar convertir la entrada a un número decimal, muestra un mensaje de error y repite el bucle
                System.out.println("Debe ingresar un numero valido");// Muestra un mensaje de error si la entrada no es un número decimal válido
            }
        }
    }
}// Fin de la clase Principal
package Maps;

/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Maps.Producto
 * Proposito: Almacenar datos de un producto
 *
 * @author Adrian Fulladolsa Palma
 *
 */

public class Producto {
    String nombre;
    String categoria;
    int cantidad;

    public Producto(String n, String c, int i){
        this.nombre = n;
        this.categoria = c;
        this.cantidad = i;
    }

    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getCantidad(){
        return String.valueOf(cantidad);
    }
}

/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Mapa
 * Proposito: Clase abstracta que sera utilizada por implementaciones de Map
 *
 * @author Adrian Fulladolsa Palma
 *
 */
import java.util.ArrayList;
import java.util.Map;

public abstract class Mapa{
    abstract Map<String, String> creacionInventario(ArrayList<String> inv);

    abstract Map<String, Producto> crearCarrito(Map<String,String> inv);

    abstract void MostrarCategoriaProducto(String nom, Map<String, String> inv);
}

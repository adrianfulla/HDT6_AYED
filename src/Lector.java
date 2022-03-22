/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Lector
 * Proposito: Clase que permite la lectura de archivo txt
 *
 * @author Adrian Fulladolsa Palma
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Lector {


    public ArrayList<String> lector(String path) {
        ArrayList<String> inventario = new ArrayList<String>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String bflinea;
            while ((bflinea = bf.readLine()) != null) {
                inventario.add(bflinea);
            }

        } catch (Exception e) {
            System.out.println("[ERROR]. El archivo no fue encontrado");
        }
        return inventario;
    }
}
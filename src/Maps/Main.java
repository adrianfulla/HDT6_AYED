package Maps; /**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Maps.Main
 * Proposito: Ejecutar todos los procesos del programa
 *
 * @author Adrian Fulladolsa Palma
 *
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Lector l = new Lector();
        Mapa m = null;
        Map<String, String> inv = null;

        ArrayList<String> inventario = l.lector("ListadoProductos.txt");

        System.out.println("Bienvenido a Tienda Online");
        int seleccion;
        while (true) {
            try {
                System.out.println("""
                        \n
                        Seleccione un tipo de stack a implementar:
                        [1]. HashMap.
                        [2]. TreeMap.
                        [3]. LinkedHashMap.""");
                seleccion = s.nextInt();
                if (seleccion <= 0 || seleccion > 3) {
                    System.out.println("Valor no encontrado dentro de opciones");
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Valor ingresado no valido");
                s.next();
                continue;
            }
        }
        switch (seleccion) {
            case 1:
                m = new HashMapa();
                inv = m.creacionInventario(inventario);
                break;
            case 2:
                m = new TreeMapa();
                inv = m.creacionInventario(inventario);
                break;
            case 3:
                m = new LinkedHashMapa();
                inv = m.creacionInventario(inventario);
                break;
        }

        int seleccionmenu = 0;
        Map<String, Producto> cart = null;
        while (seleccionmenu != 7) {
            while (true) {
                try {
                    System.out.println("""
                            \n
                            Seleccione un tipo de stack a implementar:
                            [1]. Agregar producto a coleccion.
                            [2]. Mostrar categoria de un producto.
                            [3]. Mostrar datos de productos en coleccion.
                            [4]. Mostrar datos de productos en coleccion por tipo.
                            [5]. Mostrar todos los productos.
                            [6]. Mostrar todos los productos en orden.
                            [7]. Salir.""");
                    seleccionmenu = s.nextInt();
                    if (seleccionmenu <= 0 || seleccionmenu > 7) {
                        System.out.println("Valor no encontrado dentro de opciones");
                        continue;
                    } else {
                        break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Valor ingresado no valido");
                    s.next();
                    continue;
                }
            }
            switch (seleccionmenu) {
                case 1:
                    System.out.println("Agregar productos a coleccion");
                    cart = m.crearCarrito(inv);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto");
                    String producto = s.next();
                    m.MostrarCategoriaProducto(producto, inv);
                    System.out.println("");
                    break;
                case 3:
                    m.MostrarDatos(cart);
                    break;
                case 4:
                    m.MostrarDatosTipo(cart);
                    break;
                case 5:
                    m.MostrarDatosTodo(inv);
                    break;
                case 6:
                    m.MostrarDatosTodoTipo(inv);
                    break;
                case 7:
                    System.out.println("Feliz dia");
                    break;
            }
        }
    }
}
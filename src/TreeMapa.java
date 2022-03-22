/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: TreeMapa
 * Proposito: Clase que extiende Mapa y utiliza TreeMap
 *
 * @author Adrian Fulladolsa Palma
 *
 */
import java.util.*;

public class TreeMapa extends Mapa{

    @Override
    TreeMap<String, String> creacionInventario(ArrayList<String> inv) {
        TreeMap<String, String> inven = new TreeMap<>();
        for (int i = 0; i < inv.size(); i++) {
            String linea = inv.get(i);
            String[] texto = linea.split(" \\|\\t");
            String key = texto[1];
            String values = texto[0];


            inven.put(key,values);

        }

        return inven;
    }

    @Override
    TreeMap<String, Producto> crearCarrito(Map<String, String> inv) {
        TreeMap<String, Producto> cart = new TreeMap<>();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Ingrese la categoria del producto");
            String cattemp = s.next();
            System.out.println("Ingrese el nombre del producto");
            String protemp = s.next();
            int cant;
            while (true) {
                try {
                    System.out.println("Cuantos desea agregar a coleccion?");
                    cant = s.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Valor ingresado no valido");
                    s.next();
                    continue;
                }
            }
            if(cattemp.equals(inv.get(protemp))) {
                cart.put(cattemp + protemp, new Producto(protemp, cattemp, cant));
            }
            else{
                System.out.println("Producto no encontrado");
                continue;
            }
            int salir;
            while (true) {
                try {
                    System.out.println("""
                                Desea seguir agregando productos?:
                                [1]. Si.
                                [2]. No.""");
                    salir = s.nextInt();
                    if (salir <= 0 || salir > 2) {
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
            if (salir == 1) {
                continue;
            } else {
                break;
            }
        }
        return cart;

    }

    @Override
    void MostrarCategoriaProducto(String nom, Map<String, String> inv) {
        if(inv.containsKey(nom)){
            System.out.println("Producto "+ nom + " pertenece a categoria " + inv.get(nom));
        }
        else{
            System.out.println("Producto no existente");
        }
    }


}

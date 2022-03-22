/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Main
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
                            [3]. Mostrar datos de un producto.
                            [4]. Mostrar datos de producto por tipo.
                            [5]. Mostrar todos los productos.
                            [6]. Mostrar todos los productos existentes.
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
                    System.out.println("Productos en coleccion");
                    if(cart != null) {
                        if(!cart.isEmpty()) {
                            for (Producto value : cart.values()) {
                                System.out.println("Producto: " + value.getNombre() + "| Categoria: " + value.getCategoria() + "| Cantidad: " + value.getCantidad());
                            }
                        }
                        else{
                            System.out.println("Coleccion vacia");
                        }
                    }
                    else{
                        System.out.println("Coleccion no ha sido creada");
                    }
                    break;
                case 4:
                    System.out.println("Productos en coleccion en orden");
                    if(cart != null) {
                        if(!cart.isEmpty()) {
                            String mt = "\nMuebles de Terraza";
                            String sm = "\nSillones de Masaje";
                            String be = "\nBebidas";
                            String co = "\nCondimentos";
                            String fr = "\nFrutas";
                            String cr = "\nCarnes";
                            String la = "\nLacteos";
                            for (Producto value : cart.values()) {
                                switch (value.getCategoria()){
                                    case "Mueble de terraza":
                                        mt = mt + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Sillones de masaje":
                                        sm = sm + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Bebidas":
                                        be = be + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Condimentos":
                                        co = co + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Frutas":
                                        fr = fr + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Carnes":
                                        cr = cr + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                    case "Lácteos":
                                        la = la + "\n Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                                        break;
                                }
                            }
                        }
                        else{
                            System.out.println("Coleccion vacia");
                        }
                    }
                    else{
                        System.out.println("Coleccion no ha sido creada");
                    }
                    break;
                case 5:
                    System.out.println("Productos en coleccion");
                    if(inv != null) {
                        if(!inv.isEmpty()) {
                            for(Map.Entry<String,String> entry : inv.entrySet()){
                                String k = entry.getKey();
                                String v = entry.getValue();
                                System.out.println("Producto: " + k + " |Categoria: " + v);
                            }
                        }
                        else{
                            System.out.println("Coleccion vacia");
                        }
                    }
                    else{
                        System.out.println("Coleccion no ha sido creada");
                    }
                    break;
                case 6:
                    System.out.println("Productos en coleccion por categoria");
                    if(inv != null) {
                        if(!inv.isEmpty()) {
                            String mt = "\nMuebles de Terraza";
                            String sm = "\nSillones de Masaje";
                            String be = "\nBebidas";
                            String co = "\nCondimentos";
                            String fr = "\nFrutas";
                            String cr = "\nCarnes";
                            String la = "\nLacteos";
                           for(Map.Entry<String,String> entry : inv.entrySet()){
                               String k = entry.getKey();
                               String v = entry.getValue();
                               switch (v){
                                   case "Mueble de terraza":
                                       mt = mt + "\n" + k;
                                       break;
                                   case "Sillones de masaje":
                                       sm = sm + "\n" + k;
                                       break;
                                   case "Bebidas":
                                       be = be + "\n" + k;
                                       break;
                                   case "Condimentos":
                                       co = co + "\n" + k;
                                       break;
                                   case "Frutas":
                                       fr = fr + "\n" + k;
                                       break;
                                   case "Carnes":
                                       cr = cr + "\n" + k;
                                       break;
                                   case "Lácteos":
                                       la = la + "\n" + k;
                                       break;
                               }
                           }
                            System.out.println(mt + "\n" + sm + "\n" + be + "\n" + co + "\n" + fr + "\n" + cr + "\n" + la);
                        }
                        else{
                            System.out.println("Coleccion vacia");
                        }
                    }
                    else{
                        System.out.println("Coleccion no ha sido creada");
                    }
                    break;
                case 7:
                    System.out.println("Feliz dia");
                    break;
            }
        }
    }
}
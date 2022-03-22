package Maps; /**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #6
 *
 * Entorno: El ejercicio tiene como objetivo la simulacion de una tienda online utilizando tres implementaciones de interfaz Map.
 * Clase: Maps.HashMapa
 * Proposito: Clase que extiende Maps.Mapa y utiliza HashMap
 *
 * @author Adrian Fulladolsa Palma
 *
 */
import java.util.*;

public class HashMapa extends Mapa {
    @Override
    public HashMap<String, String> creacionInventario(ArrayList<String> inv) {
        HashMap<String, String> inven = new HashMap<>();
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
   HashMap<String, Producto> crearCarrito(Map<String, String> inv) {
        HashMap<String, Producto> cart = new HashMap<>();
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
                System.out.println("Maps.Producto no encontrado");
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
            System.out.println("Maps.Producto "+ nom + " pertenece a categoria " + inv.get(nom));
        }
        else{
            System.out.println("Maps.Producto no existente");
        }
    }

    @Override
    void MostrarDatos(Map<String, Producto> cart) {
        System.out.println("Productos en coleccion");
        if(cart != null) {
            if(!cart.isEmpty()) {
                for (Producto value : cart.values()) {
                    System.out.println("Maps.Producto: " + value.getNombre() + "| Categoria: " + value.getCategoria() + "| Cantidad: " + value.getCantidad());
                }
            }
            else{
                System.out.println("Coleccion vacia");
            }
        }
        else{
            System.out.println("Coleccion no ha sido creada");
        }
    }

    @Override
    void MostrarDatosTipo(Map<String, Producto> cart) {
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
                            mt = mt + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Sillones de masaje":
                            sm = sm + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Bebidas":
                            be = be + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Condimentos":
                            co = co + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Frutas":
                            fr = fr + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Carnes":
                            cr = cr + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
                            break;
                        case "Lácteos":
                            la = la + "\n Maps.Producto: " + value.getNombre()+ "| Cantidad: " + value.getCantidad();
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
    }

    @Override
    void MostrarDatosTodo(Map<String, String> inv) {
        System.out.println("Productos en coleccion");
        if(inv != null) {
            if(!inv.isEmpty()) {
                for(Map.Entry<String,String> entry : inv.entrySet()){
                    String k = entry.getKey();
                    String v = entry.getValue();
                    System.out.println("Maps.Producto: " + k + " |Categoria: " + v);
                }
            }
            else{
                System.out.println("Coleccion vacia");
            }
        }
        else{
            System.out.println("Coleccion no ha sido creada");
        }
    }

    @Override
    void MostrarDatosTodoTipo(Map<String, String> inv) {
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
    }


}

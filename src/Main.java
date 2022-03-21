import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Lector l = new Lector();

        ArrayList<String> inventario = l.lector("ListadoProductos.txt");
        for (int i = 0; i < inventario.size(); i++){
            System.out.println(inventario.get(i));
        }
        System.out.println("""
                Seleccione un tipo de stack a implementar:
                [1]. HashMap.
                [2]. TreeMap.
                [3]. LinkedHashMap.""");

    }


}
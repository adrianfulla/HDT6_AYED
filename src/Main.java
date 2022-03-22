import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Lector l = new Lector();
        Mapa m;

        ArrayList<String> inventario = l.lector("ListadoProductos.txt");
        for (int i = 0; i < inventario.size(); i++){
            System.out.println(inventario.get(i));
        }
        int seleccion;
        while(true) {
            try{
                System.out.println("""
                    Seleccione un tipo de stack a implementar:
                    [1]. HashMap.
                    [2]. TreeMap.
                    [3]. LinkedHashMap.""");
                seleccion = s.nextInt();
                if(seleccion <= 0 || seleccion > 3){
                    System.out.println("Valor no encontrado dentro de opciones");
                    continue;
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Valor ingresado no valido");
                s.next();
                continue;
            }
        }
        switch (seleccion){
            case 1:
                m = new HashMapa();
                break;
            case 2:
                m = new TreeMapa();
                break;
            case 3:
                m = new LinkedHashMapa();
                break;
        }
    }


}
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
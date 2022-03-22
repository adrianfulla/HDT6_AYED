import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Mapa{
    abstract Map<String, String> creacionInventario(ArrayList<String> inv);

    abstract Map<String, Producto> crearCarrito(Map<String,String> inv);

    abstract void MostrarCategoriaProducto(String nom, Map<String, String> inv);
}

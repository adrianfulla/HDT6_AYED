import java.util.ArrayList;

public abstract class Mapa{
    abstract Mapa creacionInventario(ArrayList<String> inv);

    abstract Mapa agregarProducto(String cat, String art, int cant);

    abstract void mostrarProducto(String producto);//
    abstract void mostrarProductos(); //mostrar producto, categoria y cantidad
    abstract void mostrarProductosTipo(String cat); //mostrar productos y sus cantidades por categoria elegida
    abstract void mostrarTodoProducto(); //Mostrar todas las categorias y productos
    abstract void mostrarProductoExistente(); //Mostrar productos existentes por categoria

}

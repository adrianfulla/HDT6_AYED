import jdk.jfr.Category;

import java.util.Calendar;

public class Producto {
    String nombre;
    String categoria;
    int cantidad;

    public Producto(String n, String c, int i){
        this.nombre = n;
        this.categoria = c;
        this.cantidad = i;
    }

    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getCantidad(){
        return String.valueOf(cantidad);
    }
}

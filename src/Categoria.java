import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Producto> productoList;
    public Categoria(String nombre) {
        this.nombre = nombre;
        this.productoList = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productoList;
    }

    public void agregarProducto(Producto producto) {
        productoList.add(producto);
    }
    public void agregarProducto() {
        System.out.println("**** Categoría: " + nombre + " ****");
                for (Producto producto : productoList) {
                producto.mostrarProducto();
                System.out.println(); // Separador

        }
    }
}

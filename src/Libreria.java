import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Categoria> categorias;

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.categorias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void mostrarInventario() {
        System.out.println("**** Inventario de la Librería: " + nombre + " ****");

            for (Categoria categoria : categorias) {
                categoria.agregarProducto();
                System.out.println(); // separador entre categorías
            }
    }
}
import java.util.ArrayList;
import java.util.List;

public class Inventario<T extends Producto> {
    private List<Categoria> categorias;

    public Inventario() {
        categorias = new ArrayList<>();
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void mostrarInventario() {
        System.out.println("======= Inventario Completo =======");
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías en el inventario.");
            return;
        }

        for (Categoria categoria : categorias) {
            categoria.agregarProducto();
            System.out.println(); // separador entre categorías
        }
    }

    public T buscarProductoPorCodigo(String codigo) {
        for (Categoria categoria : categorias) {
            for (Producto producto : categoria.getProductos()) {
                if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                    return (T) producto;
                }
            }
        }
        return null;
    }
}
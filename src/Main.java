public class Main {
    public static void main(String[] args) {
        // Crear productos de distintos tipos

        Productolibros libro = new Productolibros("El Principito", 100.00, "LIB001", "Clásico de la literatura, Antoine de Saint-Exupéry,96");
        Productorevista revista = new Productorevista("National Geographic", 144.74, "REV001", "Edición especial sobre el océano, NG Editorial, 202");

        // Crear categorías
        Categoria libros = new Categoria("Libros");
        libros.agregarProducto(libro);
        Categoria revistas = new Categoria("Revistas");
        revistas.agregarProducto(revista);

        // Crear librería y agregar categorías
        Libreria libreria = new Libreria("Librería Evaluacion 2");
        libreria.agregarCategoria(libros);
        libreria.agregarCategoria(revistas);

        // Mostrar inventario completo
        libreria.mostrarInventario();
    }
}
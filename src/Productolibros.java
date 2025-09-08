public class Productolibros extends Producto{

    public Productolibros(String nombre, double precio, String codigo, String descripcion) {
        super(nombre, precio, codigo, descripcion);
    }

    @Override
    public void mostrarProducto() {
        System.out.println("**** Mostrar Libros ****");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio $: " + getPrecio());
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Descripcion: " + getDescripcion());
    }
}

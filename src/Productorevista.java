public class Productorevista extends Producto{

    public Productorevista(String nombre, double precio, String codigo, String descripcion) {
        super(nombre, precio, codigo, descripcion);
    }

    @Override
    public void mostrarProducto() {
        System.out.println("**** Mostrar Revistas ****");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio $: " + getPrecio());
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Descripcion: " + getDescripcion());
    }
}
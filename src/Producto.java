public abstract class Producto implements Interproducto {
    private String nombre;
    private double precio;
    private String codigo;
    private String descripcion;
    //Constructor
    public Producto(String nombre, double precio, String codigo, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    //Metodos implementados
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public double getPrecio() {
        return precio;
    }
    @Override
    public String getCodigo() {
        return codigo;
    }
    @Override
    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public abstract void mostrarProducto();
}

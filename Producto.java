package tpsupermarket;
// Si el producto es Primera necesidad, el constructor debería recibir el pocentaje para realizar el descuento al precio ( esto es preferible hacerlo en el constructor de este producto)
public class Producto implements Cloneable{

    private String nombre;
    private String marca;
    private double precio;
    private boolean primNec;
    private boolean precioCuidado;

    public Producto(String nombre, String marca, double precio, boolean precioCuidado,boolean primNecesidad) {
      
        this(nombre, marca, precio,primNecesidad); // ¿Esto compila ? 
       this.precioCuidado = precioCuidado;
    }
    
    public Producto(String nombre, String marca, double precio,boolean primNec) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.primNec = primNec;
    }

    public void mostrarDatos() {
        System.out.println("Nombre del producto: " + nombre + ", marca: " + marca + ", precio: " + precio + ", el producto es de primera necesidad: " + primNec);
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esPrimNec() {
        return primNec;
    }
    
    public boolean esPrecioCuidado(){
        return precioCuidado;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
  
        Producto copia = new Producto (this.nombre,this.marca,this.precio,this.precioCuidado, this.primNec);
        return copia;
    }
    
}

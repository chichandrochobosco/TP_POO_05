package tpsupermarket;

public class Producto implements Cloneable {

    protected String nombre;
    protected String marca;
    protected double precio;
    protected boolean precioCuidado;

    public Producto(String nombre, String marca, double precio, boolean precioCuidado) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.precioCuidado = precioCuidado;
    }

    public void mostrarDatos() {
        System.out.println("Nombre del producto: " + nombre + ", marca: " + marca + ", precio: " + precio + ", precios cuidados:" + precioCuidado);
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

    public boolean esPrecioCuidado() {
        return precioCuidado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    public Producto copy(){
        return new Producto(this.getNombre(), this.getMarca(), this.getPrecio(), this.esPrecioCuidado());
    }

}

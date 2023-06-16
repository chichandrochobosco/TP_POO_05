package tpsupermarket;

public class ProductoPrimeraNecesidad extends Producto{

    public ProductoPrimeraNecesidad(String nombre, String marca, double precio, boolean preciosCuidados) {
        super(nombre, marca, precio, preciosCuidados);
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre del producto: " + nombre + ", marca: " + marca + ", precio: " + precio + ", precios cuidados:" + precioCuidado + ", primera necesidad: true");
    }
    
    @Override
    public Producto copy(){
        return new ProductoPrimeraNecesidad(this.getNombre(), this.getMarca(), this.getPrecio(), this.esPrecioCuidado());
    }
    
    
}

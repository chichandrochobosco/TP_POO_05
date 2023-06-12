
package tp_poo_05;


public class Producto {
    private String nombre;
    private String marca;
    private int precio;
    private boolean primNec;

    public Producto(String nombre, String marca, int precio, boolean primNec) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.primNec = primNec;
    }
    
    public void mostrarDatos(){
        System.out.println("Nombre del producto: "+nombre+", marca: "+marca+", precio: "+precio+", el producto es de primera necesidad: "+primNec);
    }
    
    
    
    
    
    
}

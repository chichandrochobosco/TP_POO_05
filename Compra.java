package tpsupermarket;

import java.util.List;
// es Venta !
public class Compra {
    // falta instanciar el array
    private List<Producto> productos;
    private double valorTotal;
    // falta fecha, la consigna pide totales en un determinado día

    public Compra(List<Producto> productos, double valorTotal) {
       // this.productos = productos;
        // recibe fecha y NO el array
        this.valorTotal = valorTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    // faltan todos los métodos para manipular el array de productos
    
}

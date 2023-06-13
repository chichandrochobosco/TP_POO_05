package tpsupermarket;

import java.util.List;

public class Compra {
    private List<Producto> productos;
    private double valorTotal;

    public Compra(List<Producto> productos, double valorTotal) {
        this.productos = productos;
        this.valorTotal = valorTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    
}

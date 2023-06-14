package tpsupermarket;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Compra> compras;
    private List<Producto> productos;
    private double importeTotalVentas;
    private double importeTotalDescuento;
    private int cantProdVendidosPrimeraNec;
    private int cantProdVendidosPreciosCuidados;

    public Supermercado(List<Producto> productos) {
        this.compras = new ArrayList<>();
        this.productos = productos;
    }
    
    public double obtenerTotalVentas(){
        return importeTotalVentas;
    }
    
    public double obtenerCantProdPrimeraNec(){
        return cantProdVendidosPrimeraNec;
    }
    
    public double obtenerCantProdPreciosCuidados(){
        return cantProdVendidosPreciosCuidados;
    }
    
    public double obtenerImporteTotalDescuentos(){
        return importeTotalDescuento;
    }

    public void hacerCompra(List<Producto> productos){
        double valorCompra = calcularMontoCompra(productos);
        Compra compra = new Compra(productos,valorCompra);
        compras.add(compra);
    }
    
    public void añadirProducto(Producto producto){
        productos.add(producto);
    }
    
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }
    
    private double calcularMontoCompra(List<Producto> productos){
  // este método debería pertencer a la compra (Venta) que es la dueña de la lista de productos
        
        
        double montoCompra = 0;
        for(Producto p: productos){
            double precioProducto = p.getPrecio();
            if (p.esPrimNec()) {
                double descuento = (precioProducto * 0.1);
                precioProducto = precioProducto - descuento;
                importeTotalDescuento = importeTotalDescuento + descuento;
                cantProdVendidosPrimeraNec++;
            }
            if(p.esPrecioCuidado()){
                cantProdVendidosPreciosCuidados++;
            }
            
            montoCompra = montoCompra + precioProducto;
        }
        importeTotalVentas = importeTotalVentas + montoCompra;
        return montoCompra;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    
    
}

package tpsupermarket;

import java.util.List;

public class Venta {

    static int idTotal;
    private List<Producto> productos;
    private double valorTotal;
    private int id;
    private String fecha;
    
    public Venta(List<Producto> productos,String fecha) {
        this.productos = productos;
        this.id = idTotal;
        Venta.idTotal++;
        valorTotal = calcularPrecio();
        this.fecha = fecha;
    }
    
    private double calcularPrecio() {
        double precioTotal = 0;

        for (Producto p : productos) {
            
            if(p instanceof ProductoPrimeraNecesidad){
                hacerDescuento(p);
            }
            
            precioTotal += p.getPrecio();
        }
        
        return precioTotal;
    }
    
    public void hacerDescuento(Producto p) {
        p.setPrecio(p.getPrecio() - (p.getPrecio() * (0.1)));
    }

    public int getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFecha() {
        return fecha;
    }
    
    

}

package tpsupermarket;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private List<Venta> ventas;
    private List<Producto> productosDisponibles;
    private double importeTotalVentas;
    private double importeTotalDescuento;
    private int cantProdVendidosPrimeraNec;
    private int cantProdVendidosPreciosCuidados;

    public Supermercado(List<Producto> productosDisponibles) {
        this.ventas = new ArrayList<>();
        this.productosDisponibles = productosDisponibles;
    }

    public void realizarVenta(List<Producto> productosVenta,String fecha) {
        Venta venta = new Venta(productosVenta,fecha);
        ventas.add(venta);
        emitirTicket(venta);
        importeTotalVentas += venta.getValorTotal();
        sumarImporteDescuento(venta);
    }

    public void emitirTicket(Venta venta) {
        System.out.println("---TICKET---");
        System.out.println("N°:" + (venta.getId()+1));
        for (Producto p : venta.getProductos()) {
            p.mostrarDatos();
        }
        System.out.println("FECHA: " + venta.getFecha());
        System.out.println("Total:" + venta.getValorTotal());
    }
    
    public void calcularProductosPrimeraNecesidad(List<Venta> ventas) {
        for (Venta v : ventas) {
            for (Producto p : v.getProductos()) {
                if (p instanceof ProductoPrimeraNecesidad) {
                    cantProdVendidosPrimeraNec++;
                }
            }
        }
    }

    public void calcularProductosPreciosCuidados(List<Venta> ventas) {
        for (Venta v : ventas) {
            for (Producto p : v.getProductos()) {
                if (p.esPrecioCuidado()) {
                    cantProdVendidosPreciosCuidados++;
                }
            }
        }
    }

    public void sumarImporteDescuento(Venta venta) {
        for (Producto p : venta.getProductos()) {
            if (p instanceof ProductoPrimeraNecesidad) {
                double precioOriginal = ((p.getPrecio() * 100) / 90);
                importeTotalDescuento += precioOriginal * (0.1);
            }
        }
    }

    public double obtenerTotalVentas() {
        return importeTotalVentas;
    }

    public double obtenerCantProdPrimeraNec() {
        calcularProductosPrimeraNecesidad(ventas);
        return cantProdVendidosPrimeraNec;
    }

    public double obtenerCantProdPreciosCuidados() {
        calcularProductosPreciosCuidados(ventas);
        return cantProdVendidosPreciosCuidados;
    }

    public double obtenerImporteTotalDescuentos() {
        return importeTotalDescuento;
    }

    public void añadirProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        int cont=0;
        for(Producto p: productosDisponibles){
            if(p.getNombre().equalsIgnoreCase(nombreProducto)){
                productosDisponibles.remove(cont);
                return;
            }
            cont++;
        }
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }
}

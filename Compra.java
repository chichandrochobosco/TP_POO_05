/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsupermarkey;

import java.util.List;

/**
 *
 * @author losmelli
 */
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

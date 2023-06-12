/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsupermarkey;

/**
 *
 * @author losmelli
 */
public class Producto {

    private String nombre;
    private String marca;
    private int precio;
    private boolean primNec;
    private boolean precioCuidado;

     public Producto(String nombre, String marca, int precio, boolean precioCuidado,boolean primNecesidad) {
       this(nombre, marca, precio,primNecesidad);
        this.precioCuidado = precioCuidado;
    }
    
    public Producto(String nombre, String marca, int precio,boolean primNec) {
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

    public int getPrecio() {
        return precio;
    }

    public boolean esPrimNec() {
        return primNec;
    }
    
    public boolean esPrecioCuidado(){
        return precioCuidado;
    }
    
    
}

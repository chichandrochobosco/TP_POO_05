package tpsupermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado(new ArrayList<Producto>());
        menu(supermercado);
    }

    public static void menu(Supermercado supermercado) {
        int opc;

        do {

            System.out.println("Selecciones la opción que desea: ");
            System.out.println("1. Realizar compra, 2. agregar producto, 3. eliminar un producto, 4. Ver cantidad de productos de primera necesidad vendidos, 5. ver productos de precios cuidados vendidos, 6.Ver el total de los descuentos aplicados 7.Ver el total de las ventas, 8. Salir");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1 ->
                    hacerCompra(supermercado);
                case 2 ->
                    añadirProducto(supermercado);
                case 3 ->
                    eliminarProducto(supermercado);
                case 4 ->
                    System.out.println("La cantidad de productos de primera necesidad vendidos son: " + supermercado.obtenerCantProdPrimeraNec());
                case 5 ->
                    System.out.println("La cantidad de productos de precios cuidados vendidos son: " + supermercado.obtenerCantProdPreciosCuidados());
                case 6 ->
                    System.out.println("El importe total de los descuentos aplicados es: " + supermercado.obtenerImporteTotalDescuentos());
                case 7 ->
                    System.out.println("La el total de $ ganado es: " + supermercado.obtenerTotalVentas());
            }
        } while (opc != 8);
    }

    public static void hacerCompra(Supermercado supermercado) {
        if (!supermercado.getProductosDisponibles().isEmpty()) {
            ArrayList<Producto> productos = seleccionarProductos(supermercado.getProductosDisponibles());
            System.out.println("Ingrese Fecha:");
            String fecha = in.nextLine();
            supermercado.realizarVenta(productos,fecha);

        } else {
            System.out.println("-----------------------------");
            System.out.println("No hay productos para elegir");
            System.out.println("-----------------------------");
        }
    }

    public static ArrayList<Producto> seleccionarProductos(List<Producto> productos) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        int opc;

        do {
            int i = 0;

            System.out.println("productos:");
            for (Producto p : productos) {
                System.out.print((i + 1) + ". ");
                p.mostrarDatos();
                i++;
            }
            System.out.print("Ingrese el numero del que desea: ");
            opc = in.nextInt();
            in.nextLine();
            
            Producto seleccion = productos.get(opc - 1).copy();
            productosSeleccionados.add(seleccion);
                
            

            System.out.println("Desea ingresar otro producto mas? 1.SI 2.NO");
            opc = in.nextInt();
            in.nextLine();

        } while (opc != 2);

        return productosSeleccionados;
    }

    public static void añadirProducto(Supermercado supermercado) {
        String nombre, marca;
        double precio;
        boolean primNec, precioCuidado;
        
        System.out.print("Ingrese nombre: ");
        nombre = in.nextLine();
        System.out.print("Ingrese marca: ");
        marca = in.nextLine();
        System.out.print("Ingrese precio: ");
        precio = in.nextDouble();
        System.out.print("ingrese si el producto es de precios cuidados: true o false: ");
        precioCuidado = in.nextBoolean();
        System.out.print("ingrese si el producto es de primera necesidad: true o false: ");
        primNec = in.nextBoolean();
        if(primNec == true){
            supermercado.añadirProducto(new ProductoPrimeraNecesidad(nombre, marca, precio, precioCuidado));
            return;
        }
        supermercado.añadirProducto(new Producto(nombre, marca, precio, precioCuidado));
    }

    public static void eliminarProducto(Supermercado supermercado) {
        String nombre, marca;
        double precio;
        boolean primNec, precioCuidado;

        System.out.println("Ingrese los valores del producto a eliminar");
        System.out.print("Ingrese nombre: ");
        nombre = in.nextLine();
       
 
        
        
        supermercado.eliminarProducto(nombre);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnold,Fabio, Gladys, Jordy
 */
 
public class Base_Inventario {
   public HashMap<Integer, Product> lista = new HashMap<>();
    public String archivo = "inventario.txt";
    /**
     * Constructor de la clase Base_Inventario.
     * Carga los productos desde el archivo al crear una instancia de la clase.
     */
    public Base_Inventario() {
        cargarProductos();
    }
     /**
     * Obtiene una lista de todos los productos en la base de inventario.
     *
     * @return una lista de todos los productos en la base de inventario
     */
    public List<Product> getLista() {
        return new ArrayList<>(this.lista.values());
    }
     /**
     * Establece la lista de productos en la base de inventario.
     *
     * @param lista la lista de productos a establecer
     */
    public void serLista(HashMap<Integer, Product> lista) {
        this.lista = lista;
    }
    /**
     * Verifica si un producto está presente en la base de inventario.
     *
     * @param producto el producto a verificar
     * @return true si el producto está presente, false en caso contrario
     */
    public boolean verificarExistencia(Product producto) {
        return this.lista.containsKey(producto.getCodigo());
    }
    /**
     * Verifica si existe un producto con un nombre específico en la base de inventario.
     *
     * @param nombre el nombre del producto a verificar
     * @return true si existe un producto con el nombre especificado, false en caso contrario
     */
    public boolean verificarExistencia(String nombre) {
        for (Product product : this.lista.values()) {
            if (nombre.equalsIgnoreCase(product.getNombre())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Obtiene el último código utilizado en la base de inventario.
     *
     * @return el último código utilizado en la base de inventario
     */
    public int ultimoCodigo() {
        int codigo = 0;
        for (Product product : this.lista.values()) {
            codigo = product.getCodigo();
        }
        return codigo;
    }
    //----------------------------------------------------------------------
    /**
    * Guarda los productos en un archivo.
    * Los productos se guardan en formato CSV (valores separados por comas).
    * Cada línea del archivo representa un producto con su código, nombre, precio y existencia.
    */
    private void guardarProductos() {
    try {
        FileWriter writer = new FileWriter(archivo);
        for (Product producto : lista.values()) {
            writer.write(producto.getCodigo() + "," + producto.getNombre() + 
                    "," + producto.getPrecio() + "," + producto.getExistencia() + "\n");
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    //*************************************************************************
    /**
     * Agrega un producto a la lista y guarda la lista actualizada en un archivo.
     *
     * @param product product el producto que se va a agregar a la lista
     *  
     */
    public void agregar(Product product) {
        this.lista.put(product.getCodigo(), product);
        guardarProductos();
    }
    /**
     * Actualiza un producto en la lista y guarda la lista actualizada en un archivo.Si el producto existe en la lista (identificado por su código), se reemplaza con el nuevo producto proporcionado.
     *
     * @param product
     * product el producto que se va a actualizar en la lista
     */
    public void actualizar(Product product) {
        if (this.lista.containsKey(product.getCodigo())) {
            this.lista.replace(product.getCodigo(), product);
            guardarProductos();
        }
    }
    /**
     * Elimina un producto de la lista y guarda la lista actualizada en un archivo.Si el producto existe en la lista (identificado por su código), se elimina de la lista.
     *
     * @param product
     *  product el producto que se va a eliminar de la lista
     */
    public void eliminar(Product product) {
        if (this.lista.containsKey(product.getCodigo())) {
            this.lista.remove(product.getCodigo());
            guardarProductos();
        }
    }
    //----------------------------------------------------------------------
    /**
     * Genera un informe de los nombres de los productos en la lista.
     * Obtiene los productos para el informe utilizando el método privado obtenerInforme().
     * El informe se devuelve como una cadena de texto con los nombres de los productos separados por espacios.
     *
     * @return el informe generado como una cadena de texto con los nombres de los productos
     */
    public String generarInforme() {
        List<Product> listaInforme = (List<Product>) obtenerInforme();
        StringBuilder informe = new StringBuilder();
        for (Product producto : listaInforme) {
            informe.append(producto.getNombre()).append(" ");
        }
        return informe.toString().trim();
    }
    /**
     * Obtiene una lista de productos para generar el informe.
     * La lista se crea a partir de la lista actual de productos.
     * Se seleccionan los 3 productos con el precio más alto.
     *
     * @return una lista de productos para el informe
     */
    private List<Product> obtenerInforme() {
        List<Product> listaNueva = new ArrayList<>(this.lista.values());
        List<Product> listaInforme = new ArrayList<>();
        for (int i = 0; i < 3 && i < listaNueva.size(); i++) {
            Product producto = Collections.max(listaNueva, Comparator.comparingDouble(Product::getPrecio));
            listaInforme.add(producto);
            listaNueva.remove(producto);
        }
        return listaInforme;
    }
    /**
     * Verifica si hay productos con existencia baja y muestra una alerta.
     * Recorre la lista de productos y muestra una alerta para aquellos productos cuya existencia sea menor a 10.
     * La alerta se muestra utilizando un cuadro de diálogo de JOptionPane.
     */
    public void verificarExistenciaBaja() {
            for (Product product : this.lista.values()) {
                if (product.getExistencia() < 10) {
                 String mensaje = "¡Alerta! El producto " + product.getNombre() + " tiene una existencia baja: " + product.getExistencia();
                JOptionPane.showMessageDialog(null, mensaje, "Existencia Baja", JOptionPane.WARNING_MESSAGE);
                }   
            }
    }
    /**
     * Carga los productos desde un archivo.
     * Si el archivo existe, lee sus líneas y crea productos a partir de ellas.
     * Cada línea del archivo debe contener los datos de un producto en el formato: código, nombre, precio, existencia.
     * Los productos se agregan a la lista de productos.
     * Si ocurre algún error durante la lectura del archivo, se imprime la traza de la excepción.
     */
    private void cargarProductos() {
        try {
            File file = new File(archivo);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        int codigo = Integer.parseInt(data[0].trim());
                        String nombre = data[1].trim();
                        double precio = Double.parseDouble(data[2].trim());
                        int existencia = Integer.parseInt(data[3].trim());
                        Product producto = new Product(codigo, nombre, precio, existencia);
                        lista.put(codigo, producto);
                    }
                }
                reader.close();
            }
        } catch(IOException e) {
        e.printStackTrace();
        }           
    }
}
    
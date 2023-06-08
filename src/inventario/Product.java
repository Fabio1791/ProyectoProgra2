/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Arnold, Fabio, Gladys, Jordy.
 */
public class Product {
    int codigo;
    String nombre;
    double precio;
    int existencia;
    /**
     * Constructor por defecto de la clase Producto.
     * Crea un objeto Producto sin valores iniciales.
     */
    public Product() {
    }
    /**
     * Constructor de la clase Producto.
     * Crea un objeto Producto con los valores proporcionados.
     *
     * @param codigo     el código del producto
     * @param nombre     el nombre del producto
     * @param precio     el precio del producto
     * @param existencia la existencia del producto
     */
    public Product(int codigo, String nombre, double precio, int existencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }
    /**
     * Obtiene el código del producto.
     *
     * @return el código del producto
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Establece el código del producto.
     *
     * @param codigo el código del producto a establecer
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del producto.
     *
     * @param nombre el nombre del producto a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Establece el precio del producto.
     *
     * @param precio el precio del producto a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Obtiene la existencia del producto.
     *
     * @return la existencia del producto
     */
    public int getExistencia() {
        return existencia;
    }
    /**
     * Establece la existencia del producto.
     *
     * @param existencia la existencia del producto a establecer
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
}
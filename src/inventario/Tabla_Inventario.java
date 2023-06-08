/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import inventario.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Arnold,Fabio,Gladys,Jordy
 */
public class Tabla_Inventario extends AbstractTableModel {

    private String[] columna = {"Codigo", "Nombre", "Precio", "Existencia"};
    private List<Product> producto = new ArrayList<>();
     /**
     * Constructor de la clase Tabla_Inventario.
     * Crea una instancia de la tabla de inventario con una lista de productos proporcionada.
     *
     * @param producto_n la lista de productos para mostrar en la tabla
     */
    public Tabla_Inventario(List<Product> producto_n){
        this.producto = producto_n;
    }
    /**
     * Obtiene el número de filas en la tabla.
     *
     * @return el número de filas en la tabla
     */
    @Override
    public int getRowCount() {
        return this.producto.size();
        }
    /**
     * Obtiene el número de columnas en la tabla.
     *
     * @return el número de columnas en la tabla
     */
    @Override
    public int getColumnCount() {
        return this.columna.length;
        } 
     /**
     * Obtiene el valor en la posición de la fila y columna especificadas.
     *
     * @param fila    la posición de la fila
     * @param columna la posición de la columna
     * @return el valor en la posición especificada
     */
    @Override
    public Object getValueAt(int fila, int columna) {
        Object respuesta;
        
        switch(columna){
            case 0:
                respuesta = this.producto.get(fila).getCodigo();
                break;
            case 1:
                respuesta = this.producto.get(fila).getNombre();
                break;
            case 2:
                respuesta = this.producto.get(fila).getPrecio();
                break;
            default:
                respuesta = this.producto.get(fila).getExistencia();
        }
        return respuesta;
    }
    /**
     * Obtiene el nombre de la columna en la posición especificada.
     *
     * @param columna1 la posición de la columna
     * @return el nombre de la columna en la posición especificada
     */
    @Override
    public String getColumnName(int columna1){
        return this.columna[columna1];
    }
    /**
     * Actualiza la tabla de inventario.
     * Notifica a los componentes que los datos de la tabla han cambiado.
     */
    public void ActualizarTabla(){
        fireTableDataChanged();
    }
    /**
     * Obtiene el detalle de un producto en la posición de fila especificada.
     *
     * @param fila la posición de la fila
     * @return el producto en la posición de fila especificada
     */
    public Product detalle(int fila){
        return this.producto.get(fila);
    }
}
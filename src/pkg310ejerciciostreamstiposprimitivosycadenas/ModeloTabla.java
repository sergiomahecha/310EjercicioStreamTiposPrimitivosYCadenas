/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import javax.swing.table.DefaultTableModel;

/**
 * Clase para dar modelo al JTable que esta en la ventana.
 * @author sergiohurtado
 */
public class ModeloTabla extends DefaultTableModel{

    /**
     * campo que representa la Gestora con los datos que se van a representar en el JTable.
     */
    private GestoraPersonas gest;

    /**
     * constructor.
     * @param gest Gestora dara valor al campo gest.
     */
    public ModeloTabla(GestoraPersonas gest) {
        this.gest = gest;
    }
    
    /**
     * 
     * @param row int que representa la fila de la tabla.
     * @param column int que representa la columna de la tabla.
     * @return el objeto que dara valor a la celda.
     */
    @Override
    public Object getValueAt(int row, int column) {
        Persona laPersona=gest.get(row);
        if(column==0){
            return laPersona.getNombre();
        }else{
            return laPersona.getEdad();
        }
    }

    /**
     * 
     * @param row int que representa la fila de la tabla.
     * @param column int que representa la columna de la tabla.
     * @return true si las celdas se pueden editar y false en caso contrario.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * 
     * @param column int que representa la columna de la tabla.
     * @return String que representa el nombre que se le dara a cada encabezado de la columna.
     */
    @Override
    public String getColumnName(int column) {
        String[] nombreColumna={"NOMBRE","EDAD"};
        return nombreColumna[column];
    }

    /**
     * 
     * @return int que representa el número de columnas que tendra la tabla.
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * 
     * @return int que representa el numero de filas que tendra la tabla.
     */
    @Override
    public int getRowCount() {
        return gest==null?0:gest.size();
    }

    /**
     * 
     * @param columnIndex int que representa la columna de la tabla.
     * @return clase que se pondra en las columnas de cada fila.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?>[] lasClases={String.class, Integer.class};
        return lasClases[columnIndex];
    }
    
}

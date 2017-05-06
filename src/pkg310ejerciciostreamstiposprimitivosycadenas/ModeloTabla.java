/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergiohurtado
 */
public class ModeloTabla extends DefaultTableModel{

    private GestoraPersonas gest;

    public ModeloTabla(GestoraPersonas gest) {
        this.gest = gest;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Persona laPersona=gest.get(row);
        if(column==0){
            return laPersona.getNombre();
        }else{
            return laPersona.getEdad();
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        String[] nombreColumna={"NOMBRE","EDAD"};
        return nombreColumna[column];
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return gest==null?0:gest.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?>[] lasClases={String.class, Integer.class};
        return lasClases[columnIndex];
    }
    
}

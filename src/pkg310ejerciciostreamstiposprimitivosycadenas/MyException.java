/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import javax.swing.JComponent;

/**
 *
 * @author sergiohurtado
 */
public class MyException extends Exception{
    private JComponent componente;

    public MyException(JComponent componente, String message) {
        super(message);
        this.componente = componente;
    }

    public JComponent getComponente() {
        return componente;
    }
    
}

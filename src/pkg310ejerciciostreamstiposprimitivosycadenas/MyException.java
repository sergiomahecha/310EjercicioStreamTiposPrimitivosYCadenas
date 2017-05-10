/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import javax.swing.JComponent;

/**
 * clase extendida de Exeption para darle más funcionalidad.
 * @author sergiohurtado
 */
public class MyException extends Exception{
    
    /**
     * campo que representa un Jcomponent.
     */
    private JComponent componente;

    /**
     * 
     * @param componente Jcomponent que se espera para despues seleccionarlo.
     * @param message String que representa un mensaje que luego se utilizara.
     */
    public MyException(JComponent componente, String message) {
        super(message);
        this.componente = componente;
    }

    /**
     * 
     * @return JComponent que es el que se utilizara fuera de la clase, por eso es public.
     */
    public JComponent getComponente() {
        return componente;
    }
    
}

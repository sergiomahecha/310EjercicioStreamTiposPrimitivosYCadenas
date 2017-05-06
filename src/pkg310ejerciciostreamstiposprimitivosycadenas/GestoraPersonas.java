/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class GestoraPersonas extends ArrayList<Persona>{
    private Persona laPersona;
    private static GestoraPersonas INSTANCE;
    private static String FILENAME="personas.dat";
    
    private boolean yaExiste(Persona p){
        for(Persona unaPersona:this){
            if(unaPersona.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    private boolean guardarPersona(Persona p){
        boolean devolver=false;
        if(!yaExiste(p)){
            devolver=this.add(p);
            this.EscribirArchivo();
        }
        return devolver;
    }

    private void EscribirArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

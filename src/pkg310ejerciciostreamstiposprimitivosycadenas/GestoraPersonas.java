/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class GestoraPersonas extends ArrayList<Persona>{
    
    private Persona laPersona;
    private static GestoraPersonas INSTANCE;
    private static String FILENAME="personas.dat";

    private GestoraPersonas() {
    }
    
    private boolean yaExiste(Persona p){
        for(Persona unaPersona:this){
            if(unaPersona.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    public boolean guardarPersona(Persona p){
        boolean devolver=false;
        if(!yaExiste(p)){
            devolver=this.add(p);
            this.escribirArchivo();
        }
        return devolver;
    }
    
    private void escribirArchivo() {
        try (ObjectOutputStream escritor=new ObjectOutputStream(new FileOutputStream(FILENAME))){
            escritor.writeObject(this);
        } catch (IOException ex) {
            Logger.getLogger(GestoraPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static GestoraPersonas getINSTANCE() {
        GestoraPersonas leido=leerArchivo();
        if(leido==null){
            leido=new GestoraPersonas();
        }
        return leido;
    }
    
    private static GestoraPersonas leerArchivo(){
        try (ObjectInputStream lector=new ObjectInputStream(new FileInputStream(FILENAME))){
            return (GestoraPersonas)lector.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraPersonas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraPersonas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

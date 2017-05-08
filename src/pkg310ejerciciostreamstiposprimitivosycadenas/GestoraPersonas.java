/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class GestoraPersonas extends ArrayList<Persona>{
    
    private Persona laPersona;
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
            Collections.sort(this);
            this.escribirArchivo();
        }
        return devolver;
    }
    
    private void escribirArchivo() {
        try (DataOutputStream escritor=new DataOutputStream(new FileOutputStream(FILENAME))){
            for(Persona laPersona:this){
                escritor.writeUTF(laPersona.getNombre());
                escritor.writeInt(laPersona.getEdad());
            }
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
        GestoraPersonas nuevaGestora=new GestoraPersonas();
        try (DataInputStream lector=new DataInputStream(new FileInputStream(FILENAME))){
            do {
                Persona nuevaPersona=new Persona(lector.readUTF(), lector.readInt());
                nuevaGestora.add(nuevaPersona);
            } while (true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraPersonas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            return nuevaGestora;
        } catch (IOException ex) {
            return null;
        }
        return null;
    }
    
    public boolean borrarContenidoArchivo(){
        File archivo=new File(".", FILENAME);
        try(FileOutputStream escritor=new FileOutputStream(archivo)){
            this.clear();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
}

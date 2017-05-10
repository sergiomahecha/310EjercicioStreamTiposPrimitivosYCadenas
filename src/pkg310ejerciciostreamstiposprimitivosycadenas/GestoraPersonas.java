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
    
    /**
     * Campo que representa a la persona que se guardara.
     */
    private Persona laPersona;
    
    /**
     * Campo que representa el nombre del archivo donde se guardaran los datos de la gestora.
     */
    private static String FILENAME="personas.dat";

    /**
     * Constructor de la clase que esta vacio.
     */
    private GestoraPersonas() {
    }
    
    /**
     * 
     * @param p Objeto de la clase persona del cual queremos saber si en el ArrayList existen sus mismos datos.
     * @return true si los datos de la Persona p ya estan en el ArrayList y false si no lo estan.
     */
    private boolean yaExiste(Persona p){
        for(Persona unaPersona:this){
            if(unaPersona.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Este metodo comprueba si la Persona no existe en el ArrayList mediante el metodo yaExiste(), si no existe lo guarda.
     * @param p Objeto de la clase persona que se quiere guardar en el ArrayList.
     * @return true si se consigue guardar a la persona y false en caso contrario.
     */
    public boolean guardarPersona(Persona p){
        boolean devolver=false;
        if(!yaExiste(p)){
            devolver=this.add(p);
            Collections.sort(this);
            this.escribirArchivo();
        }
        return devolver;
    }
    
    /**
     * Metodo que escribe los datos del ArrayList en fichero personas.dat.
     */
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
    
    /**
     * Metodo para hacer que la instacia de la gestora sea unica.
     * @return una GestoraPersonas con los datos de personas.dat si los hay, si no una nueva GestoraPersonas.
     */
    public static GestoraPersonas getINSTANCE() {
        GestoraPersonas leido=leerArchivo();
        if(leido==null){
            leido=new GestoraPersonas();
        }
        return leido;
    }
    
    /**
     * 
     * @return una GestoraPersonas si hay datos en el fichero personas.dat, si no devuelve null.
     */
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
    
    /**
     * Método que borra los datos del archiv personas.dat y si los borra vacia el arrayList.
     * @return true si los datos del archivo personas.dat se han borrado y false en caso contrario.
     */
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

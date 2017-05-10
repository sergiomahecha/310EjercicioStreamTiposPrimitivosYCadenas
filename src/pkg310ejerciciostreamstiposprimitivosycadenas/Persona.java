/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import java.io.Serializable;
import java.text.Collator;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author sergio
 */
public class Persona extends HashMap<Claves, Object> implements Comparable<Persona>, Serializable{
    /**
     * Constructor de la clase Persona.
     * @param nombre String que representa el nombre de la persona.
     * @param edad Integer que espera la edad de la persona.
     */
    public Persona(String nombre, Integer edad) {
        put(Claves.NOMBRE, nombre);
        put(Claves.EDAD, edad);
    }
    
    /**
     * 
     * @return String que representa el nombre de la persona.
     */
    public String getNombre() {
        return (String) this.get(Claves.NOMBRE);
    }
    
    /**
     * 
     * @return Integer que representa la edad de la persona.
     */
    public Integer getEdad() {
        return (Integer) this.get(Claves.EDAD);
    }

    /**
     * Este metodo compara primero el nombre de la persona y despues la edad.
     * @param o Objeto de la clase persona con el que compara este método.
     * @return 0 si el objeto con el que se compara es igual o un numero distinto de 0 si el objeto es disitinto
     */
    @Override
    public int compareTo(Persona o) {
        Collator secuencia=Collator.getInstance();
        secuencia.setStrength(Collator.PRIMARY);
        int[] criterios={secuencia.compare(this.getNombre(), o.getNombre()),
            this.getEdad().compareTo(o.getEdad())};
        for(int unCriterio:criterios){
            if(unCriterio!=0){
                return unCriterio;
            }
        }
        return 0;
    }

    /**
     * 
     * @param o Objeto con el que se compara a un Objeto de la clase Persona.
     * @return true si el objeto es igual false si no lo es.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Persona other = (Persona) o;
        return this.compareTo(other)==0?true:false;
    }
    
}

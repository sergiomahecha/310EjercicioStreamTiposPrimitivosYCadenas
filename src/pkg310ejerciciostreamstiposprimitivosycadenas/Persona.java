/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg310ejerciciostreamstiposprimitivosycadenas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author sergio
 */
public class Persona extends HashMap<Claves, Object> implements Comparable<Persona>, Serializable{
    
    public Persona(String nombre, Integer edad) {
        put(Claves.NOMBRE, nombre);
        put(Claves.EDAD, edad);
    }

    public String getNombre() {
        return (String) this.get(Claves.NOMBRE);
    }

    public Integer getEdad() {
        return (Integer) this.get(Claves.EDAD);
    }

    @Override
    public int compareTo(Persona o) {
        int[] criterios={this.getNombre().compareTo(o.getNombre()),
            this.getEdad().compareTo(o.getEdad())};
        for(int unCriterio:criterios){
            if(unCriterio!=0){
                return unCriterio;
            }
        }
        return 0;
    }

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

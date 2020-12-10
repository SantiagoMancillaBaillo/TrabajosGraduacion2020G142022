/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class Lugar implements Comparable<Lugar>{
    private String nombre;
    
    public Lugar(String nombre){
        this.nombre = nombre;
    }
    
    public String verLugar(){
        return nombre;
    }
    public void asignarLugar(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre ;
    }
    
    public void mostrar(){
        System.out.println (nombre);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lugar other = (Lugar) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Lugar l) {
        return this.nombre.compareTo(l.nombre);
    }
    
    
    
}

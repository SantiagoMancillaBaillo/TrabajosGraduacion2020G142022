/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class PalabraClave implements Comparable<PalabraClave>{
    private String nombre;
    
    public PalabraClave (String nombre){
        this.nombre = nombre;
    }
    
    public String verPalabraClave(){
        return nombre;
    }
    public void asignarPalabraClave(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return /*"PalabraClave: " +*/ nombre ;
    }
    
    public void mostrar(){
        System.out.println(nombre);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nombre);
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
        final PalabraClave other = (PalabraClave) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PalabraClave p) {
        return this.nombre.compareTo(p.nombre);
    }
    
    
    
    
}

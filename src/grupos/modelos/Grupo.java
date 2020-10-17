/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class Grupo {
    private String nombre, descripcion;
    private ArrayList<MiembroEnGrupo> miembros = new ArrayList<>();
    
    public Grupo (String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String verNombre(){
        return nombre;
    }
    public void asignarNombre(String nom){
        this.nombre = nom;
    }
    public String verDescripcion(){
        return descripcion;
    }
    public void asignarDescripcion(String descrip){
        this.descripcion = descrip;
    }

    public ArrayList<MiembroEnGrupo> verMiembros() {
        return miembros;
    }

//    public void setMiembros(ArrayList<MiembroEnGrupo> miembros) {
//        this.miembros = miembros;
//    }
    
    
    
    public void mostrar(){
        System.out.println("Grupo: " + nombre + "\nDescripcion: " + descripcion);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nombre);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
//import grupos.modelos.Rol;
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

    
    
    public void agregarMiembro(Autor a, Rol r){
        MiembroEnGrupo m = new MiembroEnGrupo(a,r);
        if(!miembros.contains(m)){
        this.miembros.add(m);
//        Autor au = new Autor(a.getNombres());
        }
    }
    
    public void verMiembros(){
        System.out.println("-------GRUPO-------");
        System.out.println("Grupo: " + nombre + "\nDescripcion: " + descripcion);
        System.out.println("Miembros: ");
        for(MiembroEnGrupo i : miembros){
            i.mostrar(1);
        }
        System.out.println("-------------------");
    }
    
    
    public void mostrar(){
        System.out.println("Grupo: " + nombre + "\nDescripcion: " + descripcion);
    }
    
    public void mostrar(int x){
        System.out.println("Grupo: "+ nombre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
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
        MiembroEnGrupo m = new MiembroEnGrupo(a,this,r);
        if(!miembros.contains(m)){
            if(this.esSuperAdministradores() == true){
                MiembroEnGrupo m1 = new MiembroEnGrupo(a,this,Rol.ADMINISTRADOR);
                this.miembros.add(m1);
            }
            else{
                this.miembros.add(m);
            }
        a.agregarGrupo(this, r);
        
        }
    }
    
    public void mostrar(){
        System.out.println("-------GRUPO-------");
        System.out.println("Grupo: " + nombre + "\nDescripcion: " + descripcion);
        if(!miembros.isEmpty()){
        System.out.println("\nMiembros: \n");
        verMiembros();
        }
        System.out.println("-------------------");
    }
    
    public void verMiembros(){
        for(MiembroEnGrupo i : miembros){
            i.mostrarg();
            System.out.println(" ");
        }
    }
    
    public boolean tieneMiembros(){
        boolean tieneMiembros = false;
        if (miembros.isEmpty()){
            tieneMiembros = false;
            System.out.println("NO TIENE MIEMBROS");
        }
        else{
            tieneMiembros = true;
            System.out.println("TIENE MIEMBROS");
        }
        return tieneMiembros;
    }
    
    public void quitarMiembro (Autor miembro){
        
        MiembroEnGrupo m = new MiembroEnGrupo(miembro, this, null);
        if(miembros.contains(m)){
            int pos = miembros.indexOf(m);
        miembros.remove(pos);
        miembro.quitarGrupo(this);
        }
    }
    
    public boolean esSuperAdministradores(){
        boolean superAdministrador = false;
        if (nombre == "Super Administradores"){
            superAdministrador = true;
//            System.out.println("GRUPO '"+ nombre +"' ES GRUPO DE SUPER ADMINISTRADORES");
        }
        else{
            superAdministrador = false;
//            System.out.println("GRUPO '"+ nombre +"' NO ES GRUPO DE SUPER ADMINISTRADORES");
        }
        return superAdministrador;
    }
    
    public void mostrar(String u){
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

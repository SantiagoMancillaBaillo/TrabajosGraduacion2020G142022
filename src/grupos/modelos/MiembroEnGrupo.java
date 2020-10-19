/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
//import autores.modelos.Profesor;
import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class MiembroEnGrupo {
    private Autor autores;
    private Grupo grupos;
    private Rol rol;
       
    public MiembroEnGrupo (Autor autores, Grupo grupos, Rol rol){
        this.autores = autores;
        this.grupos = grupos;
        this.rol = rol;
    }
     
       
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.grupos);
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
        final MiembroEnGrupo other = (MiembroEnGrupo) obj;
        if (!Objects.equals(this.grupos, other.grupos)) {
            return false;
        }
            
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        return true;
    }
    
    
    
    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    public Grupo getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupo grupos) {
        this.grupos = grupos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
    public void mostrarg(){
        autores.mostrar("t");
//        grupos.mostrar("t");
        System.out.println("Rol: " + rol.toString());
    }
    
    public void mostrar(String u, int x){
        System.out.println("____________________");
        autores.mostrar("t");
        grupos.mostrar(1);
        System.out.println("Rol: " + rol.toString());
        System.out.println("____________________");
    }
    
    public void mostrar(int x){
        autores.mostrar(1, 1, 1);
        grupos.mostrar("t");
//        System.out.println("Rol: " + rol.toString());
    }
    
    public void mostrar(int x, int y){
        grupos.mostrar("t");
//        System.out.println("Rol: " + rol.toString() + "\n");
    }
    
    public void mostrar2 (){
        grupos.mostrar(1);
        System.out.println("Rol: " + rol.toString() + "\n");
    }
}


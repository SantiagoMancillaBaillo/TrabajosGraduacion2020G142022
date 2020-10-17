/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.Profesor;

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
    
    

    public Autor getAutores() {
        return autores;
    }

//    public void setProfesores(Profesor profesores) {
//        this.profesores = profesores;
//    }

    public Grupo getGrupos() {
        return grupos;
    }

//    public void setGrupos(Grupo grupos) {
//        this.grupos = grupos;
//    }

    public Rol getRol() {
        return rol;
    }

//    public void setRol(Rol rol) {
//        this.rol = rol;
//    }
    public void mostrar(){
        autores.mostrar();
        grupos.mostrar();
        System.out.println("Rol: " + rol);
    }
    
    public void mostrar(String u){
        grupos.mostrar();
    }
    
    public void mostrar(int x, int y){
        autores.mostrar();
        System.out.println("Rol: " + rol);
    }
}


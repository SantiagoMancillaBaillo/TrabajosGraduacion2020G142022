/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Profesor;

/**
 *
 * @author Windows 10
 */
public class MiembroEnGrupo {
    private Profesor profesores;
    private Grupo grupos;
    private Rol rol;
    
    public MiembroEnGrupo (Profesor profesores, Grupo grupos, Rol rol){
        this.profesores = profesores;
        this.grupos = grupos;
        this.rol = rol;
    }

    public Profesor getProfesores() {
        return profesores;
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
        profesores.mostrar(1);
        grupos.mostrar();
        System.out.println("Rol: " + rol);
    }
    
    public void mostrar(int x, int y){
        profesores.mostrar(1);
        System.out.println("Rol: " + rol);
    }
}


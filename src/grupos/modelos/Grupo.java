/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

/**
 *
 * @author Windows 10
 */
public class Grupo {
    private String nombre, descripcion;
    
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
    
    public void mostrar(){
        System.out.println("\nGrupo: " + nombre + "\nDescripcion: " + descripcion);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import cargos.modelos.Cargo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class Profesor {
    private int dni;
    private String apellidos; 
    private String nombres;
    private String clave;
    private Cargo cargo;
    private ArrayList<MiembroEnGrupo> gruposMiembro;
    
    public Profesor (String nombres, String apellidos, String clave, int dni, Cargo cargo){
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.clave = clave;
            this.dni = dni;
            this.cargo = cargo;
    }
    public String verNombres(){
        return nombres;
    }
    public void asignarNombres(String nombres){
        this.nombres = nombres;
    }
    public String verApellidos(){
        return apellidos;
    }
    public void asignarApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String verClave(){
        return clave;
    }
    public void asignarClave(String clave){
        this.clave = clave;
    }
    public int verDni(){
        return dni;
    }
    public void asignarDni(int dni){
        this.dni = dni;
    }
    public Cargo verCargo(){
        return cargo;
    }
    public void asignarCargo(Cargo cargo){
        this.cargo = cargo;
    }

    public ArrayList<MiembroEnGrupo> getGruposMiembro() {
        return gruposMiembro;
    }

    public void setGruposMiembro(ArrayList<MiembroEnGrupo> gruposMiembro) {
        this.gruposMiembro = gruposMiembro;
    }
    
    
    public void mostrar(){
        System.out.println("Nombre: " + apellidos.toUpperCase() + ", " + nombres);
        System.out.println("DNI: " + dni);
        System.out.println("Cargo: " + cargo);
    }
    public void mostrar(int x){
        System.out.println("Autor: " + apellidos.toUpperCase() + ", " + nombres);
    }
}

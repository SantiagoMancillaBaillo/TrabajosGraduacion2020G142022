/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

/**
 *
 * @author Windows 10
 */
public class Alumno {
    private int dni;
    private String apellidos, nombres, clave, cx; 
    
    public Alumno(String nombres, String apellidos, String clave, int dni, String cx){
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.clave = clave;
            this.dni = dni;
            this.cx = cx;
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
    public String verCx(){
        return cx;
    }
    public void asignarCx (String cx){
        this.cx = cx;
    }
    
    public void mostrar(){
        System.out.println("\nAlumno: " + apellidos.toUpperCase() + ", " + nombres);
        System.out.println("DNI: " + dni);
        System.out.println("CX: " + cx);
    }
    
}

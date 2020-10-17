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
public class Autor {
    private String nombres;
    private String apellidos;
    private String clave;
    private int dni;

    public Autor(String nombres, String apellidos, String clave, int dni) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.dni = dni;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public void mostrar(){
        System.out.println("\nAlumno: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
    }
    
    
}

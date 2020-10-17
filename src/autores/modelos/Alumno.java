/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class Alumno extends Autor {
    private String cx; 
    
    public Alumno(String nombres, String apellidos, int dni, String clave, String cx){
            super(nombres, apellidos, clave, dni);
//            this.nombres = nombres;
//            this.apellidos = apellidos;
//            this.dni = dni;
//            this.clave = clave;
            this.cx = cx;
    }
//    public String verNombres(){
//        return nombres;
//    }
//    public void asignarNombres(String nombres){
//        this.nombres = nombres;
//    }
//    public String verApellidos(){
//        return apellidos;
//    }
//    public void asignarApellidos(String apellidos){
//        this.apellidos = apellidos;
//    }
//    public String verClave(){
//        return clave;
//    }
//    public void asignarClave(String clave){
//        this.clave = clave;
//    }
//    public int verDni(){
//        return dni;
//    }
//    public void asignarDni(int dni){
//        this.dni = dni;
//    }
    public String verCx(){
        return cx;
    }
    public void asignarCx (String cx){
        this.cx = cx;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cx);
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
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.cx, other.cx)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public void mostrar(){
        System.out.println("....Alumno....");
        super.mostrar();
        System.out.println("CX: " + this.cx);
        System.out.println("..............");
    }
    
}

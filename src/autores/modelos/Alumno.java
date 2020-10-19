/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class Alumno extends Autor {
    private String cx; 
    
    private ArrayList<MiembroEnGrupo> grupoMiembro = new ArrayList<>();
    
    public Alumno(String nombres, String apellidos, String clave, int dni, String cx){
            super(nombres, apellidos, clave, dni);
            this.cx = cx;
    }
    public Alumno (String nombres, String apellidos, String clave, int dni){
        super(nombres, apellidos, clave, dni);
    }
    
    public String verCx(){
        return cx;
    }
    public void asignarCx (String cx){
        this.cx = cx;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(this.cx);
//        int hash = 3;
//        hash = 53 * hash + Objects.hashCode(this.cx);
//        hash = 53* hash + this.getDni();
//        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
            return true;
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
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
    public void mostrar(/*String u*/){
        System.out.println("....Alumno....");
        System.out.println("Autor: ["+ super.getDni()+"] " + super.getApellidos().toUpperCase() + ", " + super.getNombres());
//        System.out.println("DNI: " + super.getDni());
        System.out.println("CX: " + this.cx);
        super.mostrar(1,1,1);
        System.out.println("..............");
    }
    
}

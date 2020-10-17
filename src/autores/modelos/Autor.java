/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

//import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public abstract class Autor {
    private String nombres;
    private String apellidos;
    private String clave;
    private int dni;
    private ArrayList<MiembroEnGrupo> grupoMiembro;

    public Autor(String nombres, String apellidos, String clave, int dni) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.dni = dni;
    }

//    public Autor(String nombres, String apellidos, String clave, int dni, ArrayList<MiembroEnGrupo> grupoMiembro) {
//        this.nombres = nombres;
//        this.apellidos = apellidos;
//        this.clave = clave;
//        this.dni = dni;
//        this.grupoMiembro = grupoMiembro;
//    }
    
    

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
    
    public void agregarGrupo(MiembroEnGrupo m){
        grupoMiembro.add(m);
    }
    
    public void mostrarGrupo(){
        for(MiembroEnGrupo i : grupoMiembro){
            i.mostrar("t");
        }
            
    }
    
    public void mostrar(){
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
        System.out.println("Miembro del grupo: " + this.grupoMiembro);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.dni;
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
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    
    
}

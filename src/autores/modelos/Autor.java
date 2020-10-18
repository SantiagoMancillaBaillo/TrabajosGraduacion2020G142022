/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
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
    
    private ArrayList<MiembroEnGrupo> grupoMiembro = new ArrayList<>();

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
    
    public void agregarGrupo(Grupo g, Rol r){
        MiembroEnGrupo m = new MiembroEnGrupo(this, g, r);
        if(!grupoMiembro.contains(m)){
        this.grupoMiembro.add(m);
        Grupo gr = new Grupo(g.verNombre(),r.toString());
        gr.agregarMiembro(this, r);
        }
    }
    
    public void verGrupos(){
        System.out.println("--------AUTOR--------");
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("Grupos a los que pertenece: \n" );
        for(MiembroEnGrupo i : grupoMiembro){
            i.mostrar(1,1);
        }
        System.out.println("---------------------");
    }
    
    public void mostrar(){
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
        System.out.println("Miembro del grupo: " + this.grupoMiembro);
    }
    
    public void mostrar(int x, int y, int z){
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
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
        if (this.getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    
    
}

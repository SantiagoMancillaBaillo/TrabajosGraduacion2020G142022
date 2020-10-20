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
            if(g.esSuperAdministradores() == true){
            MiembroEnGrupo m1 = new MiembroEnGrupo(this, g, Rol.ADMINISTRADOR);
            this.grupoMiembro.add(m1);
        }
            else{
                this.grupoMiembro.add(m);
            }
        g.agregarMiembro(this, r);
        }
    }
     
    public void quitarGrupo (Grupo grupo){
        MiembroEnGrupo m = new MiembroEnGrupo(this, grupo , null);
        if(grupoMiembro.contains(m)){
            int pos = grupoMiembro.indexOf(m);
        grupoMiembro.remove(pos);
        grupo.quitarMiembro(this);
        }
    }
    public void mostrar(){
        System.out.println("--------AUTOR--------");
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
    }
    public void mostrar(String u){
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
    }
    
    
    public void mostrar(int x, int y, int z){
        if(!grupoMiembro.isEmpty()){
        System.out.println("Grupos a los que pertenece: \n" );
        verGrupos();
        }
    }
    
    public void verGrupos(){
        for(MiembroEnGrupo i : grupoMiembro){
            i.mostrar2();
        }
    }
    
    public boolean esSuperAdministrador(){
        boolean superAdmin = false;
        Grupo g = new Grupo("Super Administradores", "Grupo para los super administradores");
        for(MiembroEnGrupo i : grupoMiembro){
            if(i.getGrupos().equals(g)){
                superAdmin = true;
//                System.out.println(this.apellidos + this.nombres +" ES SUPER ADMINISTRADOR");
            }
            else{
                superAdmin = false;
//                System.out.println(this.apellidos + this.nombres +" NO ES SUPER ADMINISTRADOR");
            }
        }
        return superAdmin;
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

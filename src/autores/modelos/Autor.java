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
import java.util.List;


/**
 *
 * @author Windows 10
 */
public abstract class Autor implements Comparable<Autor>{
    private String nombres;
    private String apellidos;
    private String clave;
    private int dni;
    
    private List<MiembroEnGrupo> grupoMiembro = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();

    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }   

    public String verNombres() {
        return this.nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verApellidos() {
        return this.apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verClave() {
        return this.clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public int verDni() {
        return this.dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }
       
    public void agregarGrupo(Grupo g, Rol r){
        MiembroEnGrupo m = new MiembroEnGrupo(this, g, r);
        if(!grupoMiembro.contains(m)){
            if(g.esSuperAdministradores() == true){
                MiembroEnGrupo m1 = new MiembroEnGrupo(this, g, Rol.ADMINISTRADOR);
                this.grupoMiembro.add(m1);
                this.grupos.add(g);
            }
            else{
                this.grupoMiembro.add(m);
                this.grupos.add(g);
            }
        g.agregarMiembro(this, r);
        }
    }
     
    public void quitarGrupo (Grupo grupo){
        MiembroEnGrupo m = new MiembroEnGrupo(this, grupo , null);
        if(grupoMiembro.contains(m)){
            int pos = grupoMiembro.indexOf(m);
        grupoMiembro.remove(pos);
        this.grupos.remove(grupo);
        grupo.quitarMiembro(this);
        }
    }
    public void mostrar(){
        System.out.println("--------AUTOR--------");
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        this.mostrar(1, 1, 1);
    }
    public void mostrar(String u){
        System.out.println("Autor: " + this.apellidos.toUpperCase() + ", " + this.nombres);
        System.out.println("DNI: " + this.dni);
    }
    
    
    public void mostrar(int x, int y, int z){
        if(!grupoMiembro.isEmpty()){
            System.out.println("\nGrupos a los que pertenece: \n" );
            for(MiembroEnGrupo i : grupoMiembro){
                i.mostrar2();
            }
        }
    }
    
    public List<MiembroEnGrupo> verGrupos(){
//        for(MiembroEnGrupo i : grupoMiembro){
//            i.mostrar2();
//        }
        return grupoMiembro;
    }
    
    public List<Grupo> verListaGrupos(){
//        for(MiembroEnGrupo i : grupoMiembro){
//            i.mostrar2();
//        }
        return grupos;
    }
    
    public boolean esSuperAdministrador(){
        boolean superAdmin = false;
        Grupo g = new Grupo("Super Administradores", "Grupo para los super administradores");
        for(MiembroEnGrupo i : grupoMiembro){
            if(i.verGrupos().equals(g)){
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

    @Override
    public int compareTo(Autor a) {
        if(this.nombres.compareTo(a.nombres)==0)
            return this.apellidos.compareTo(a.apellidos);
        else 
            return this.nombres.compareTo(a.nombres);
    }

    
    
}

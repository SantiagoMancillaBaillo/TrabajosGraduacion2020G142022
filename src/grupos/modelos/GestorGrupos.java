/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorGrupos implements IGestorGrupos{
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private static GestorGrupos instanciaGrupos;

    public GestorGrupos() {
        
    }
    
    public static GestorGrupos crear(){
        if(instanciaGrupos == null)
            instanciaGrupos = new GestorGrupos();
        return instanciaGrupos;
    }
    
    

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        Grupo g = new Grupo (nombre, descripcion);
        if ((nombre != null && !nombre.isBlank()) && (descripcion != null && !descripcion.isBlank())){
            if(existeEsteGrupo(g) == false){
                this.grupos.add(g);
                return GMENSAJE_EXITO;
            }
            else{
                return GMENSAJE_REPETIDO;
            }
        }
        else
            return GMENSAJE_ERROR;
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        if(descripcion != null && !descripcion.isBlank()){
            if(existeEsteGrupo(grupo) == true){
                Grupo g = new Grupo (grupo.verNombre(), descripcion);
                grupos.set(grupos.indexOf(grupo), g);
                return GmodMENSAJE_EXITO;
            }
            else{
                return GmodMENSAJE_NO_EXISTE;
            }
        }
        else
            return GmodMENSAJE_ERROR;
    }

    @Override
    public ArrayList<Grupo> verGrupos() {
        System.out.println("--------------GRUPOS--------------");
        for(Grupo g : grupos){
            g.mostrar();
        }
        return grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        if(nombre != null && !nombre.isBlank()){
        Grupo gr = new Grupo (nombre, null);
        for(Grupo g : grupos){
                if(gr.verNombre().equals(g.verNombre())){
                    System.out.println("GRUPO ENCONTRADO:" + g.verNombre());
                    g.mostrar();
                    return g;
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        boolean existe = false;
        if(grupos.contains(grupo)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }
    
}

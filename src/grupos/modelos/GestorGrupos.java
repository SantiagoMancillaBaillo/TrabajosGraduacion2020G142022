/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class GestorGrupos implements IGestorGrupos{
    private List<Grupo> grupos = new ArrayList<>();
    private List<Grupo> grupos2 = new ArrayList<>();
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
    public List<Grupo> verGrupos() {
        System.out.println("--------------GRUPOS--------------");
        Collections.sort(grupos);
        for(Grupo g : grupos){
            g.mostrar();
        }
        return grupos;
    }
    
    public List<Grupo> verListaGrupos() {
        Collections.sort(grupos);
        return grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        if(nombre != null && !nombre.isBlank()){
        for(Grupo g : grupos){
                if(nombre.equals(g.verNombre())){
//                    System.out.println("GRUPO ENCONTRADO:" + g.verNombre());
//                    g.mostrar();
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

    @Override
    public String borrarGrupo(Grupo grupo) {
        IGestorAutores ga = GestorAutores.crear();
        if(existeEsteGrupo(grupo) && ga.hayAutoresConEsteGrupo(grupo)){
            return GborrarMENSAJE_ERROR;
        }
        if(existeEsteGrupo(grupo) && !ga.hayAutoresConEsteGrupo(grupo)){
            this.grupos.remove(grupo);
            return GborrarMENSAJE_EXITO;
        }
        else
            return GborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<Grupo> buscarGrupos(String nombre) {
        this.grupos2.clear();
        if(nombre == null || nombre.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Grupo g : grupos){
                if(g.verNombre().contains(nombre)){
                    grupos2.add(g);
                }
                else{
                  System.out.println("No se encontró Tipo con ese nombre");  
                }
            }
            Collections.sort(this.grupos2);
            for(Grupo g : grupos2){
                g.mostrar();
            }
            
        }
        return grupos2;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Windows 10
 */
public class GestorTipos implements IGestorTipos {
    private List<Tipo> tipos = new ArrayList<>();
    private List<Tipo> tipos2 = new ArrayList<>();
    private static GestorTipos instanciaTipos;

    public GestorTipos() {
        
    }
    
    public static GestorTipos crear(){
        if(instanciaTipos == null)
            instanciaTipos = new GestorTipos();
        return instanciaTipos;
    }
    
    @Override
    public String nuevoTipo(String nombre){
        if (nombre != null && !nombre.isBlank()){
            Tipo t = new Tipo(nombre);
            if(!this.tipos.contains(t)){
                this.tipos.add(t);
                return TMENSAJE_EXITO;
            }
            else{
                return TMENSAJE_REPETIDO;
            }
        }
        else
            return TMENSAJE_ERROR;
    }
    
    @Override
    public List<Tipo> verTipos(){
//        System.out.println("--------------TIPOS--------------");
        Collections.sort(this.tipos);
//        for (Tipo t : tipos){
//            System.out.println(t);
//        }
        return tipos;
    }
    
    @Override
    public Tipo verTipo(String nombre){
        for(Tipo t : tipos){
            if(nombre.equals(t.verTipo())){
//                System.out.println("TIPO ENCONTRADO");
//                System.out.println(t);
                return t;
            }
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        if(existeEsteTipo(tipo) == true && (gp.hayPublicacionesConEsteTipo(tipo) == true)){
                return TborrarMENSAJE_ERROR;
        }
        if(existeEsteTipo(tipo) == true && (gp.hayPublicacionesConEsteTipo(tipo) == false)){
            this.tipos.remove(tipo);
            return TborrarMENSAJE_EXITO;
        }
        else
            return TborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<Tipo> buscarTipos(String nombre){
        this.tipos2.clear();
        if(nombre == null || nombre.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Tipo t : tipos){
                if(t.verTipo().contains(nombre)){
                    tipos2.add(t);
                }
                else{
                  System.out.println("No se encontró Tipo con ese nombre");  
                }
            }
            Collections.sort(this.tipos2);
            for(Tipo t : tipos2){
                System.out.println(t);
            }
            
        }
        return tipos2;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        boolean existe = false;
        if(tipos.contains(tipo)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }
    
    
}

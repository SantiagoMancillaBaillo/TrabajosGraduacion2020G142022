/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorTipos implements IGestorTipos {
    private ArrayList<Tipo> tipos = new ArrayList<>();
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
    public ArrayList<Tipo> verTipos(){
        System.out.println("--------------TIPOS--------------");
        for (Tipo t : tipos){
            System.out.println(t);
        }
        return tipos;
    }
    
    @Override
    public Tipo verTipo(String nombre){
        Tipo ti = new Tipo(nombre);
        for(Tipo t : tipos){
            if(ti.verTipo().equals(t.verTipo())){
                System.out.println("TIPO ENCONTRADO");
                System.out.println(t);
                return t;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorLugares implements IGestorLugares{
    private ArrayList<Lugar> lugares = new ArrayList<>();
    private static GestorLugares instanciaLugares;

    public GestorLugares() {
        
    }
    
    public static GestorLugares crear(){
        if(instanciaLugares == null)
            instanciaLugares = new GestorLugares();
        return instanciaLugares;
    }

    @Override
    public String nuevoLugar(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            Lugar l = new Lugar(nombre);
            if(!this.lugares.contains(l)){
                this.lugares.add(l);
                return LMENSAJE_EXITO;
            }
            else{
                return LMENSAJE_REPETIDO;
            }
        }
        else
            return LMENSAJE_ERROR;
    }

    @Override
    public ArrayList<Lugar> verLugares() {
        System.out.println("--------------LUGARES--------------");
        for (Lugar l : lugares){
            System.out.println(l);
        }
        return lugares;
    }

    @Override
    public Lugar verLugar(String nombre) {
        Lugar lu = new Lugar(nombre);
        for(Lugar l : lugares){
            if(lu.verLugar().equals(l.verLugar())){
                System.out.println("LUGAR ENCONTRADO");
                System.out.println(l);
                return l;
            }
        }
        return null;
    }
    
}

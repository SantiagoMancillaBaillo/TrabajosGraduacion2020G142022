/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Windows 10
 */
public class GestorLugares implements IGestorLugares{
    private List<Lugar> lugares = new ArrayList<>();
    private List<Lugar> lugares2 = new ArrayList<>();
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
    public List<Lugar> verLugares() {
        System.out.println("--------------LUGARES--------------");
        Collections.sort(lugares);
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
//                System.out.println("LUGAR ENCONTRADO");
//                System.out.println(l);
                return l;
            }
        }
        return null;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        if(existeEsteLugar(lugar) == true && (gp.hayPublicacionesConEsteLugar(lugar) == true)){
                return LborrarMENSAJE_ERROR;
        }
        if(existeEsteLugar(lugar) == true && (gp.hayPublicacionesConEsteLugar(lugar) == false)){
            this.lugares.remove(lugar);
            return LborrarMENSAJE_EXITO;
        }
        else
            return LborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        this.lugares2.clear();
        if(nombre == null || nombre.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Lugar l : lugares){
                if(l.verLugar().contains(nombre)){
                    lugares2.add(l);
                }
                else{
                    System.out.println("No se encontró Palabra Clave con ese nombre");
                }
            }
            Collections.sort(lugares2);
            for(Lugar l : lugares2){
                System.out.println(l);
            }
        }
        return lugares2;
    }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        boolean existe = false;
        if(this.lugares.contains(lugar)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }
    
    
    
}

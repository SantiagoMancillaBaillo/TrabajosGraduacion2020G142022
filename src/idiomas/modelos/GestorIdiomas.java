/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Windows 10
 */
public class GestorIdiomas implements IGestorIdiomas{
    private List<Idioma> idiomas = new ArrayList<>();
    private List<Idioma> idiomas2 = new ArrayList<>();
    private static GestorIdiomas instanciaIdiomas;

    public GestorIdiomas() {
        
    }
    
    public static GestorIdiomas crear(){
        if(instanciaIdiomas == null)
            instanciaIdiomas = new GestorIdiomas();
        return instanciaIdiomas;
    }
    
    
    

    @Override
    public String nuevoIdioma(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            Idioma i = new Idioma(nombre);
            if(!this.idiomas.contains(i)){
                this.idiomas.add(i);
                return IMENSAJE_EXITO;
            }
            else{
                return IMENSAJE_REPETIDO;
            }
        }
        else
            return IMENSAJE_ERROR;
    }

    @Override
    public List<Idioma> verIdiomas() {
        System.out.println("--------------IDIOMAS--------------");
        Collections.sort(idiomas);
        for (Idioma i : idiomas){
            System.out.println(i);
        }
        return idiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        Idioma id = new Idioma(nombre);
        for(Idioma i : idiomas){
            if(id.verIdioma().equals(i.verIdioma())){
//                System.out.println("IDIOMA ENCONTRADO");
//                System.out.println(i);
                return i;
            }
        }
        return null;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        if(existeEsteIdioma(idioma) == true && (gp.hayPublicacionesConEsteIdioma(idioma) == true)){
                return IborrarMENSAJE_ERROR;
        }
        if(existeEsteIdioma(idioma) == true && (gp.hayPublicacionesConEsteIdioma(idioma) == false)){
            this.idiomas.remove(idioma);
            return IborrarMENSAJE_EXITO;
        }
        else
            return IborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        this.idiomas2.clear();
        if(nombre == null || nombre.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Idioma i : idiomas){
                if(i.verIdioma().contains(nombre)){
                    this.idiomas2.add(i);
                }
            }
            Collections.sort(this.idiomas2);
            for(Idioma i : idiomas2){
                i.mostrar();
            }
            
        }
        return idiomas2;
    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
        boolean existe  = false;
        if(idiomas.contains(idioma)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }
    
    
    
}

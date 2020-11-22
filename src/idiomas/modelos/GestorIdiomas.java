/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorIdiomas implements IGestorIdiomas{
    private ArrayList<Idioma> idiomas = new ArrayList<>();
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
    public ArrayList<Idioma> verIdiomas() {
        System.out.println("--------------IDIOMAS--------------");
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
                System.out.println("IDIOMA ENCONTRADO");
                System.out.println(i);
                return i;
            }
        }
        return null;
    }
    
}

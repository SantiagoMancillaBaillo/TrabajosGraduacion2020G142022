/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves{
    private ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
    private static GestorPalabrasClaves instanciaPalabrasClaves;


    public GestorPalabrasClaves() {
        
    }
    
    public static GestorPalabrasClaves crear(){
        if(instanciaPalabrasClaves == null)
            instanciaPalabrasClaves = new GestorPalabrasClaves();
        return instanciaPalabrasClaves;
    }

    @Override
    public String nuevaPalabraClave(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            PalabraClave pc = new PalabraClave(nombre);
            if(!this.palabrasClaves.contains(pc)){
                this.palabrasClaves.add(pc);
                return PMENSAJE_EXITO;
            }
            else{
                return PMENSAJE_REPETIDO;
            }
        }
        else
            return PMENSAJE_ERROR;
    }

    @Override
    public ArrayList<PalabraClave> verPalabrasClaves() {
        System.out.println("--------------PALABRAS CLAVE--------------");
        for (PalabraClave pc : palabrasClaves){
            System.out.println(pc);
        }
        return palabrasClaves;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        PalabraClave palc = new PalabraClave(nombre);
        for(PalabraClave pc : palabrasClaves){
            if(palc.verPalabraClave().equals(pc.verPalabraClave())){
                System.out.println("PALABRA CLAVE ENCONTRADA");
                System.out.println(pc);
                return pc;
            }
        }
        return null;
    }
    
}

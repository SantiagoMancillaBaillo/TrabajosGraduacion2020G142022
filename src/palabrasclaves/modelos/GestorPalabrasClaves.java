/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Windows 10
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves{
    private List<PalabraClave> palabrasClaves = new ArrayList<>();
    private List<PalabraClave> palabrasClaves2 = new ArrayList<>();
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
    public List<PalabraClave> verPalabrasClaves() {
        System.out.println("--------------PALABRAS CLAVE--------------");
        Collections.sort(palabrasClaves);
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
//                System.out.println("PALABRA CLAVE ENCONTRADA");
//                System.out.println(pc);
                return pc;
            }
        }
        return null;
    }

    @Override
    public String borrarPalabraClave(PalabraClave palabraClave) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        if(existeEstaPalabraClave(palabraClave) == true && (gp.hayPublicacionesConEstaPalabraClave(palabraClave) == true)){
                return PborrarMENSAJE_ERROR;
        }
        if(existeEstaPalabraClave(palabraClave) == true && (gp.hayPublicacionesConEstaPalabraClave(palabraClave) == false)){
            this.palabrasClaves.remove(palabraClave);
            return PborrarMENSAJE_EXITO;
        }
        else
            return PborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        this.palabrasClaves2.clear();
        if(nombre == null || nombre.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(PalabraClave pc : palabrasClaves){
                if(pc.verPalabraClave().contains(nombre)){
                    palabrasClaves2.add(pc);
                }
                else{
                    System.out.println("No se encontró Palabra Clave con ese nombre");
                }
            }
            Collections.sort(palabrasClaves2);
            for(PalabraClave pc : palabrasClaves2){
                System.out.println(pc);
            }
        }
        return palabrasClaves2;
    }

    @Override
    public boolean existeEstaPalabraClave(PalabraClave palabraClave) {
        boolean existe = false;
        if(palabrasClaves.contains(palabraClave)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }
    
    
    
}

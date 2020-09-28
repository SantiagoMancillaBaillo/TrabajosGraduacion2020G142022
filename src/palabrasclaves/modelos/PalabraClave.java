/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

/**
 *
 * @author Windows 10
 */
public class PalabraClave {
    private String nombre;
    
    public PalabraClave (String nombre){
        this.nombre = nombre;
    }
    
    public String verPalabraClave(){
        return nombre;
    }
    public void asignarPalabraClave(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "\nPalabraClave: " + nombre ;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

/**
 *
 * @author Windows 10
 */
public class Lugar {
    private String nombre;
    
    public Lugar(String nombre){
        this. nombre = nombre;
    }
    
    public String verLugar(){
        return nombre;
    }
    public void asignarLugar(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "\nLugar: " + nombre ;
    }
}

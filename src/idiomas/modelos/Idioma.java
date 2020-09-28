/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

/**
 *
 * @author Windows 10
 */
public class Idioma {
    private String nombre;
    
    public Idioma (String nombre){
        this.nombre = nombre;
    }
    
    public String verIdioma(){
        return nombre;
    }
    public void asignarIdioma(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "\nIdioma: " + nombre ;
    }
    
}

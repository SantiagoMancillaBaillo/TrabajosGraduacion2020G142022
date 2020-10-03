/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargos.modelos;

/**
 *
 * @author Windows 10
 */
public enum Cargo {
    TITULAR ("Titular"),
    ASOCIADO ("Asociado"),
    ADJUNTO ("Adjunto"),
    JTP ("Jefe de Trabajos Practicos"),
    ADG ("Aux. Docente Graduado");
    
    private String valor;

    private Cargo(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import autores.modelos.Cargo;
import interfaces.IGestorIdiomas;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Windows 10
 */
public class ModeloComboIdiomas extends DefaultComboBoxModel {

    public ModeloComboIdiomas() {
        IGestorIdiomas gi = GestorIdiomas.crear();
        for(Idioma idioma : gi.verIdiomas())
            this.addElement(idioma);
    }
    
    public Idioma obtenerIdioma(){
        return (Idioma)this.getSelectedItem();
    }
    
    public void seleccionarIdioma(Idioma idioma){
        this.setSelectedItem(idioma);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Windows 10
 */
public class ModeloComboTipos extends DefaultComboBoxModel {

    public ModeloComboTipos() {
        IGestorTipos gt = GestorTipos.crear();
        for(Tipo tipo : gt.verTipos())
            this.addElement(tipo);
    }
    
    public Tipo obtenerTipo(){
        return (Tipo)this.getSelectedItem();
    }
    
    public void seleccionarTipo(Tipo tipo){
        this.setSelectedItem(tipo);
    }
    
}

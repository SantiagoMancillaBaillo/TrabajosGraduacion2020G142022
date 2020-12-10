/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Windows 10
 */
public class ModeloComboLugares extends DefaultComboBoxModel {

    public ModeloComboLugares() {
        IGestorLugares gl = GestorLugares.crear();
        for(Lugar lugar : gl.verLugares())
            this.addElement(lugar);
    }
    
    public Lugar obtenerLugar(){
        return (Lugar)this.getSelectedItem();
    }
    
    public void seleccionarLugar(Lugar lugar){
        this.setSelectedItem(lugar);
    }
    
}

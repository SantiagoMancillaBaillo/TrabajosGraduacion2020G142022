/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Windows 10
 */
public class ModeloComboGrupos extends DefaultComboBoxModel {

    public ModeloComboGrupos() {
        IGestorGrupos gg = GestorGrupos.crear();
        for(Grupo grupo : gg.verGrupos())
            if(grupo.tieneMiembros()){
                this.addElement(grupo.verNombre());
            }
    }
    
    public String obtenerGrupo(){
        return (String)this.getSelectedItem();
    }
    
    public void seleccionarIdioma(Grupo grupo){
        this.setSelectedItem(grupo);
    }
    
}

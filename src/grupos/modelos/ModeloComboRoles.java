  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Windows 10
 */
public class ModeloComboRoles extends DefaultComboBoxModel{

    public ModeloComboRoles() {
        for (Rol rol : Rol.values())
            this.addElement(rol);
    }
    
    public Rol obtenerRol(){
        return (Rol)this.getSelectedItem();
    }
    
    public void seleccionarRol(Rol rol){
        this.setSelectedItem(rol);
    }
    
    
    
}

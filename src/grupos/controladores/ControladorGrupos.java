/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaGrupos;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorGrupos;
import interfaces.IGestorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author Windows 10
 */
public class ControladorGrupos implements IControladorGrupos{
    private VentanaGrupos ventana;
    private VentanaPrincipal ventanaPrincipal;

    public ControladorGrupos() {
        this.ventana = new VentanaGrupos(this, ventanaPrincipal, true);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaGrupos().setModel(new ModeloTablaGrupos());
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        if(mtg.getRowCount() == 0){
            this.ventana.getBtnModificar().setEnabled(false);
            this.ventana.getBtnBorrar().setEnabled(false);
        }
        this.ventana.setVisible(true);
    }
    
    public void tablavacia(){
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        if(mtg.getRowCount() == 0){
            this.ventana.getBtnModificar().setEnabled(false);
            this.ventana.getBtnBorrar().setEnabled(false);
        }
        else{
            this.ventana.getBtnModificar().setEnabled(true);
            this.ventana.getBtnBorrar().setEnabled(true);
        }
    }
    
    

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMGrupo cg = new ControladorAMGrupo();
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        this.tablavacia();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if(this.ventana.getTablaGrupos().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "No seleccionó ningun Grupo para ser modificado");
        }
        else{
            ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
            Grupo gr = mtg.verGrupo(this.ventana.getTablaGrupos().getSelectedRow());
            IControladorAMGrupo cgr = new ControladorAMGrupo(String.valueOf(gr.verNombre()), String.valueOf(gr.verDescripcion()));
//            IControladorAMGrupo cgr = new ControladorAMGrupo(gr);
            mtg.actualizar();
            this.tablavacia();
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if(this.ventana.getTablaGrupos().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "No seleccionó ningun Grupo para ser borrado");
        }
        else{
            int opcion= JOptionPane.showOptionDialog(null, "¿Desea BORRAR al grupo seleccionado?", "Grupos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí","No"}, this);
            if(opcion == JOptionPane.YES_OPTION){
                ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
                Grupo gr = mtg.verGrupo(this.ventana.getTablaGrupos().getSelectedRow());
                IGestorGrupos gg = GestorGrupos.crear();
                gg.borrarGrupo(gr);
                mtg.actualizar();
                this.tablavacia();   
            }
            else
                ventana.getTxtGrupos().requestFocus();
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        int opcion= JOptionPane.showOptionDialog(ventana, "¿Desea volver a la Ventana Principal?", "Grupos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí","No"}, this);
        if(opcion == JOptionPane.YES_OPTION)
        {
            this.ventana.dispose();
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String nombre = this.ventana.getTxtGrupos().getText();
            ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
            mtg.mostrarGrupos(nombre);
            this.ventana.getTxtGrupos().setText(null);
            this.ventana.getTxtGrupos().requestFocus();
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.requestFocus();
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        mtg.actualizar();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }
    
}

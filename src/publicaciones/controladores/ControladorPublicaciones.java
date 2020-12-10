/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPublicaciones;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloTablaPublicaciones;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaPublicaciones;

/**
 *
 * @author Windows 10
 */
public class ControladorPublicaciones implements IControladorPublicaciones{
    private VentanaPublicaciones ventana;
    private VentanaPrincipal ventanaPrincipal;
    
    public ControladorPublicaciones() {
        this.ventana = new VentanaPublicaciones(this, ventanaPrincipal, true);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaPublicaciones().setModel(new ModeloTablaPublicaciones());
        ModeloTablaPublicaciones mtg = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        if(mtg.getRowCount() == 0){
            this.ventana.getBtnModificar().setEnabled(false);
            this.ventana.getBtnBorrar().setEnabled(false);
            this.ventana.getBtnBuscar().setEnabled(false);
            this.ventana.getTxtTitulo().setEditable(false);
        }
        this.ventana.setVisible(true);
    }
    
    public void tablavacia(){
        ModeloTablaPublicaciones mtg = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        if(mtg.getRowCount() == 0){
            this.ventana.getBtnModificar().setEnabled(false);
            this.ventana.getBtnBorrar().setEnabled(false);
            this.ventana.getBtnBuscar().setEnabled(false);
            this.ventana.getTxtTitulo().setEditable(false);
        }
        else{
            this.ventana.getBtnModificar().setEnabled(true);
            this.ventana.getBtnBorrar().setEnabled(true);
            this.ventana.getBtnBuscar().setEnabled(true);
            this.ventana.getTxtTitulo().setEditable(true);
        }
    }

    @Override
    public void btnNuevaClic(ActionEvent evt) {
        IControladorAMPublicacion controlador = new ControladorAMPublicacion();
        ModeloTablaPublicaciones mtg = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        mtg.actualizar();
        this.tablavacia();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if(this.ventana.getTablaPublicaciones().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "No seleccionó ninguna Publicación para ser modificada");
        }
        else{
            ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
            Publicacion p = mtp.verPublicacion(this.ventana.getTablaPublicaciones().getSelectedRow());
            IControladorAMPublicacion camp = new ControladorAMPublicacion(p.verTitulo());
            mtp.actualizar();
            this.tablavacia();
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if(this.ventana.getTablaPublicaciones().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "No seleccionó ninguna Publicación para ser modificada");
        }
        else{
            ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
            Publicacion p = mtp.verPublicacion(this.ventana.getTablaPublicaciones().getSelectedRow());
            IGestorPublicaciones gp = GestorPublicaciones.crear();
            gp.borrarPublicacion(p);
            mtp.actualizar();
            this.tablavacia();
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        int opcion= JOptionPane.showOptionDialog(ventana, "¿Desea volver a la Ventana Principal?", "Publicaciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí","No"}, this);
        if(opcion == JOptionPane.YES_OPTION)
        {
            this.ventana.dispose();
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String titulo = this.ventana.getTxtTitulo().getText();
        ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        mtp.mostrarPublicaciones(titulo);
        this.ventana.getTxtTitulo().setText(null);
        this.ventana.getTxtTitulo().requestFocus();
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.requestFocus();
        ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        mtp.actualizar();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaMiembros;
import grupos.vistas.VentanaAMGrupo;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IGestorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import interfaces.IControladorModificarMiembros;

/**
 *
 * @author Windows 10
 */
public class ControladorAMGrupo implements IControladorAMGrupo{
    private VentanaAMGrupo ventana;
    private VentanaGrupos ventanaGrupos;

    public ControladorAMGrupo() {
        this.ventana = new VentanaAMGrupo(this, ventanaGrupos, true);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaMiembros().setModel(new ModeloTablaMiembros());
        this.ventana.getBtnModificar().setEnabled(false);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMGrupo(String nombre, String descripcion) {
        IGestorGrupos gg = GestorGrupos.crear();
        this.ventana = new VentanaAMGrupo(this, ventanaGrupos, true);
        this.ventana.setTitle(TITULO_MODIFICAR);
        this.ventana.getTxtNombre().setEditable(false);
        this.ventana.getTxtNombre().setText(gg.verGrupo(nombre).verNombre());
        this.ventana.getTablaMiembros().setModel(new ModeloTablaMiembros(gg.verGrupo(nombre)));
        this.ventana.getTxtDescripcion().setText(gg.verGrupo(nombre).verDescripcion());
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true); 
    }
    
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String nombre = this.ventana.getTxtNombre().getText();
        String descripcion = this.ventana.getTxtDescripcion().getText().trim();
        if(nombre!=null && !nombre.isBlank() && descripcion!=null && !descripcion.isBlank()) {
            IGestorGrupos gg = GestorGrupos.crear();
            if(ventana.getTxtNombre().isEditable()){
                gg.nuevoGrupo(nombre, descripcion);
                this.ventana.dispose();
            }
            else{
                if(!ventana.getTxtNombre().isEditable()){
                    gg.modificarGrupo(gg.verGrupo(nombre), descripcion);
                    JOptionPane.showMessageDialog(ventana, "Grupo Modificado con Éxito!");
                    ModeloTablaMiembros mta = (ModeloTablaMiembros)this.ventana.getTablaMiembros().getModel();
                    mta.actualizar(gg.verGrupo(nombre));
                    this.ventana.dispose();
                    
                    }
                }
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        ModeloTablaMiembros mta = (ModeloTablaMiembros)this.ventana.getTablaMiembros().getModel();
        String nombre = this.ventana.getTxtNombre().getText().trim();
        String descripcion = this.ventana.getTxtDescripcion().getText().trim();
        IGestorGrupos gg = GestorGrupos.crear();
        mta.actualizar(gg.verGrupo(nombre));
        IControladorModificarMiembros cmm = new ControladorModificarMiembros(gg.verGrupo(nombre));
        mta.actualizar(gg.verGrupo(nombre));
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.requestFocus();
//        ModeloTablaMiembros mta = (ModeloTablaMiembros)this.ventana.getTablaMiembros().getModel();
//        mta.actualizar();
    }
    
}

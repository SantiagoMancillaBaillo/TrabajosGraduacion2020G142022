/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.vistas.ModeloComboCargos;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10
 */
public class ControladorAMProfesor implements IControladorAMProfesor{
    private VentanaAMProfesor ventana;
    
    
    public ControladorAMProfesor(){    
            this.ventana = new VentanaAMProfesor(this, null, true);
            this.ventana.setTitle(TITULO_NUEVO);
            this.ventana.getComboCargo().setModel(new ModeloComboCargos());
            this.ventana.setLocationRelativeTo(null);
            this.ventana.setVisible(true);
    }
    
    public ControladorAMProfesor(String dni){
            this.ventana = new VentanaAMProfesor(this, null, true);
            this.ventana.setTitle(TITULO_MODIFICAR);
            this.ventana.getComboCargo().setModel(new ModeloComboCargos());
            this.ventana.getTxtDNI().setEditable(false);
            this.ventana.getTxtDNI().setText(dni);
            this.ventana.setLocationRelativeTo(null);
            this.ventana.setVisible(true);
            
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        int dni = 0;
        if (!this.ventana.getTxtDNI().getText().trim().isEmpty())
            dni = Integer.parseInt(this.ventana.getTxtDNI().getText().trim());
        String apellidos = this.ventana.getTxtApellidos().getText().trim();
        String nombres = this.ventana.getTxtNombres().getText().trim();
        Cargo cargo = ((ModeloComboCargos)this.ventana.getComboCargo().getModel()).obtenerCargo();
        String clave = new String(this.ventana.getPassClave().getPassword());
        String claverep = new String(this.ventana.getPassClaveRepetida().getPassword());
        if(apellidos!=null&&!apellidos.isBlank()&&dni>0&&nombres!=null&&!nombres.isBlank()&&!clave.isBlank()) {
        if(!clave.equals(claverep)){
            JOptionPane.showMessageDialog(ventana, "Las claves no coinciden");
            ventana.getPassClave().setText(null);
            ventana.getPassClaveRepetida().setText(null);
        }
        else{
            IGestorAutores ga = GestorAutores.crear();
            if(ventana.getTxtDNI().isEditable()){
            ga.nuevoAutor(dni, apellidos, nombres, cargo, clave, claverep);
            this.setAllTextFieldsToNull();
            }
            else{
                if(!ventana.getTxtDNI().isEditable()){
                    ga.modificarAutor(ga.verAutor(dni), apellidos, nombres, cargo, clave, claverep);
                    JOptionPane.showMessageDialog(ventana, "Autor Modificado con Éxito!");
                    this.ventana.dispose();
                    }
                }
        
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Hay un campo inválido");
            this.setAllTextFieldsToNull();
        }
    }
    
    private void setAllTextFieldsToNull(){
        ventana.getTxtDNI().setText(null);
        ventana.getTxtApellidos().setText(null);
        ventana.getTxtNombres().setText(null);
        ventana.getPassClave().setText(null);
        ventana.getPassClaveRepetida().setText(null);
        ventana.getTxtDNI().requestFocus();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcion= JOptionPane.showOptionDialog(null, "¿Desea terminar?", "Profesor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí","No"}, this);
        if(opcion == JOptionPane.YES_OPTION)
        {
            ventana.dispose();
        }
        else
            ventana.getTxtDNI().requestFocus();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isDigit(c))
            evt.consume();
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c)){
            evt.consume();
            JOptionPane.showMessageDialog(ventana, "No se permiten Espacios en Blanco");
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c)){
            evt.consume();
            JOptionPane.showMessageDialog(ventana, "No se permiten Espacios en Blanco");
        }
    }
    
}

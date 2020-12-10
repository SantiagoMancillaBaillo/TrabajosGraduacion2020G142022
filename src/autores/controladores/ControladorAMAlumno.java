/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaGruposMiembro;
import autores.vistas.ModeloComboCargos;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAMAlumno;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10
 */
public class ControladorAMAlumno implements IControladorAMAlumno {
    private VentanaAMAlumno ventana;
    private VentanaAutores ventanaAutores;
    private Alumno alum;
    
    public ControladorAMAlumno(){    
            this.ventana = new VentanaAMAlumno(this, ventanaAutores, true);
            this.ventana.setTitle(TITULO_NUEVO);
            this.ventana.getTablaGruposMiembro().setModel(new ModeloTablaGruposMiembro());
            this.ventana.setLocationRelativeTo(null);
            this.ventana.setVisible(true);
    }
    
    public ControladorAMAlumno(Alumno a){
            alum = a;
            IGestorAutores ga = GestorAutores.crear();
            this.ventana = new VentanaAMAlumno(this, ventanaAutores, true);
            this.ventana.setTitle(TITULO_MODIFICAR);
            this.ventana.getTxtDNI().setEditable(false);
            this.ventana.getTxtDNI().setText(String.valueOf(a.verDni()));
            this.ventana.getTxtNombres().setText(a.verNombres());
            this.ventana.getTxtApellidos().setText(a.verApellidos());
            this.ventana.getTxtCX().setText(a.verCx());
            this.ventana.getPassClave().setText(a.verClave());
            this.ventana.getPassRepetirClave().setText(a.verClave());
            this.ventana.getTablaGruposMiembro().setModel(new ModeloTablaGruposMiembro(alum));
            ModeloTablaGruposMiembro mtgp = (ModeloTablaGruposMiembro)this.ventana.getTablaGruposMiembro().getModel();
            mtgp.actualizar(a);
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
        String cx = this.ventana.getTxtCX().getText().trim();
        String clave = new String(this.ventana.getPassClave().getPassword());
        String claverep = new String(this.ventana.getPassRepetirClave().getPassword());
        if(apellidos!=null&&!apellidos.isBlank()&&dni>0&&nombres!=null&&!nombres.isBlank()&&!clave.isBlank()&&cx!=null&&!cx.isBlank()) {
        if(!clave.equals(claverep)){
            JOptionPane.showMessageDialog(ventana, "Las claves no coinciden");
            ventana.getPassClave().setText(null);
            ventana.getPassRepetirClave().setText(null);
        }
        else{
            IGestorAutores ga = GestorAutores.crear();
            if(ventana.getTxtDNI().isEditable()){
                ga.nuevoAutor(dni, apellidos, nombres, cx, clave, claverep);
                this.ventana.dispose();
            }
            else{
                if(!ventana.getTxtDNI().isEditable()){
                    ga.modificarAutor(ga.verAutor(dni), apellidos, nombres, cx, clave, claverep);
                    JOptionPane.showMessageDialog(ventana, "Autor Modificado con Éxito!");
                    this.ventana.dispose();
                    }
                }
        
            }
        }
        else {
            JOptionPane.showMessageDialog(ventana, "Hay un campo inválido");
            if(!ventana.getTxtDNI().isEditable()){
                ventana.getTxtApellidos().requestFocus();
            }
            else{
                ventana.getTxtDNI().requestFocus();
            }
        }
    }

    private void setAllTextFieldsToNull(){
        ventana.getTxtDNI().setText(null);
        ventana.getTxtApellidos().setText(null);
        ventana.getTxtNombres().setText(null);
        ventana.getTxtCX().setText(null);
        ventana.getPassClave().setText(null);
        ventana.getPassRepetirClave().setText(null);
        ventana.getTxtDNI().requestFocus();
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
            this.ventana.dispose();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            evt.consume();
        }
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            evt.consume();
        }
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }

    @Override
    public void txtCXPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetterOrDigit(c)){
            evt.consume();
        }
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

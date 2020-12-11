/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaGruposMiembro;
import autores.modelos.Profesor;
import autores.vistas.ModeloComboCargos;
import autores.vistas.VentanaAMProfesor;
import autores.vistas.VentanaAutores;
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
    private VentanaAutores ventanaAutores;
    private Profesor prof;
    
    
    public ControladorAMProfesor(){    
            this.ventana = new VentanaAMProfesor(this, ventanaAutores, true);
            this.ventana.setTitle(TITULO_NUEVO);
            this.ventana.getComboCargo().setModel(new ModeloComboCargos());
            this.ventana.getTablaGruposMiembro().setModel(new ModeloTablaGruposMiembro());
            this.ventana.getTxtDNI().requestFocus();
            this.ventana.setLocationRelativeTo(null);
            this.ventana.setVisible(true);
    }
    
    public ControladorAMProfesor(Profesor p){
            prof = p;
            IGestorAutores ga = GestorAutores.crear();
            this.ventana = new VentanaAMProfesor(this, ventanaAutores, true);
            this.ventana.setTitle(TITULO_MODIFICAR);
            this.ventana.getComboCargo().setModel(new ModeloComboCargos());
            this.ventana.getTxtDNI().setEditable(false);
            this.ventana.getTxtDNI().setText(String.valueOf(p.verDni()));
            this.ventana.getTxtNombres().setText(p.verNombres());
            this.ventana.getTxtApellidos().setText(p.verApellidos());
            this.ventana.getTxtApellidos().requestFocus();
            this.ventana.getComboCargo().setSelectedItem(p.verCargo());
            this.ventana.getPassClave().setText(p.verClave());
            this.ventana.getPassClaveRepetida().setText(p.verClave());
            this.ventana.getTablaGruposMiembro().setModel(new ModeloTablaGruposMiembro(prof));
            ModeloTablaGruposMiembro mtgp = (ModeloTablaGruposMiembro)this.ventana.getTablaGruposMiembro().getModel();
            mtgp.actualizar(p);
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
        IGestorAutores ga = GestorAutores.crear();
        if(apellidos!=null&&!apellidos.isBlank()&&dni>0&&nombres!=null&&!nombres.isBlank()&&!clave.isBlank()) {
        if(!clave.equals(claverep)){
            JOptionPane.showMessageDialog(ventana, "Las claves no coinciden");
            ventana.getPassClave().setText(null);
            ventana.getPassClaveRepetida().setText(null);
            ventana.getPassClave().requestFocus();
        }
        else{
            if(ventana.getTxtDNI().isEditable()){
                ga.nuevoAutor(dni, apellidos, nombres, cargo, clave, claverep);
                this.ventana.dispose();
            }
            else{
                if(!ventana.getTxtDNI().isEditable()){
                        if(ga.verAutor(dni).verGrupos().isEmpty()){
                            ga.modificarAutor(ga.verAutor(dni), apellidos, nombres, cargo, clave, claverep);
                            JOptionPane.showMessageDialog(ventana, "Autor Modificado con Éxito!");
                            this.ventana.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(ventana, "Advertencia!\nNo se puede modificar: Existen grupos con este autor y puede generar errores");
                        }
                    }
                }
        
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "Hay un campo inválido");
            if(!ventana.getTxtDNI().isEditable()){
                ventana.getTxtApellidos().requestFocus();
            }
            else{
                ventana.getTxtDNI().requestFocus();
            }
        }
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
            ventana.dispose();
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
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c)){
            evt.consume();
        }
    }
    
}

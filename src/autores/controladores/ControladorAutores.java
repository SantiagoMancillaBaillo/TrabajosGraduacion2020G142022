/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import autores.vistas.ModeloComboCargos;
import autores.vistas.ModeloTablaAlumnos;
import autores.vistas.ModeloTablaProfesores;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAMAlumno;
import interfaces.IControladorAMProfesor;
import interfaces.IControladorAutores;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;



/**
 *
 * @author prog2
 */
public class ControladorAutores implements IControladorAutores{
    private VentanaAutores ventana;

    public ControladorAutores() {
        this.ventana = new VentanaAutores(this, null, true);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaProfesores().setModel(new ModeloTablaProfesores());
        this.ventana.getTablaAlumnos().setModel(new ModeloTablaAlumnos());
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        if(mta.getRowCount() == 0){
            this.ventana.getBtnModificarAlumno().setEnabled(false);
            this.ventana.getBtnBorrarAlumno().setEnabled(false);
        }
        if(mtp.getRowCount() == 0){
            this.ventana.getBtnModificarProfesor().setEnabled(false);
            this.ventana.getBtnBorrarProfesor().setEnabled(false);
        }
        JComboBox comboCargos = new JComboBox();
        comboCargos.setModel(new ModeloComboCargos());
        TableColumn colCargo = this.ventana.getTablaProfesores().getColumnModel().getColumn(3);
        colCargo.setCellEditor(new DefaultCellEditor(comboCargos));
        
        this.ventana.setVisible(true);
        
    }

    public void tablavacia(){
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        if(mta.getRowCount() == 0){
            this.ventana.getBtnModificarAlumno().setEnabled(false);
            this.ventana.getBtnBorrarAlumno().setEnabled(false);
            }
            else{
                this.ventana.getBtnModificarAlumno().setEnabled(true);
                this.ventana.getBtnBorrarAlumno().setEnabled(true);
                }
        if(mtp.getRowCount() == 0){
                this.ventana.getBtnModificarProfesor().setEnabled(false);
                this.ventana.getBtnBorrarProfesor().setEnabled(false);
                }
            else{
                this.ventana.getBtnModificarProfesor().setEnabled(true);
                this.ventana.getBtnBorrarProfesor().setEnabled(true);
            }
        }

    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        IControladorAMProfesor cpr = new ControladorAMProfesor();
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        this.tablavacia();
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        IControladorAMAlumno cal = new ControladorAMAlumno();
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        this.tablavacia();
        
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        Profesor p = mtp.verProfesor(this.ventana.getTablaProfesores().getSelectedRow());
        IControladorAMProfesor cal = new ControladorAMProfesor(String.valueOf(p.verDni()));
        mtp.actualizar();
        this.tablavacia();
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        Alumno al = mta.verAlumnos(this.ventana.getTablaAlumnos().getSelectedRow());
        IControladorAMAlumno cal = new ControladorAMAlumno(String.valueOf(al.verDni()));
        mta.actualizar();
        this.tablavacia();
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        Profesor pr = mtp.verProfesor(this.ventana.getTablaProfesores().getSelectedRow());
        IGestorAutores ga = GestorAutores.crear();
        ga.borrarAutor(pr);
        mtp.actualizar();
        this.tablavacia();
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        Alumno al = mta.verAlumnos(this.ventana.getTablaAlumnos().getSelectedRow());
        IGestorAutores ga = GestorAutores.crear();
        ga.borrarAutor(al);
        mta.actualizar();
        this.tablavacia();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        String apellidos = this.ventana.getjTextField1().getText();
            ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
            mtp.mostrarProfesores(apellidos);
            this.ventana.getjTextField1().setText(null);
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        String apellidos = this.ventana.getjTextField2().getText();
            ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
            mta.mostrarAlumnos(apellidos);
            this.ventana.getjTextField2().setText(null);
        }
        

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.requestFocus();
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && !Character.isWhitespace(c))
            evt.consume();
    }
}

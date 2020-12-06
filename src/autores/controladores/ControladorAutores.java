/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.vistas.ModeloTablaAlumnos;
import autores.vistas.ModeloTablaProfesores;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;



/**
 *
 * @author prog2
 */
public class ControladorAutores implements IControladorAutores{
    private VentanaAutores ventana;
    
//    VentanaPrincipal vp = new VentanaPrincipal(controlador);

    public ControladorAutores() {
        this.ventana = new VentanaAutores(this, null, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaProfesores().setModel(new ModeloTablaProfesores());
        this.ventana.getTablaAlumnos().setModel(new ModeloTablaAlumnos());
//        TableColumn colCargo = this.ventana.getTablaProfesores().getColumnModel().getColumn(3);
//        colCargo.setCellEditor(new DefaultCellEditor(comboCargos));
        this.ventana.setVisible(true);
        
    }


    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventana, "so puto?", "puto", JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventana, "so puto?", "puto", JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        System.out.println("Hola");
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        System.out.println("Hola");
    }
    
    
    
    
    
    
    
//    <editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica"> 
//        ArrayList<Autor> autores = new ArrayList<>();
        
//        IGestorAutores ga = GestorAutores.crear();
        
//        System.out.println(ga.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
//        System.out.println(ga.nuevoAutor(20, "Apellido20", "Nombre20", Cargo.ASOCIADO, "Clave20", "Clave20"));
//        System.out.println(ga.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));//PROF REPETIDO
//        System.out.println(ga.nuevoAutor(1, "Apellido1", "Nombre1", "cx1", "Clave1", "Clave1"));
//        System.out.println(ga.nuevoAutor(1, "Apellido1", "Nombre1", "cx1", "Clave1", "Clave1"));//ALUM REPETIDO
//        System.out.println(ga.nuevoAutor(10, "Apellido2", "Nombre2", "cx2", "Clave2", "Clave2"));//DNI REPETIDO CON PROF
//        System.out.println(ga.nuevoAutor(1, "Apellido1", "Nombre1", Cargo.ADG, "Clave1", "Clave1"));//DNI REPETIDO CON ALUM
//        System.out.println(ga.nuevoAutor(1, "", "Nombre1", "cx1", "Clave1", "Clave1"));//datos vacios
//        System.out.println(ga.nuevoAutor(20, "Apellido20", "Nombre20", Cargo.ASOCIADO, null, "Clave20"));//datos nulos
//        
//        
//        ga.verAutores();
//        ga.verAlumnos();
//        ga.verProfesores();
//        
//        ga.verAutor(10);
//        ga.verAutor(1);
        

      //</editor-fold>   
        
    //     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
//        
////        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
////        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
////        ventanaAlumno.setVisible(true); //se hace visible la ventana
//*/        
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        

//     //</editor-fold>
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.controladores.ControladorAutores;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import grupos.controladores.ControladorGrupos;
import grupos.modelos.GestorGrupos;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import interfaces.IControladorAutores;
import interfaces.IControladorGrupos;
import interfaces.IControladorPrincipal;
import interfaces.IControladorPublicaciones;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import interfaces.IGestorIdiomas;
import interfaces.IGestorLugares;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lugares.modelos.GestorLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import principal.vistas.VentanaPrincipal;
import publicaciones.controladores.ControladorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.GestorTipos;


/**
 *
 * @author prog2
 */
public class ControladorPrincipal  implements IControladorPrincipal{
    private VentanaPrincipal ventana;

    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnGruposClic(ActionEvent evt) {
        IControladorGrupos controlador = new ControladorGrupos();
    }

    @Override
    public void btnAutoresClic(ActionEvent evt) {
        IControladorAutores controlador = new ControladorAutores();
    }

    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        IControladorPublicaciones controlador = new ControladorPublicaciones();
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion= JOptionPane.showOptionDialog(null, "¿Desea terminar?", "Repositorios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí","No"}, this);
        if(opcion == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    
    
    public static void main(String[] args) {

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloComboRoles;
import grupos.modelos.ModeloTablaAgregarMiembros;
import grupos.modelos.Rol;
import grupos.vistas.VentanaAMGrupo;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import interfaces.IGestorGrupos;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Windows 10
 */
public class ControladorModificarMiembros implements IControladorModificarMiembros{
    private VentanaModificarMiembros ventana;
    private VentanaAMGrupo ventanaGrupos;
    private Grupo g;
    private String s = "Super Administradores";
    
    public ControladorModificarMiembros(Grupo gr) {
        g = gr;
        this.ventana = new VentanaModificarMiembros(this, ventanaGrupos, true);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaAgregarMiembros().setModel(new ModeloTablaAgregarMiembros());
        this.ventana.getTablaAgregarMiembros().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JComboBox comboRoles = new JComboBox();
        comboRoles.setModel(new ModeloComboRoles());
        TableColumn colRoles = this.ventana.getTablaAgregarMiembros().getColumnModel().getColumn(1);
        colRoles.setCellEditor(new DefaultCellEditor(comboRoles));
        this.hayMiembros();
        this.ventana.setVisible(true);
    }
    

    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaAgregarMiembros mtAm = (ModeloTablaAgregarMiembros)this.ventana.getTablaAgregarMiembros().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTablaAgregarMiembros().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtAm.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = this.ventana.getTablaAgregarMiembros().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        IGestorGrupos gg = GestorGrupos.crear();
        ListSelectionModel modeloSeleccion = this.ventana.getTablaAgregarMiembros().getSelectionModel();
        ModeloTablaAgregarMiembros mt = (ModeloTablaAgregarMiembros)this.ventana.getTablaAgregarMiembros().getModel();
        for(int fila = 0; fila < mt.getRowCount(); fila++) {
            if(modeloSeleccion.isSelectedIndex(fila)){
                MiembroEnGrupo p = mt.verMiembros(fila);
                if(p.verRol() == null){
                    JOptionPane.showMessageDialog(ventana, "ERROR Todos los miembros agregados deben tener un Rol asignado\n(Se agregaran solo los Autores a los que se le haya asignado un Rol)");
                }
                if(gg.verGrupo(g.verNombre()).esSuperAdministradores() == true){
                    gg.verGrupo(g.verNombre()).agregarMiembro(p.verAutores(), Rol.ADMINISTRADOR);
                }
                else{
                    gg.verGrupo(g.verNombre()).agregarMiembro(p.verAutores(),p.verRol());
                }
            }
            if(!modeloSeleccion.isSelectedIndex(fila)){
                MiembroEnGrupo p = mt.verMiembros(fila);
                gg.verGrupo(g.verNombre()).quitarMiembro(p.verAutores());
            }
            if(modeloSeleccion.isSelectionEmpty()){
                gg.verGrupo(g.verNombre()).verMiembros().clear();
            }                 
        }
    this.ventana.dispose();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }
    
    public void hayMiembros(){
    ListSelectionModel modeloSeleccion = this.ventana.getTablaAgregarMiembros().getSelectionModel();
        ModeloTablaAgregarMiembros mt = (ModeloTablaAgregarMiembros)this.ventana.getTablaAgregarMiembros().getModel();
        for(MiembroEnGrupo miemb : g.verMiembros()) {
            for(int fila = 0; fila < mt.getRowCount(); fila++) {
                MiembroEnGrupo mg = mt.verMiembros(fila);
                if (mg.verAutores() == miemb.verAutores()) {
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    mg.asignarRol(miemb.verRol());
                    break;
                }
            }
        }
    }
    
}

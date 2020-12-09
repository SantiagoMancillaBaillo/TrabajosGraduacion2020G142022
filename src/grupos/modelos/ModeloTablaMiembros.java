/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaMiembros extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    
    public ModeloTablaMiembros() {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol"); 
    }
    
    public ModeloTablaMiembros(Grupo g){
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol"); 
        IGestorGrupos gg = GestorGrupos.crear();
//        Grupo gr = new Grupo(nombre, descripcion);
        grupos = gg.verGrupos();
        if(gg.verGrupos().contains(g)){
//            miembros = gg.verGrupo(g.verNombre()).verMiembros();
            miembros = g.verMiembros();
        }
    }
    
    @Override
    public int getRowCount() {
        return this.miembros.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo m = this.miembros.get(fila);
        
        switch(columna){
            case 0: return m.verAutores().verNombres();
            default: return m.verRol();
        }
    }
    
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
    
    @Override
    public String getColumnName(int columna){
        return this.nombreColumnas.get(columna);
    }
    
    public MiembroEnGrupo verMiembro (int fila){
        return this.miembros.get(fila);
    }
    
    public void actualizar(Grupo g){
        IGestorGrupos gg = GestorGrupos.crear();
            if(gg.verGrupos().contains(g)){
//                miembros = gg.verGrupo(g.verNombre()).verMiembros();
                miembros = g.verMiembros();
            }
        this.fireTableDataChanged();
    }
    
    public void actualizar(){
        this.fireTableDataChanged();
    }
}

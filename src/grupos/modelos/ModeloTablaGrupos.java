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
public class ModeloTablaGrupos extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();

    public ModeloTablaGrupos() {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Descripción");
        
        IGestorGrupos gg = GestorGrupos.crear();
        this.grupos = gg.verGrupos();
    }
    
    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }
    
    @Override
    public int getRowCount() {
        return this.grupos.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Grupo g = this.grupos.get(fila);
        
        switch(columna){
            case 0: return g.verNombre();
            default: return g.verDescripcion();
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
    
    public Grupo verGrupo (int fila){
        return this.grupos.get(fila);
    }
    
    public void actualizar(){
        IGestorGrupos gg = GestorGrupos.crear();
        this.grupos = gg.verGrupos();
        this.fireTableDataChanged();
    }
    
    public void actualizar(List<Grupo> grupo){
        this.grupos = grupo;
        this.fireTableDataChanged();
    }
    
    public void mostrarGrupos(String nombre){
        IGestorGrupos gg = GestorGrupos.crear();
        if(nombre.isBlank()){
            this.actualizar();
        }
        else{
            List<Grupo> grupos2 = new ArrayList<>();
            for(Grupo g : gg.verGrupos()){
                if(g.verNombre().contains(nombre))
                    grupos2.add(g);
            }
            this.actualizar(grupos2);
        }   
    }
    
}

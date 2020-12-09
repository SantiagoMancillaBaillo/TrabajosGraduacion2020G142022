/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaGruposP extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> grupos = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    
    public ModeloTablaGruposP() {
        nombreColumnas.add("Grupo");
        nombreColumnas.add("Rol"); 
    }
    
    public ModeloTablaGruposP(Autor a){
        nombreColumnas.add("Grupo");
        nombreColumnas.add("Rol"); 
        IGestorAutores ga = GestorAutores.crear();
        profesores = ga.verProfesores();
//        if(ga.verProfesores().contains(p)){
////            miembros = gg.verGrupo(g.verNombre()).verMiembros();
            grupos = a.verGrupos();
//        }
    }

    @Override
    public int getRowCount() {
        return this.grupos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo m = this.grupos.get(fila);
        
        switch(columna){
            case 0: return m.verGrupos().verNombre();
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
    
    public MiembroEnGrupo verGrupo (int fila){
        return this.grupos.get(fila);
    }
    
    public void actualizar(Autor p){
        IGestorAutores ga = GestorAutores.crear();
//            if(ga.verProfesores().contains(p)){
////                miembros = gg.verGrupo(g.verNombre()).verMiembros();
                grupos = p.verGrupos();
//            }
        this.fireTableDataChanged();
    }
    
    
}

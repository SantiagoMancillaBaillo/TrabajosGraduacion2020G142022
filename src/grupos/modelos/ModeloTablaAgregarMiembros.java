/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Windows 10
 */
public class ModeloTablaAgregarMiembros extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    
    public ModeloTablaAgregarMiembros() {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
        IGestorAutores ga = GestorAutores.crear();
        autores = ga.verAutores();
        for(Autor a : autores){
            MiembroEnGrupo m = new MiembroEnGrupo(a, null, null);
            miembros.add(m);
        }
        Collections.sort(miembros);
        
    }
    
    public MiembroEnGrupo verMiembros (int fila){
        return this.miembros.get(fila);
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
    public void setValueAt(Object valor, int fila, int columna){
        MiembroEnGrupo m = this.miembros.get(fila);
        switch(columna){
            case 1: m.asignarRol((Rol)valor);
        }
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        if(columna == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String getColumnName(int columna){
        return this.nombreColumnas.get(columna);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo m = this.miembros.get(fila);
        switch(columna){
            case 0: return m.verAutores().verApellidos()+ ", " + m.verAutores().verNombres()+ "(" + m.verAutores().verDni() + ")";
            default: return m.verRol();
        }
    }
    
    
    
}

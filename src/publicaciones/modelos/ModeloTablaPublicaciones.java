/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaPublicaciones extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Publicacion> publicaciones = new ArrayList<>();

    public ModeloTablaPublicaciones() {
        nombreColumnas.add("Título");
        nombreColumnas.add("Autor");
        nombreColumnas.add("Año");
        
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        this.publicaciones = gp.verPublicaciones();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }
    
    @Override
    public int getRowCount() {
        return this.publicaciones.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Publicacion p = this.publicaciones.get(fila);
        
        switch(columna){
            case 0: return p.verTitulo();
            case 1: return p.verMiembro().verAutores().verApellidos() + ", " + p.verMiembro().verAutores().verNombres() + "(" + p.verMiembro().verAutores().verDni() + ")";
            default: return p.verFechaPublicacion().getYear();
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
    
    public Publicacion verPublicacion (int fila){
        return this.publicaciones.get(fila);
    }
    
    public void actualizar(){
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        this.publicaciones = gp.verPublicaciones();
        this.fireTableDataChanged();
    }
    
    public void actualizar(List<Publicacion> publicacion){
        this.publicaciones = publicacion;
        this.fireTableDataChanged();
    }
    
    public void mostrarPublicaciones(String titulo){
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        if(titulo.isBlank()){
            this.actualizar();
        }
        else{
            List<Publicacion> publicaciones2 = new ArrayList<>();
            for(Publicacion p : gp.verPublicaciones()){
                if(p.verTitulo().contains(titulo))
                    publicaciones2.add(p);
            }
            this.actualizar(publicaciones2);
        }   
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.Alumno;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaProfesores extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Profesor> profesor = new ArrayList<>();

    public ModeloTablaProfesores() {
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("Cargo");
        
        IGestorAutores ga = GestorAutores.crear();
        this.profesor = ga.verProfesores();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.profesor.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Profesor p = this.profesor.get(fila);
        
        switch(columna){
            case 0: return p.verDni();
            case 1: return p.verApellidos();
            case 2: return p.verNombres();
            default: return p.verCargo();
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
    
    public Profesor verProfesor (int fila){
        return this.profesor.get(fila);
    }
    
    public void actualizar(){
        IGestorAutores ga = GestorAutores.crear();
        this.profesor = ga.verProfesores();
        this.fireTableDataChanged();
    }
    
    public void actualizar(ArrayList<Profesor> profesores){
        this.profesor = profesores;
        this.fireTableDataChanged();
    }
    
    public void mostrarProfesores(String apellidos){
        IGestorAutores ga = GestorAutores.crear();
        if(apellidos.isBlank()){
            this.actualizar();
        }
        else{
            ArrayList<Profesor> profesor2 = new ArrayList<>();
            for(Profesor p : ga.verProfesores()){
                if(p.verApellidos().contains(apellidos))
                    profesor2.add(p);
            }
            this.actualizar(profesor2);
        }   
    }
    
}

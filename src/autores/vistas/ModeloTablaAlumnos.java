/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaAlumnos extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Alumno> alumno = new ArrayList<>();

    public ModeloTablaAlumnos() {
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("CX");
        
        IGestorAutores ga = GestorAutores.crear();
        this.alumno = ga.verAlumnos();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.alumno.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Alumno al = this.alumno.get(fila);
        
        switch(columna){
            case 0: return al.verDni();
            case 1: return al.verApellidos();
            case 2: return al.verNombres();
            default: return al.verCx();
        }
    }
    
    @Override
    public String getColumnName(int columna){
        return this.nombreColumnas.get(columna);
    }
    
    public Alumno verAlumnos (int fila){
        return this.alumno.get(fila);
    }
        
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
    
    public void actualizar(){
        IGestorAutores ga = GestorAutores.crear();
        this.alumno = ga.verAlumnos();
        this.fireTableDataChanged();
    }
    
    public void actualizar(ArrayList<Alumno> alumnos){
        this.alumno = alumnos;
        this.fireTableDataChanged();
    }
    
    public void mostrarAlumnos(String apellidos){
        IGestorAutores ga = GestorAutores.crear();
        if(apellidos.isBlank()){
            this.actualizar();
        }
        else{
            ArrayList<Alumno> alumno2 = new ArrayList<>();
            for(Alumno a : ga.verAlumnos()){
                if(a.verApellidos().startsWith(apellidos))
                    alumno2.add(a);
            }
            this.actualizar(alumno2);
        }
    }
    
}
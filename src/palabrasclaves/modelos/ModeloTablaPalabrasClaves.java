/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class ModeloTablaPalabrasClaves extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<PalabraClave> palabrasClaves = new ArrayList<>();
    
    public ModeloTablaPalabrasClaves() {
        nombreColumnas.add("Nombre");
        IGestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
        palabrasClaves = gpc.verPalabrasClaves();
        
    }

    public PalabraClave verPalabraClave (int fila){
        return this.palabrasClaves.get(fila);
    }
    
    @Override
    public int getRowCount() {
        return this.palabrasClaves.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave pc = this.palabrasClaves.get(fila);
        switch(columna){
            default: return pc.verPalabraClave();
        }
    }
    
    @Override
    public String getColumnName(int columna){
        return this.nombreColumnas.get(columna);
    }
    
}

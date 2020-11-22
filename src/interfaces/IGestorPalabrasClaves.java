/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import palabrasclaves.modelos.PalabraClave;

/**
 *
 * @author Windows 10
 */
public interface IGestorPalabrasClaves {
    public static final String PMENSAJE_EXITO = "Se creó la Palabra Clave correctamente";
    public static final String PMENSAJE_REPETIDO = "No se creó la Palabra Clave. Motivo: ya existe una con ese nombre";
    public static final String PMENSAJE_ERROR = "No se creó la Palabra Clave. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public String nuevaPalabraClave(String nombre);
    public ArrayList<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
}

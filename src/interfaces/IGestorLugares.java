/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import lugares.modelos.Lugar;

/**
 *
 * @author Windows 10
 */
public interface IGestorLugares {
    public static final String LMENSAJE_EXITO = "Se creó el Lugar correctamente";
    public static final String LMENSAJE_REPETIDO = "No se creó el Lugar. Motivo: ya existe uno con ese nombre";
    public static final String LMENSAJE_ERROR = "No se creó el Lugar. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public String nuevoLugar(String nombre);
    public ArrayList<Lugar> verLugares();
    public Lugar verLugar(String nombre);
}

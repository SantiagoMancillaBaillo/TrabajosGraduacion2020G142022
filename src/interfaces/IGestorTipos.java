/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import tipos.modelos.Tipo;
/**
 *
 * @author Windows 10
 */
public interface IGestorTipos {
    public static final String TMENSAJE_EXITO = "Se creó el tipo correctamente";
    public static final String TMENSAJE_REPETIDO = "No se creó el tipo. Motivo: ya existe uno con ese nombre";
    public static final String TMENSAJE_ERROR = "No se creó el tipo. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public String nuevoTipo(String nombre);
    public ArrayList<Tipo> verTipos();
    public Tipo verTipo(String nombre);
}

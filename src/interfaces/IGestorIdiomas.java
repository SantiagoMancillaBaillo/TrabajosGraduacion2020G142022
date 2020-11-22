/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import idiomas.modelos.Idioma;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public interface IGestorIdiomas {
    public static final String IMENSAJE_EXITO = "Se añadió el ididoma correctamente";
    public static final String IMENSAJE_REPETIDO = "No se añadió el idioma. Motivo: ya existe";
    public static final String IMENSAJE_ERROR = "No se añadió el idioma. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public String nuevoIdioma(String nombre);
    public ArrayList<Idioma> verIdiomas();
    public Idioma verIdioma(String nombre);
}

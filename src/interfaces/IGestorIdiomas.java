/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import idiomas.modelos.Idioma;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface IGestorIdiomas {
    public static final String IMENSAJE_EXITO = "Se añadió el ididoma correctamente";
    public static final String IMENSAJE_REPETIDO = "No se añadió el idioma. Motivo: ya existe";
    public static final String IMENSAJE_ERROR = "No se añadió el idioma. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String IborrarMENSAJE_EXITO = "Se eliminó el Idioma correctamente";
    public static final String IborrarMENSAJE_ERROR = "No se borró el Idioma pues hay una publicación que lo contiene.";
    public static final String IborrarMENSAJE_NO_EXISTE = "No hay Idioma con ese nombre";
    public String nuevoIdioma(String nombre);
    public List<Idioma> verIdiomas();
    public Idioma verIdioma(String nombre);
    public String borrarIdioma(Idioma idioma);
    public List<Idioma> buscarIdiomas(String nombre);
    public boolean existeEsteIdioma(Idioma idioma);
}

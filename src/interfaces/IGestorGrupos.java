/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import grupos.modelos.Grupo;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public interface IGestorGrupos {
    public static final String GMENSAJE_EXITO = "Se creó el Grupo correctamente";
    public static final String GMENSAJE_REPETIDO = "No se creó el Grupo. Motivo: ya existe uno con ese nombre";
    public static final String GMENSAJE_ERROR = "No se creó el Grupo. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String GmodMENSAJE_EXITO = "Se modificó el Grupo correctamente";
    public static final String GmodMENSAJE_NO_EXISTE = "No se modificó el Grupo pues este no existe";
    public static final String GmodMENSAJE_ERROR = "No se modificó el Grupo. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public String nuevoGrupo(String nombre, String descripcion);
    public String modificarGrupo(Grupo grupo, String descripcion);
    public ArrayList<Grupo> verGrupos();
    public Grupo verGrupo(String nombre);
    public boolean existeEsteGrupo(Grupo grupo);
}

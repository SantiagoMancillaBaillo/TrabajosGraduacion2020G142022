/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Profesor;
import autores.modelos.Cargo;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public interface IGestorAutores {
    public static final String AMENSAJE_EXITO = "Se creó el autor correctamente";
    public static final String AMENSAJE_REPETIDO = "No se creó el autor. Motivo: ya existe uno con ese dni";
    public static final String AMENSAJE_ERROR = "No se creó el autor. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String AmodMENSAJE_EXITO = "Se modificó el Autor correctamente";
    public static final String AodMENSAJE_ERROR = "No se pudo modificar el Autor";
    public static final String AmodMENSAJE_NO_EXISTE = "No se pudo modificar el autor, pues éste no existe";
    
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public boolean existeEsteAutor(Autor autor);
    public ArrayList<Autor> verAutores();
    public ArrayList<Profesor> verProfesores();
    public ArrayList<Alumno> verAlumnos();
    public Autor verAutor(int dni);
}

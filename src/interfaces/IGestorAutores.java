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
import grupos.modelos.Grupo;
import java.util.List;

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
    public static final String AborrarMENSAJE_EXITO = "Se eliminó el Autor correctamente";
    public static final String AborrarMENSAJE_ERROR = "No se borró el Autor pues hay una publicación que lo contiene.";
    public static final String AborrarMENSAJE_NO_EXISTE = "No existe ese Autor";
    
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public boolean existeEsteAutor(Autor autor);
    public List<Autor> verAutores();
    public List<Profesor> verProfesores();
    public List<Alumno> verAlumnos();
    public Autor verAutor(int dni);
    
    public String borrarAutor(Autor autor);
    public List<Profesor> buscarProfesores(String apellidos);
    public List<Alumno> buscarAlumnos(String apellidos);
    public boolean hayAutoresConEsteGrupo(Grupo grupo);
}

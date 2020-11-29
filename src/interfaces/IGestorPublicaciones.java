/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;

/**
 *
 * @author Windows 10
 */
public interface IGestorPublicaciones {
    public static final String PMENSAJE_EXITO = "Se creó la Publicación correctamente";
    public static final String PMENSAJE_REPETIDO = "No se creó la Publicación. Motivo: ya existe una con el mismo título";
    public static final String PMENSAJE_ERROR = "No se creó la Publicación. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String PmodMENSAJE_EXITO = "Se modificó la Publicación correctamente";
    public static final String PmodMENSAJE_NO_EXISTE = "No se modificó la Publicación pues esta no existe";
    public static final String PmodMENSAJE_ERROR = "No se modificó la Publicación. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String PborrarMENSAJE_EXITO = "Se borró la Publicación correctamente";
    public static final String PborrarMENSAJE_NO_EXISTE = "La Publicación especificada no existe";
    
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen);
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen);
    
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave);
    public boolean hayPublicacionesConEsteLugar(Lugar lugar);
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma);
    public boolean hayPublicacionesConEsteTipo(Tipo tipo);
    public boolean hayPublicacionesConEsteAutor(Autor autor);
    public boolean existeEstaPublicacion(Publicacion publicacion);
    public List<Publicacion> verPublicaciones();
    public Publicacion verPublicacion(String titulo);
    public String borrarPublicacion(Publicacion publicacion);
    public List<Publicacion> buscarPublicaciones(String titulo);
}

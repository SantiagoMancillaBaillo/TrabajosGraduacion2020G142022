/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author Windows 10
 */
public class GestorPublicaciones implements IGestorPublicaciones{
    
    private ArrayList<Publicacion> publicaciones = new ArrayList<>();
    private static GestorPublicaciones instanciaPublicacion;

    public GestorPublicaciones() {
        
    }
    
    public static GestorPublicaciones crear(){
        if(instanciaPublicacion == null)
            instanciaPublicacion = new GestorPublicaciones();
        return instanciaPublicacion;
    }
    
    
    

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if ((titulo != null && !titulo.isBlank()) && (miembroEnGrupo != null && miembroEnGrupo.verAutores() != null && miembroEnGrupo.verGrupos() != null && miembroEnGrupo.verRol() != null) && (fechaPublicacion != null) && (tipo != null) && (idioma != null) && (lugar != null) && (!palabrasClaves.isEmpty()) && (enlace != null && !enlace.isBlank()) && (resumen != null && !resumen.isBlank())){
            Publicacion p = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
            if(existeEstaPublicacion(p) == false){
                this.publicaciones.add(p);
                return PMENSAJE_EXITO;
            }
            else
                return PMENSAJE_REPETIDO;
        }
        else
            return PMENSAJE_ERROR;
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if((miembroEnGrupo != null && miembroEnGrupo.verAutores() != null && miembroEnGrupo.verGrupos() != null && miembroEnGrupo.verRol() != null) && (fechaPublicacion != null) && (tipo != null) && (idioma != null) && (lugar != null) && (!palabrasClaves.isEmpty()) && (enlace != null && !enlace.isBlank()) && (resumen != null && !resumen.isBlank())){
            if(existeEstaPublicacion(publicacion) == true){
                Publicacion p = new Publicacion(publicacion.verTitulo(), miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
                publicaciones.set(publicaciones.indexOf(publicacion), p);
                return PmodMENSAJE_EXITO;
            }
            return PmodMENSAJE_NO_EXISTE;
        }
        else
            return PmodMENSAJE_ERROR;
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        int contador = 0;
        boolean hayPPalClave = false;
        if(palabraClave != null){
            for(Publicacion p : publicaciones){
                if(p.verPalabrasClaves().contains(palabraClave)){
                    hayPPalClave = true;
                    contador++;
                }
            }
            System.out.println("Hay " + contador + " publicaciones con esa Palabra Clave");
        }
        return hayPPalClave;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        int contador = 0;
        boolean hayPLugar = false;
        if(lugar != null){
            for(Publicacion p : publicaciones){
                if(p.verLugar()== lugar){
                    hayPLugar = true;
                    contador++;
                }
            }
            System.out.println("Hay " + contador + " publicaciones con ese Lugar");
        }
        return hayPLugar;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        int contador = 0;
        boolean hayPIdioma = false;
        if(idioma != null){
            for(Publicacion p : publicaciones){
                if(p.verIdioma()== idioma){
                    hayPIdioma = true;
                    contador++;
                }
            }
            System.out.println("Hay " + contador + " publicaciones en ese Idioma");
        }
        return hayPIdioma;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        int contador = 0;
        boolean hayPTipo = false;
        if(tipo != null){
            for(Publicacion p : publicaciones){
                if(p.verTipo() == tipo){
                    hayPTipo = true;
                    contador++;
                }
            }
            System.out.println("Hay " + contador + " publicaciones con ese Tipo");
        }
        return hayPTipo;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        int contador = 0;
        boolean hayPAutor = false;
        MiembroEnGrupo mg = new MiembroEnGrupo(autor, null, null);
        if(autor != null){
            Publicacion pu = new Publicacion (null, mg ,null , null, null, null, null, null, null);
            for(Publicacion p : publicaciones){
                if(pu.verMiembro().verAutores() == p.verMiembro().verAutores()){
                    contador++;
                    hayPAutor = true;
                }
            }
            System.out.println("Hay " + contador + " publicaciones con ese Autor");
        }
        return hayPAutor;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        boolean existe = false;
        if(publicaciones.contains(publicacion)){
            existe = true;
        }
        else{
            existe = false;
        }
        return existe;
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        System.out.println("--------------PUBLICACIONES--------------");
        for(Publicacion p : publicaciones){
            p.mostrar();
        }
        return publicaciones;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        if(titulo != null && !titulo.isBlank()){
        Publicacion pu = new Publicacion (titulo, null, null, null, null, null, null, null, null);
        for(Publicacion p : publicaciones){
                if(pu.verTitulo().equals(p.verTitulo())){
                    System.out.println("PUBLICACIÓN ENCONTRADA:" + p.verTitulo());
                    p.mostrar();
                    return p;
                }
            }
        }
        return null;
    }
    
}

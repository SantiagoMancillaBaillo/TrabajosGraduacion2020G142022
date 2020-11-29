/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author Windows 10
 */
public class Publicacion implements Comparable<Publicacion>{
    private String titulo;
    private MiembroEnGrupo miembro;
    private LocalDate fechaPublicacion;
    private Tipo unTipo;
    private Idioma unIdioma;
    private Lugar unLugar;
    private List<PalabraClave> palClave = new ArrayList<>();
    private String enlace;
    private String resumen;
    String patron = "dd/MM/yyyy";
    

    public Publicacion(String titulo, MiembroEnGrupo miembro, LocalDate fechaPublicacion, Tipo unTipo, Idioma unIdioma, Lugar unLugar, List<PalabraClave> palClave, String enlace, String resumen) {
        this.titulo = titulo;
        this.miembro = miembro;
        this.fechaPublicacion = fechaPublicacion;
        this.unTipo = unTipo;
        this.unIdioma = unIdioma;
        this.unLugar = unLugar;
        this.palClave = palClave;
        this.enlace = enlace;
        this.resumen = resumen;
    }


        public void mostrar(){
            System.out.println("-----------Publicación-----------");
            System.out.println("Título: " + titulo);
            miembro.mostrar("t",1);
            System.out.println("Fecha de publicación: " + fechaPublicacion.format(DateTimeFormatter.ofPattern(patron)));
            System.out.println("Tipo: " + unTipo.verTipo());
            System.out.println("Idioma: " + unIdioma.verIdioma());
            System.out.println("Lugar: " + unLugar.verLugar());
            System.out.println("Palabras Claves\n -----------");
            for(PalabraClave p : palClave){
            System.out.println(" " + p.verPalabraClave());
            }
            System.out.println("\nEnlace: " + enlace);
            System.out.println("Resumen: " + resumen);
            System.out.println("---------------------------------");
        }

    public String verTitulo() {
        return titulo;
    }

    public MiembroEnGrupo verMiembro() {
        return miembro;
    }

    public Tipo verTipo() {
        return unTipo;
    }

    public Idioma verIdioma() {
        return unIdioma;
    }

    public Lugar verLugar() {
        return unLugar;
    }

    public List<PalabraClave> verPalabrasClaves() {
        return palClave;
    }
        
    
        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Publicacion p) {
        return this.titulo.compareTo(p.titulo);
    }
    

    
    
    
}

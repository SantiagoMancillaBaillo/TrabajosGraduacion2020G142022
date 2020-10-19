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
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author Windows 10
 */
public class Publicacion {
    private String titulo;
    private MiembroEnGrupo miembro;
    private LocalDate fechaPublicacion;
    private Tipo unTipo;
    private Idioma unIdioma;
    private Lugar unLugar;
    private ArrayList<PalabraClave> palClave; //= new ArrayList<>();
    private String enlace;
    private String resumen;
    String patron = "dd/MM/yyyy";
    

    public Publicacion(String titulo, MiembroEnGrupo miembro, LocalDate fechaPublicacion, Tipo unTipo, Idioma unIdioma, Lugar unLugar, ArrayList<PalabraClave> palClave, String enlace, String resumen) {
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
            System.out.println(palClave);
            System.out.println("Enlace: " + enlace);
            System.out.println("Resumen: " + resumen);
            System.out.println("---------------------------------");
        }
    

    
    
    
}

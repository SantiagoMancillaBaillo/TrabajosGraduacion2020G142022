/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import idiomas.modelos.Idioma;
import java.time.LocalDate;
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
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    private Tipo unTipo;
    private Idioma unIdioma;
    private Lugar unLugar;
    ArrayList<PalabraClave> palClave = new ArrayList<>();
    
    
}

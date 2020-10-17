/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import cargos.modelos.Cargo;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import grupos.vistas.VentanaAMGrupo;
import idiomas.modelos.Idioma;
import idiomas.vistas.VentanaAIdioma;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import lugares.vistas.VentanaALugar;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaAPalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;
import tipos.vistas.VentanaATipo;


/**
 *
 * @author prog2
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
    
     //<editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica"> 
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Tipo> tipos = new ArrayList<>();
        ArrayList<Lugar> lugares = new ArrayList<>();
        ArrayList<Idioma> idiomas = new ArrayList<>();
        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();

        //GRUPOS
        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
        Grupo grupo2 = new Grupo("Grupo 2", "Descripción 2");
        Grupo grupo3 = new Grupo("Grupo 3", "Descripción 3");
        Grupo grupo4 = new Grupo("Grupo 4", "Descripción 4");
        Grupo grupo5 = new Grupo("Grupo 5", "Descripción 5");
        Grupo grupo6 = new Grupo("Grupo 1", "Descripción 5");
        
        if (!grupos.contains(grupo1))
            grupos.add(grupo1);
        if (!grupos.contains(grupo2))
            grupos.add(grupo2);
        if (!grupos.contains(grupo3))
            grupos.add(grupo3);
        if (!grupos.contains(grupo4))
            grupos.add(grupo4);
        if (!grupos.contains(grupo5))
            grupos.add(grupo5);
        if (!grupos.contains(grupo6))
            grupos.add(grupo6);
      
        
        System.out.println("----Grupos----");
        for(Grupo g : grupos)
            g.mostrar();
        //GRUPOS
        //ALUMNOS
//        
//
//        alumnos.add(alumno1);
//        alumnos.add(alumno2);
//        alumnos.add(alumno3);
//        alumnos.add(alumno4);
//        alumnos.add(alumno5);
        
//        System.out.println("\n----Alumnos----\n");
//        for(Alumno a : alumnos)
//            a.mostrar();
        //ALUMNOS
        //PROFESORES
//        
        
//
//        profesores.add(profesor1);
//        profesores.add(profesor2);
//        profesores.add(profesor3);
//        profesores.add(profesor4);
//        profesores.add(profesor5);
//        
//        System.out.println("\n----Profesores----\n");
//        for(Profesor p : profesores)
//            p.mostrar();
        //PROFESORES
        
        System.out.println("------------------AUTORES------------------");
        Alumno alumno1 = new Alumno("Nombre1","Apellido1",1,"Clave1","1");
        Alumno alumno2 = new Alumno("Nombre2","Apellido2",2,"Clave2","2");
        Alumno alumno3 = new Alumno("Nombre3","Apellido3",3,"Clave3","3");
        Alumno alumno4 = new Alumno("Nombre4","Apellido4",4,"Clave4","4");
        Alumno alumno5 = new Alumno("Nombre5","Apellido5",5,"Clave5","5");
        Autor alumno6 = new Alumno( "Nombre6", "Apellido6", 1, "Clave6", "6");
        //dni repetido con un alumno
        
        if (!autores.contains(alumno1))
            autores.add(alumno1);
        if (!autores.contains(alumno2))
            autores.add(alumno2);
        if (!autores.contains(alumno3))
            autores.add(alumno3);
        if (!autores.contains(alumno4))
            autores.add(alumno4);
        if (!autores.contains(alumno5))
            autores.add(alumno5);
        if (!autores.contains(alumno6))
            autores.add(alumno6);
        
        Profesor profesor1 = new Profesor("Nombre10", "Apellido10", 10, "Clave10", Cargo.TITULAR);
        Profesor profesor2 = new Profesor("Nombre20", "Apellido20", 20, "Clave20", Cargo.ASOCIADO);
        Profesor profesor3 = new Profesor("Nombre30", "Apellido30", 30, "Clave30", Cargo.ADJUNTO);
        Profesor profesor4 = new Profesor("Nombre40", "Apellido40", 40, "Clave40", Cargo.JTP);
        Profesor profesor5 = new Profesor("Nombre50", "Apellido50", 50, "Clave50", Cargo.ADG);
        Autor profesor6 = new Profesor("Nombre60", "Apellido60", 10, "Clave60", Cargo.ADG); 
        //dni repetido con otro profesor
        Autor profesor7 = new Profesor("Nombre70", "Apellido70", 1, "Clave70", Cargo.ADG); 
        //dni repetido con otro alumno
        Autor alumno7 = new Alumno("Nombre7", "Apellido7", 50, "Clave7", "7");
        //dni repetido con un profesor
        Autor alumno8 = new Alumno("Nombre8", "Apellido8", 8, "Clave8", "6");
        //cx repetido con un alumno
        
        if (!autores.contains(profesor1))
            autores.add(profesor1);
        if (!autores.contains(profesor2))
            autores.add(profesor2);
        if (!autores.contains(profesor3))
            autores.add(profesor3);
        if (!autores.contains(profesor4))
            autores.add(profesor4);
        if (!autores.contains(profesor5))
            autores.add(profesor5);
        if (!autores.contains(profesor6))
            autores.add(profesor6);
        
        if (!autores.contains(profesor7))
            autores.add(profesor7);
        if (!autores.contains(alumno7))
            autores.add(alumno7);
        if (!autores.contains(alumno8))
            autores.add(alumno8);
        
        
        for(Autor a : autores)
            a.mostrar();
              
        //TIPOS DE PUBLICACION
        System.out.println("\n----Tipos de publicación----\n");
        Tipo tipo1 = new Tipo("Tipo 1");
        Tipo tipo2 = new Tipo("Tipo 2");
        Tipo tipo3 = new Tipo("Tipo 3");
        Tipo tipo4 = new Tipo("Tipo 4");
        Tipo tipo5 = new Tipo("Tipo 5");
        
        if (!tipos.contains(tipo1))
            tipos.add(tipo1);
        if (!tipos.contains(tipo2))
            tipos.add(tipo2);
        if (!tipos.contains(tipo3))
            tipos.add(tipo3);
        if (!tipos.contains(tipo4))
            tipos.add(tipo4);
        if (!tipos.contains(tipo5))
            tipos.add(tipo5);

        for(Tipo t : tipos)
            System.out.println(t);
        //TIPOS DE PUBLICACION
        //LUGAR
        System.out.println("\n----Lugares----\n");
        Lugar lugar1 = new Lugar("Lugar 1");
        Lugar lugar2 = new Lugar("Lugar 1");
        Lugar lugar3 = new Lugar("Lugar 3");
        Lugar lugar4 = new Lugar("Lugar 4");
        Lugar lugar5 = new Lugar("Lugar 5");
        
        if (!lugares.contains(lugar1))
            lugares.add(lugar1);
        if (!lugares.contains(lugar2))
            lugares.add(lugar2);
        if (!lugares.contains(lugar3))
            lugares.add(lugar3);
        if (!lugares.contains(lugar4))
            lugares.add(lugar4);
        if (!lugares.contains(lugar5))
            lugares.add(lugar5);

        for(Lugar l : lugares)
            System.out.println(l);
        //LUGAR
        
        //IDIOMAS
        System.out.println("\n----Idiomas----\n");
        Idioma idioma1 = new Idioma("Idioma 1");
        Idioma idioma2 = new Idioma("Idioma 2");
        Idioma idioma3 = new Idioma("Idioma 3");
        Idioma idioma4 = new Idioma("Idioma 4");
        Idioma idioma5 = new Idioma("Idioma 5");
        
        if (!idiomas.contains(idioma1))
            idiomas.add(idioma1);
        if (!idiomas.contains(idioma2))
            idiomas.add(idioma2);
        if (!idiomas.contains(idioma3))
            idiomas.add(idioma3);
        if (!idiomas.contains(idioma4))
            idiomas.add(idioma4);
        if (!idiomas.contains(idioma5))
            idiomas.add(idioma5);

        for(Idioma i : idiomas)
            System.out.println(i);        
        //IDIOMAS
        //PALABRASCLAVE
        System.out.println("\n----Palabras clave----\n");
        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
        PalabraClave palabraClave2 = new PalabraClave("PalabraClave2");
        PalabraClave palabraClave3 = new PalabraClave("PalabraClave3");
        PalabraClave palabraClave4 = new PalabraClave("PalabraClave4");
        PalabraClave palabraClave5 = new PalabraClave("PalabraClave5");

        if (!palabrasClaves.contains(palabraClave1))
            palabrasClaves.add(palabraClave1);
        if (!palabrasClaves.contains(palabraClave2))
            palabrasClaves.add(palabraClave2);
        if (!palabrasClaves.contains(palabraClave3))
            palabrasClaves.add(palabraClave3);
        if (!palabrasClaves.contains(palabraClave4))
            palabrasClaves.add(palabraClave4);
        if (!palabrasClaves.contains(palabraClave5))
            palabrasClaves.add(palabraClave5);
        

        for(PalabraClave pc : palabrasClaves)
            System.out.println(pc); 
        //PALABRASCLAVE
        
        /*
        Para un objeto de la clase publicación:
        Titulo
        Miembro en grupo
        Fecha
        Tipo
        Idioma
        Lugar
        Lista de palabras clave
        Enlace
        Resumen
        */
        //PUBLICACION 1
        MiembroEnGrupo mg1=new MiembroEnGrupo(autores.get(0), grupos.get(0), Rol.ADMINISTRADOR);
        LocalDate fecha1= LocalDate.of(2020, 06, 24);
        ArrayList<PalabraClave> palabras1 = new ArrayList<>();
        palabras1.add(palabraClave1);
        palabras1.add(palabraClave2);
        palabras1.add(palabraClave3);
        Publicacion publicacion1 = new Publicacion("Título 1",mg1, fecha1, tipos.get(0), idiomas.get(0), lugares.get(0), palabras1, "Enlace 1", "Resumen 1");
        //PUBLICACION 1
        
        //PUBLICACION 2
        ArrayList<PalabraClave> palabras2 = new ArrayList<>();
        palabras2.add(palabraClave4);
        palabras2.add(palabraClave5);
        Publicacion publicacion2 = new Publicacion("Título 2", new MiembroEnGrupo(profesor2, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo2, idioma2, lugar2, palabras2, "Enlace 2", "Resumen 2");
        //PUBLICACION 2
        //PUBLICACION 3
        MiembroEnGrupo mg3 = new MiembroEnGrupo(profesor2, grupo2, Rol.COLABORADOR);
        LocalDate fecha3= LocalDate.of(2020, 06, 24);
        ArrayList<PalabraClave> palabras3 = new ArrayList<>();
        palabras3.add(palabraClave1);
        palabras3.add(palabraClave3);
        palabras3.add(palabraClave4);
        Publicacion publicacion3 = new Publicacion("Título 3",mg3, fecha3 , tipos.get(0), idiomas.get(1), lugares.get(1), palabras3, "Enlace 3", "Resumen 3");
        //PUBLICACION 3
        //PUBLICACION 4
        ArrayList<PalabraClave> palabras4 = new ArrayList<>();
        palabras4.add(palabraClave1);
        Publicacion publicacion4 = new Publicacion("Título 4", new MiembroEnGrupo(profesor4, grupo3, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo4, idioma2, lugar5, palabras4, "Enlace 4", "Resumen 4");
        //PUBLICACION 4
        //PUBLICACION 5
        ArrayList<PalabraClave> palabras5 = new ArrayList<>();
        palabras5.add(palabraClave2);
        palabras5.add(palabraClave3);
        palabras5.add(palabraClave4);
        Publicacion publicacion5 = new Publicacion("Título 5", new MiembroEnGrupo(profesor4, grupo5, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo5, idioma3, lugar5, palabras5, "Enlace 5", "Resumen 5");
        //PUBLICACION 5
        publicaciones.add(publicacion1);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion4);
        publicaciones.add(publicacion5);
      
        for(Publicacion p : publicaciones) {
            p.mostrar();
            System.out.println();
        }

      //</editor-fold>   
     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
         VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
/*
//        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaGrupo.setVisible(true); //se hace visible la ventana
        
        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
//        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
//        ventanaAlumno.setVisible(true); //se hace visible la ventana
*/        
        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana 
        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
        
        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
        
        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
        
        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
        
        
/*        
        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
//        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
//        ventanaIdioma.setVisible(true); //se hace visible la ventana                
        
//        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
//        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
//        ventanaLugar.setVisible(true); //se hace visible la ventana                        
        
//        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
//        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
//        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
        
//        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
//        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaTipo.setVisible(true); //se hace visible la ventana   
*/

     //</editor-fold>
    }
}

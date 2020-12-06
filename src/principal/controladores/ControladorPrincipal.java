/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.vistas.VentanaAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IControladorPrincipal;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import interfaces.IGestorIdiomas;
import interfaces.IGestorLugares;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import principal.vistas.VentanaPrincipal;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;


/**
 *
 * @author prog2
 */
public class ControladorPrincipal  implements IControladorPrincipal{
    private VentanaPrincipal ventana;

    public ControladorPrincipal() {
        this.ventana = new VentanaAutores(this, null, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnGruposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAutoresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public static void main(String[] args) {
          
//        System.out.println("------------------Gestores------------------");
        IGestorAutores autor = GestorAutores.crear();
        IGestorLugares lugar = GestorLugares.crear();
        IGestorIdiomas idioma = GestorIdiomas.crear();
        IGestorTipos tipo = GestorTipos.crear();
        IGestorPalabrasClaves palabraClave = GestorPalabrasClaves.crear();
        IGestorGrupos grupo = GestorGrupos.crear();
        IGestorPublicaciones publicacion = GestorPublicaciones.crear();
        
        System.out.println("------------------INGRESO DE AUTORES------------------");
        System.out.println(autor.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));
        System.out.println(autor.nuevoAutor(20, "Apellido20", "Nombre20", Cargo.ASOCIADO, "Clave20", "Clave20"));
        System.out.println(autor.nuevoAutor(10, "Apellido10", "Nombre10", Cargo.TITULAR, "Clave10", "Clave10"));//PROF REPETIDO
        System.out.println(autor.nuevoAutor(1, "Apellido1", "Nombre1", "cx1", "Clave1", "Clave1"));
        System.out.println(autor.nuevoAutor(1, "Apellido1", "Nombre1", "cx1", "Clave1", "Clave1"));//ALUM REPETIDO
        System.out.println(autor.nuevoAutor(10, "Apellido2", "Nombre2", "cx2", "Clave2", "Clave2"));//DNI REPETIDO CON PROF
        System.out.println(autor.nuevoAutor(1, "Apellido1", "Nombre1", Cargo.ADG, "Clave1", "Clave1"));//DNI REPETIDO CON ALUM
        System.out.println(autor.nuevoAutor(1, "", "Nombre1", "cx1", "Clave1", "Clave1"));//datos vacios
        System.out.println(autor.nuevoAutor(20, "Apellido20", "Nombre20", Cargo.ASOCIADO, null, "Clave20"));//datos nulos
        System.out.println("------------------------------------------------------");
        
        System.out.println("------------------INGRESO DE IDIOMAS------------------");
        System.out.println(idioma.nuevoIdioma("ingles"));
        System.out.println(idioma.nuevoIdioma("ingles"));//REPETIDO
        System.out.println(idioma.nuevoIdioma("español"));
        System.out.println(idioma.nuevoIdioma(""));//VACIO
        System.out.println(idioma.nuevoIdioma(null));//NULO
        System.out.println("------------------------------------------------------");
        
        System.out.println("------------------INGRESO DE TIPOS------------------");
        System.out.println(tipo.nuevoTipo("tipo2"));
        System.out.println(tipo.nuevoTipo("tipo1"));
        System.out.println(tipo.nuevoTipo("tipo1"));//REPETIDO
        System.out.println(tipo.nuevoTipo(""));//VACIO
        System.out.println(tipo.nuevoTipo(null));//NULO
        System.out.println("------------------------------------------------------");
        
        System.out.println("------------------INGRESO DE LUGARES------------------");
        System.out.println(lugar.nuevoLugar("lugar1"));
        System.out.println(lugar.nuevoLugar("lugar1"));//REPETIDO
        System.out.println(lugar.nuevoLugar("lugar2"));
        System.out.println(lugar.nuevoLugar(""));//VACIO
        System.out.println(lugar.nuevoLugar(null));//NULO
        System.out.println("------------------------------------------------------");
        
        System.out.println("------------------INGRESO DE PALABRAS CLAVE------------------");
        System.out.println(palabraClave.nuevaPalabraClave("pc1"));
        System.out.println(palabraClave.nuevaPalabraClave("pc1"));//REPETIDO
        System.out.println(palabraClave.nuevaPalabraClave("pc2"));
        System.out.println(palabraClave.nuevaPalabraClave(""));//VACIO
        System.out.println(palabraClave.nuevaPalabraClave(null));//NULO
        ArrayList<PalabraClave> palabrasclave1 = new ArrayList<>();
        ArrayList<PalabraClave> palabrasclave2 = new ArrayList<>();
        palabrasclave1.add(palabraClave.verPalabraClave("pc1"));
        palabrasclave1.add(palabraClave.verPalabraClave("pc2"));
        palabrasclave2.add(palabraClave.verPalabraClave("pc2"));
        System.out.println("------------------------------------------------------");
        
        System.out.println("------------------INGRESO DE GRUPOS------------------");
        System.out.println(grupo.nuevoGrupo("grupo1", "descricpion1"));
        System.out.println(grupo.nuevoGrupo("grupo1", "descricpion1"));//REPETIDO
        System.out.println(grupo.nuevoGrupo("grupo2", "descricpion2"));
        System.out.println(grupo.nuevoGrupo("Super Administradores", "Grupo para los super administradores"));
        System.out.println(grupo.nuevoGrupo("", ""));//VACIO
        System.out.println(grupo.nuevoGrupo(null, null));//NULO
        System.out.println("-----------------------------------------------------");
        
        System.out.println("------------------INGRESO DE PUBLICACIONES------------------");
        MiembroEnGrupo mg1 = new MiembroEnGrupo(autor.verAutor(20), grupo.verGrupo("grupo1"), Rol.COLABORADOR);
        MiembroEnGrupo mg2 = new MiembroEnGrupo(autor.verAutor(10), grupo.verGrupo("grupo2"), Rol.ADMINISTRADOR);
        LocalDate fecha1= LocalDate.of(2020, 06, 24);
        LocalDate fecha2= LocalDate.of(2020, 06, 26);
        LocalDate fecha3= LocalDate.of(2023, 05, 20);
        
        System.out.println(publicacion.nuevaPublicacion("publicacion1", mg1, fecha1, tipo.verTipo("tipo1"), idioma.verIdioma("ingles"), lugar.verLugar("lugar1"), palabrasclave1, "enlace1", "resumen1"));
        System.out.println(publicacion.nuevaPublicacion("publicacion1", mg1, fecha1, tipo.verTipo("tipo1"), idioma.verIdioma("ingles"), lugar.verLugar("lugar1"), palabrasclave1, "enlace1", "resumen1"));//REPETIDO
        System.out.println(publicacion.nuevaPublicacion("publicacion2", mg2, fecha2, tipo.verTipo("tipo2"), idioma.verIdioma("español"), lugar.verLugar("lugar2"), palabrasclave2, "enlace2", "resumen2"));
        System.out.println(publicacion.nuevaPublicacion("", mg1, fecha3, tipo.verTipo("tipo2"), idioma.verIdioma("español"), lugar.verLugar("lugar1"), palabrasclave1, "", ""));//VACIO
        System.out.println(publicacion.nuevaPublicacion(null, null, null, null, null, null, null, null, null));//NULO
        System.out.println("-----------------------------------------------------");
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println("------------------AUTORES------------------");
        autor.verAutores();
        System.out.println("------------------ALUMNOS------------------");
        autor.verAlumnos();
        System.out.println("------------------PROFESORES------------------");
        autor.verProfesores();
        
        idioma.verIdiomas();
        
        lugar.verLugares();
        
        tipo.verTipos();
        
        palabraClave.verPalabrasClaves();
        
        grupo.verGrupos();
        
        publicacion.verPublicaciones();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        idioma.verIdioma("español").mostrar();
        lugar.verLugar("lugar1").mostrar();
        tipo.verTipo("tipo1").mostrar();
        palabraClave.verPalabraClave("pc2").mostrar();
        grupo.verGrupo("grupo1").mostrar();
        publicacion.verPublicacion("publicacion1").mostrar();
        
        
        
        autor.verAutor(10).mostrar();
        autor.verAutor(1).mostrar();
      
        System.out.println("------------------METODOS VARIOS------------------");
        
        System.out.println("\n------------------Agregado de grupo a un miembro------------------\n");
        autor.verAutor(1).agregarGrupo(grupo.verGrupo("Super Administradores"), Rol.COLABORADOR);
        autor.verAutor(10).agregarGrupo(grupo.verGrupo("grupo1"), Rol.COLABORADOR);
        autor.verAutor(1).mostrar();
        autor.verAutor(10).mostrar();
        grupo.verGrupo("Super Administradores").mostrar();
        grupo.verGrupo("grupo1").mostrar();
        System.out.println(grupo.verGrupo("Super Administradores").esSuperAdministradores());
        System.out.println(grupo.verGrupo("grupo1").esSuperAdministradores());
        
        System.out.println("\n------------------Borrado de un grupo------------------\n");
        System.out.println(grupo.borrarGrupo(grupo.verGrupo("Super Administradores")));
        System.out.println(grupo.borrarGrupo(grupo.verGrupo("grupo2")));
        
        grupo.verGrupos();
        
        System.out.println("\n------------------Borrado de un autor------------------\n");
        System.out.println(autor.borrarAutor(autor.verAutor(1)));
        System.out.println(autor.borrarAutor(autor.verAutor(20)));
        
        autor.verAutores();
        
        System.out.println("\n------------------Borrado de una Publicación------------------\n");
        System.out.println(publicacion.borrarPublicacion(publicacion.verPublicacion("publicacion1")));
        
        publicacion.verPublicaciones();
        
        System.out.println("\n------------------Borrado de un Autor luego de borrar una Publicación que lo contenía------------------\n");
        System.out.println(autor.borrarAutor(autor.verAutor(20)));
        autor.verAutores();
        
        System.out.println("\n------------------Busqueda de un Autor------------------\n");
        autor.buscarProfesores("10");
        autor.buscarAlumnos("A");
        
        System.out.println("\n------------------Busqueda de un Idioma------------------\n");
        idioma.buscarIdiomas("l");

      //</editor-fold>   
        
    //     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
//         VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
///*
////        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaGrupo.setVisible(true); //se hace visible la ventana
//        
////        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
////        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
////        ventanaAlumno.setVisible(true); //se hace visible la ventana
//*/        
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        
///*        
////        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
////        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
////        ventanaIdioma.setVisible(true); //se hace visible la ventana                
//        
////        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
////        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
////        ventanaLugar.setVisible(true); //se hace visible la ventana                        
//        
////        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
////        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
////        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
//        
////        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
////        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaTipo.setVisible(true); //se hace visible la ventana   
//*/
//
//     //</editor-fold>
    }
}

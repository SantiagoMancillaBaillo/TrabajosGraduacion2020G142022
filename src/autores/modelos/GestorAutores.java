/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Windows 10
 */
public class GestorAutores implements IGestorAutores {
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private ArrayList<Profesor> profesores2 = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Alumno> alumnos2 = new ArrayList<>();
    private static GestorAutores instanciaAutores;
    
    private GestorAutores(){
        
    }
    
    public static GestorAutores crear(){
        if(instanciaAutores == null)
            instanciaAutores = new GestorAutores();
        return instanciaAutores;
    }
    
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if ((dni != 0) && (apellidos != null && !apellidos.isBlank()) && (nombres != null && !nombres.isBlank()) && (cargo != null) && (clave != null && !clave.isBlank()) && (claveRepetida != null && !claveRepetida.isBlank())){
            Autor a = new Profesor(dni, apellidos, nombres, clave, cargo);
            Profesor p = new Profesor (dni, apellidos, nombres, clave, cargo);
            if(!this.autores.contains(a)){
                this.autores.add(a);
                this.profesores.add(p);
                return AMENSAJE_EXITO;
            }
            else
                return AMENSAJE_REPETIDO;
        }
        else
            return AMENSAJE_ERROR;
    }

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        if ((dni != 0) && (apellidos != null && !apellidos.isBlank()) && (nombres != null && !nombres.isBlank()) && (cx != null && !cx.isBlank()) && (clave != null && !clave.isBlank()) && (claveRepetida != null && !claveRepetida.isBlank())){
            Autor a = new Alumno (dni, apellidos, nombres, clave, cx);
            Alumno al = new Alumno (dni, apellidos, nombres, clave, cx);
            if(!this.autores.contains(a)){
                this.autores.add(a);
                this.alumnos.add(al);
                
                return AMENSAJE_EXITO;
            }
            else
                return AMENSAJE_REPETIDO;
        }
        else
            return AMENSAJE_ERROR;
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if(apellidos!=null&&!apellidos.isBlank()&&nombres!=null&&!nombres.isBlank()&&cargo!=null&&clave.equals(claveRepetida)) {
            if(existeEsteAutor(autor)){
                Profesor p = new Profesor(autor.verDni(), apellidos, nombres, clave, cargo);
                autores.set(autores.indexOf(autor), p);
                profesores.set(autores.indexOf(autor), p);
                return AmodMENSAJE_EXITO;
            }
            else
                return AmodMENSAJE_NO_EXISTE;
        }
        else
            return AodMENSAJE_ERROR;
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        if ((apellidos != null && !apellidos.isBlank()) && (nombres != null && !nombres.isBlank()) && (cx != null && !cx.isBlank()) && (clave != null && !clave.isBlank() && clave.equals(claveRepetida)) && (claveRepetida != null && !claveRepetida.isBlank())){
            if(existeEsteAutor(autor)){
                Alumno al = new Alumno(autor.verDni(), apellidos, nombres, clave, cx);
                autores.set(autores.indexOf(autor), al);
                alumnos.set(autores.indexOf(autor), al);
                return AmodMENSAJE_EXITO;
            }
            else
                return AmodMENSAJE_NO_EXISTE;
        }
        else
            return AodMENSAJE_ERROR;
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        boolean existe = false;
        if(autores.contains(autor)){
            existe = true;
        }
        else{
            existe = false;
        }
                
        return existe;
    }

    @Override
    public Autor verAutor(int dni) {
        if(dni != 0){
        Alumno al = new Alumno (dni, null, null, null, null);
        Profesor p = new Profesor (dni, null, null, null, null);
            for(Autor a : autores){
                if(p.verDni() == a.verDni()){
//                    System.out.println("DNI ENCONTRADO:" + a.verDni());
//                    a.mostrar();
                    return a;
                }
                if(al.verDni() == a.verDni()){
//                    System.out.println("DNI ENCONTRADO:" + a.verDni());
//                    a.mostrar();
                    return a;
                }
            }
        }
        return null;
    }



    @Override
    public ArrayList<Autor> verAutores() {
        System.out.println("--------------AUTORES--------------");
        Collections.sort(autores);
        for(Autor a : autores){
            a.mostrar();
        }
        return autores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        System.out.println("--------------PROFESORES--------------");
        Collections.sort(profesores);
        for(Profesor p : profesores){
            p.mostrar();
        }
        return profesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        System.out.println("--------------ALUMNOS--------------");
        Collections.sort(alumnos);
        for(Alumno al: alumnos){
            al.mostrar();
        }
        return alumnos;
    }

    @Override
    public String borrarAutor(Autor autor) {
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        GestorGrupos gg = GestorGrupos.crear();
        if(existeEsteAutor(autor) && gp.hayPublicacionesConEsteAutor(autor)){
                return AborrarMENSAJE_ERROR;
        }
        if(existeEsteAutor(autor) && !gp.hayPublicacionesConEsteAutor(autor)){
            this.autores.remove(autor);
            this.alumnos.remove(autor);
            this.profesores.remove(autor);
            for(Grupo g : gg.verListaGrupos()){
                g.quitarMiembro(autor);
            }
            return AborrarMENSAJE_EXITO;
        }
        else
            return AborrarMENSAJE_NO_EXISTE;
    }

    @Override
    public List<Profesor> buscarProfesores(String apellidos) {
        this.profesores2.clear();
        if(apellidos == null || apellidos.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Profesor p : profesores){
                if(p.verApellidos().contains(apellidos)){
                    profesores2.add(p);
                }
            }
            Collections.sort(this.profesores2);
            for(Profesor p : profesores2){
                p.mostrar();
            }
            
        }
        return profesores2;
    }

    @Override
    public List<Alumno> buscarAlumnos(String apellidos) {
        this.alumnos2.clear();
        if(apellidos == null || apellidos.isBlank()){
            System.out.println("No se puede buscar. No se proporcionó ningun nombre");
        }
        else{
            for(Alumno al : alumnos){
                if(al.verApellidos().contains(apellidos)){
                    alumnos2.add(al);
                }
            }
            Collections.sort(this.alumnos2);
            for(Alumno al : alumnos2){
                al.mostrar();
            }
            
        }
        return alumnos2;
    }

    @Override
    public boolean hayAutoresConEsteGrupo(Grupo grupo) {
        boolean existe = false;
        for(Autor a : autores){
            if(a.verListaGrupos().contains(grupo)){
                existe = true;
                break;
            }
            else{
                for(Alumno al : alumnos){
                    if(al.verListaGrupos().contains(grupo)){
                        existe = true;
                        break;
                    }
                    else{
                        for(Profesor p : profesores){
                            if(p.verListaGrupos().contains(grupo)){
                                existe = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return existe;
    }


    
    
    
}

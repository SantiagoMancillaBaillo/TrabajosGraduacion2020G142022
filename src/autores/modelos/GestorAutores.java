/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import interfaces.IGestorAutores;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class GestorAutores implements IGestorAutores {
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();
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
        Autor p = new Profesor(autor.verDni(), apellidos, nombres, clave, cargo);
        for(Autor a : autores){
            if(autores.contains(autor) && (apellidos != null && !apellidos.isBlank()) && (nombres != null && !nombres.isBlank()) && (cargo != null)){
                
                p.asignarApellidos(apellidos);
                p.asignarNombres(nombres);
                p.asignarClave(clave);
//                p.asignarCargo(cargo);
                
            }
        }
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Alumno al = new Alumno (dni, null, null, null, null);
        Profesor p = new Profesor (dni, null, null, null, null);
            for(Autor a : autores)
                if(p.verDni() == a.verDni() || al.verDni() == a.verDni()){
                    System.out.println("DNI ENCONTRADO:" + a.verDni());
                    a.mostrar();
                    return a;
                }
            return null;
    }



    @Override
    public ArrayList<Autor> verAutores() {
        System.out.println("--------------AUTORES--------------");
        for(Autor a : autores){
            a.mostrar();
        }
        return autores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        System.out.println("--------------PROFESORES--------------");
        for(Profesor p : profesores){
            p.mostrar();
        }
        return profesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        System.out.println("--------------ALUMNOS--------------");
        for(Alumno al: alumnos){
            al.mostrar();
        }
        return alumnos;
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

//import java.util.ArrayList;
import java.util.List;
import palabrasclaves.modelos.PalabraClave;

/**
 *
 * @author Windows 10
 */
public interface IGestorPalabrasClaves {
    public static final String PMENSAJE_EXITO = "Se creó la Palabra Clave correctamente";
    public static final String PMENSAJE_REPETIDO = "No se creó la Palabra Clave. Motivo: ya existe una con ese nombre";
    public static final String PMENSAJE_ERROR = "No se creó la Palabra Clave. Motivo: datos incorrectos (No se pueden agregar datos vacios o nulos)";
    public static final String PborrarMENSAJE_EXITO = "Se borró la Palabra Clave correctamente";
    public static final String PborrarMENSAJE_ERROR = "No se borró la Palabra Clave pues hay una publicación que contiene esta palabra clave.";
    public static final String PborrarMENSAJE_NO_EXISTE = "No se borró la Palabra Clave, no hay palabras clave con ese nombre";
    public String nuevaPalabraClave(String nombre);
    public List<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
    public String borrarPalabraClave(PalabraClave palabraClave);
    public List<PalabraClave> buscarPalabrasClaves(String nombre);
    public boolean existeEstaPalabraClave(PalabraClave palabraClave);
    }

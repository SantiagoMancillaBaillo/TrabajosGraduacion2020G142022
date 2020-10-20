/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import cargos.modelos.Cargo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class Profesor extends Autor {
//    private int dni;
//    private String apellidos; 
//    private String nombres;
//    private String clave
    private Cargo cargo;
    private ArrayList<MiembroEnGrupo> grupoMiembro = new ArrayList<>();
    
    public Profesor (int dni, String apellidos, String nombres, String clave, Cargo cargo){
            super(dni, apellidos, nombres, clave);
            this.cargo = cargo;
    }

    public Profesor(int dni, String apellidos, String nombres, String clave) {
        super(dni, apellidos, nombres, clave);
    }

    public Cargo verCargo(){
        return cargo;
    }
    public void asignarCargo(Cargo cargo){
        this.cargo = cargo;
    }

//[nro_documento] Apellido, Nombres por ejemplo: [30759167] Gimenez, María José
    @Override
    public void mostrar(/*String u*/){
        System.out.println("....Profesor....");
        System.out.println("Autor: ["+ super.verDni()+"] " + super.verApellidos().toUpperCase() + ", " + super.verNombres());
//        System.out.println("DNI: " + super.getDni());
        System.out.println("Cargo: " + this.verCargo());
        super.mostrar(1,1,1);
        System.out.println("..............");
    }
}

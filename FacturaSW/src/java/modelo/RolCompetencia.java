/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class RolCompetencia {

    private Rol rol;
    private Competencia competencia;

    public RolCompetencia() {
    }

    public RolCompetencia(Rol rol, Competencia competencia) {
        this.rol = rol;
        this.competencia = competencia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    @Override
    public String toString() {
        return "RolCompetencia{" + "rol=" + rol + ", competencia=" + competencia + '}';
    }

}

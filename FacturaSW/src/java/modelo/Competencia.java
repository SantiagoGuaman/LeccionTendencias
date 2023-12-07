/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Competencia {

    private int id_competencia;
    private String nombreCompetencia;
    private String descripcionComptencia;
    List<RolCompetencia> rolCompetencia;

    public Competencia() {
    }

    public Competencia(int id_competencia, String nombreCompetencia, String descripcionComptencia) {
        this.id_competencia = id_competencia;
        this.nombreCompetencia = nombreCompetencia;
        this.descripcionComptencia = descripcionComptencia;
    }

    public Competencia(int id_competencia, String nombreCompetencia, String descripcionComptencia, List<RolCompetencia> rolCompetencia) {
        this.id_competencia = id_competencia;
        this.nombreCompetencia = nombreCompetencia;
        this.descripcionComptencia = descripcionComptencia;
        this.rolCompetencia = rolCompetencia;
    }

    public int getId_competencia() {
        return id_competencia;
    }

    public void setId_competencia(int id_competencia) {
        this.id_competencia = id_competencia;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public String getDescripcionComptencia() {
        return descripcionComptencia;
    }

    public void setDescripcionComptencia(String descripcionComptencia) {
        this.descripcionComptencia = descripcionComptencia;
    }

    public List<RolCompetencia> getRolCompetencia() {
        return rolCompetencia;
    }

    public void setRolCompetencia(List<RolCompetencia> rolCompetencia) {
        this.rolCompetencia = rolCompetencia;
    }

    @Override
    public String toString() {
        return "Competencia{" + "id_competencia=" + id_competencia + ", nombreCompetencia=" + nombreCompetencia + ", descripcionComptencia=" + descripcionComptencia + ", rolCompetencia=" + rolCompetencia + '}';
    }

}

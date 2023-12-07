/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Clasificacion {

    private int id_competencia;
    private String grupo;

    public Clasificacion() {
    }

    public Clasificacion(int id_competencia, String grupo) {
        this.id_competencia = id_competencia;
        this.grupo = grupo;
    }

    public int getId_competencia() {
        return id_competencia;
    }

    public void setId_competencia(int id_competencia) {
        this.id_competencia = id_competencia;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Clasificacion{" + "id_competencia=" + id_competencia + ", grupo=" + grupo + '}';
    }

}

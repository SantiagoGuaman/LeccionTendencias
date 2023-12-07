/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Rol {

    private int id_rol;
    private String nombreRol;
    private boolean estado;
    private UsuarioRol usuarioRol;

    public Rol() {
    }

    public Rol(int id_rol, String nombreRol, boolean estado) {
        this.id_rol = id_rol;
        this.nombreRol = nombreRol;
        this.estado = estado;
    }

    public Rol(int id_rol, String nombreRol, boolean estado, UsuarioRol usuarioRol) {
        this.id_rol = id_rol;
        this.nombreRol = nombreRol;
        this.estado = estado;
        this.usuarioRol = usuarioRol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", nombreRol=" + nombreRol + ", estado=" + estado + ", usuarioRol=" + usuarioRol + '}';
    }

}

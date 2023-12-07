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
public class Usuario {

    private int id_usuario;
    private Persona persona;
    private String user;
    private String password;
    private List<UsuarioRol> usuarioRol;
    
    public Usuario() {
    }

    public Usuario(int id_usuario, Persona persona, String user, String password) {
        this.id_usuario = id_usuario;
        this.persona = persona;
        this.user = user;
        this.password = password;
    }

    public Usuario(int id_usuario, Persona persona, String user, String password, List<UsuarioRol> usuarioRol) {
        this.id_usuario = id_usuario;
        this.persona = persona;
        this.user = user;
        this.password = password;
        this.usuarioRol = usuarioRol;
    }

    
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UsuarioRol> getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(List<UsuarioRol> usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", persona=" + persona + ", user=" + user + ", password=" + password + '}';
    }

    //public abstract boolean siExiste(String us, String pass);
    
}

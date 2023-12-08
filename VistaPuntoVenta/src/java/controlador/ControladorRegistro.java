/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import vista.Login;
import vista.Registro;
import ws.Competencia;
import ws.Persona;
import ws.Rol;
import ws.Usuario;
import ws.PuntoVentaOperaciones_Service;
import ws.PuntoVentaOperaciones;
/**
 *
 * @author Usuario
 */
public class ControladorRegistro {

    private final Registro vista;
    private final PuntoVentaOperaciones_Service servicio;
    private final PuntoVentaOperaciones servicios;

    public ControladorRegistro(Registro vista) {
        this.vista = vista;
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void iniciarControl() {
        vista.getBtnRegistrar().addActionListener(l -> registrarUsuario());
        vista.getBtnIrInicio().addActionListener(l -> irInicio());
    }

    private void registrarUsuario() {
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();
        String cedula = vista.getTxtDni().getText().trim();
        String celular = vista.getTxtCelular().getText().trim();
        String correo = vista.getTxtCorreo().getText().trim();
        String username = vista.getTxtUser().getText().trim();
        String clave = vista.getTxtClave().getText().trim();

        Persona per = new Persona();
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setDni(cedula);
        per.setCelular(celular);
        per.setCorreo(correo);
        
        Usuario usuario = new Usuario();
        usuario.setUser(username);
        usuario.setPassword(servicios.encrypt(clave));

        if (servicios.registrarPersona(per, usuario, new Rol(), new Competencia())) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            /*Producto pr = new Producto();
            ControladorProducto control = new ControladorProducto(pr);
            control.iniciarControl();*/
            this.vista.dispose();
        } else {
            String error = "No se ha podido crear el usuario";
            vista.getLblError().setText(error);
        }
    }

    private void irInicio() {
        Login vistal = new Login();
        ControladorPrincipal control = new ControladorPrincipal(vistal);
        control.iniciarControl();
        this.vista.dispose();
    }
}

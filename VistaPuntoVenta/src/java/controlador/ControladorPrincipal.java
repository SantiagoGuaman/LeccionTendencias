/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import vista.Login;
import vista.Producto;
import vista.Registro;
import ws.PuntoVentaOperaciones_Service;
import ws.PuntoVentaOperaciones;
/**
 *
 * @author Usuario
 */
public class ControladorPrincipal {

    private final Login loginVista;
    private final PuntoVentaOperaciones_Service servicio;
    private final PuntoVentaOperaciones servicios;

    public ControladorPrincipal(Login vista) {
        this.loginVista = vista;
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void iniciarControl() {
        loginVista.getBtnLogin().addActionListener(l -> iniciarSesion());
        loginVista.getBtnIrRegistro().addActionListener(l -> irRegistro());
    }

    private void iniciarSesion() {
        String user = loginVista.getTxtUsuario().getText().trim();
        char[] clave = loginVista.getTxtClave().getPassword();
        System.out.println(clave);
        if (servicios.siExisteUsuario(user, servicios.encrypt(new String(clave)))) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
            Producto vistaP = new Producto();
            ControladorProducto control = new ControladorProducto(vistaP);
            control.iniciarControl();
            this.loginVista.dispose();

        } else {
            String error = "Credenciales incorrectas";
            loginVista.getLblError().setText(error);
        }
    }

    private void irRegistro() {
        Registro vista = new Registro();
        ControladorRegistro control = new ControladorRegistro(vista);
        control.iniciarControl();
        this.loginVista.dispose();
    }
}
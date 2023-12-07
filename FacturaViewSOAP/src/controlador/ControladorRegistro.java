/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Login;
import vista.Registro;

/**
 *
 * @author Usuario
 */
public class ControladorRegistro {

    private Registro vista;

    public ControladorRegistro(Registro vista) {
        this.vista = vista;
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

        if (3 < 2) {
            
        } else {
            String error = "No se ha podido crear el usuario";
            vista.getLblError().setText(error);
        }
    }
    
    private void irInicio(){
        Login vistal = new Login();
        ControladorPrincipal control = new ControladorPrincipal(vistal);
        control.iniciarControl();
        this.vista.dispose();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.Login;
import vista.Producto;
import vista.Registro;

/**
 *
 * @author Usuario
 */
public class ControladorPrincipal {
    private Login loginVista;
    
    public ControladorPrincipal(Login vista){
        this.loginVista = vista;
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void iniciarControl(){
        loginVista.getBtnLogin().addActionListener(l->iniciarSesion());
        loginVista.getBtnIrRegistro().addActionListener(l -> irRegistro());
    }
    
    private void iniciarSesion(){
        String user = loginVista.getTxtUsuario().getText().trim();
        String clave = loginVista.getTxtClave().getText().trim();

        if(1 > 2){
            JOptionPane.showMessageDialog(null, "Inicio de sesión correcot");
            Producto vistaP = new Producto();
            ControladorProducto control = new ControladorProducto(vistaP);
            control.iniciarControl();
            this.loginVista.dispose();
            
        } else{
            String error = "Credenciales incorrectas";
            loginVista.getLblError().setText(error);
        }
    }
    
    private void irRegistro(){
        Registro vista = new Registro();
        ControladorRegistro control = new ControladorRegistro(vista);
        control.iniciarControl();
        this.loginVista.dispose();
    }
}

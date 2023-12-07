/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturaviewsoap;

import controlador.ControladorPrincipal;
import vista.Login;

/**
 *
 * @author Usuario
 */
public class FacturaViewSOAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        ControladorPrincipal control = new ControladorPrincipal(login);
        
        control.iniciarControl();
    }
    
}

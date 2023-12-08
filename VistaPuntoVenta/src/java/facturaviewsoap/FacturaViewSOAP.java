/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturaviewsoap;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import controlador.ControladorCompra;
import controlador.ControladorPrincipal;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Compra;
import vista.Login;
import ws.PuntoVentaOperaciones;
import ws.PuntoVentaOperaciones_Service;

/**
 *
 * @author Usuario
 */
public class FacturaViewSOAP {

    PuntoVentaOperaciones_Service service = new PuntoVentaOperaciones_Service();
    PuntoVentaOperaciones cliente = service.getPuntoVentaOperacionesPort();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            Login login = new Login();
            ControladorPrincipal control = new ControladorPrincipal(login);
            control.iniciarControl();

        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
    }

}

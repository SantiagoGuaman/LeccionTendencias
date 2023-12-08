/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Compra;
import vista.Login;
import vista.PanelControl;
import vista.Producto;
import ws.PuntoVentaOperaciones;
import ws.PuntoVentaOperaciones_Service;

/**
 *
 * @author Usuario
 */
public class ControladorPanel {
    private PanelControl vista;
    private PuntoVentaOperaciones_Service servicio;
    private PuntoVentaOperaciones servicios;

    public ControladorPanel(PanelControl vista) {
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void iniciarControl(){
        vista.getBtnCompra().addActionListener(l -> irCompra());
        vista.getBtnProducto().addActionListener(l -> irProducto());
        vista.getBtnCerrrar().addActionListener(l -> cerrarSesion());
    }
    
    private void irCompra(){
        Compra vistac = new Compra();
        ControladorCompra control = new ControladorCompra(vistac);
        control.iniciarControl();
        this.vista.dispose();
    }
    
    private void irProducto(){
        Producto vistap = new Producto();
        ControladorProducto control = new ControladorProducto(vistap);
        control.iniciarControl();
        this.vista.dispose();
    }
    
    private void refresh(){
        
    }
    
    private void cerrarSesion(){
        Login vistal = new Login();
        ControladorPrincipal control = new ControladorPrincipal(vistal);
        control.iniciarControl();
        this.vista.dispose();
    }
}

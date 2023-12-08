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

    private final PanelControl vista;
    private final PuntoVentaOperaciones_Service servicio;
    private final PuntoVentaOperaciones servicios;

    private static int NO_REFRESH = 0;

    public ControladorPanel(PanelControl vista) {
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void iniciarControl() {
        vista.getBtnCompra().addActionListener(l -> irCompra());
        vista.getBtnProducto().addActionListener(l -> irProducto());
        vista.getBtnCerrrar().addActionListener(l -> cerrarSesion());
        vista.getBtnRefrescar().addActionListener(l -> refresh());
    }

    private void irCompra() {
        Compra vistac = new Compra();
        ControladorCompra control = new ControladorCompra(vistac);
        control.iniciarControl();
        this.vista.dispose();
    }

    private void irProducto() {
        Producto vistap = new Producto();
        ControladorProducto control = new ControladorProducto(vistap);
        control.iniciarControl();
        this.vista.dispose();
    }

    private void refresh() {
        if (NO_REFRESH == 0) {
            servicios.loadData();
            servicios.loadRoles();
            NO_REFRESH++;
        } else {
            vista.getBtnRefrescar().setVisible(false);
            vista.getBtnRefrescar().setEnabled(false);
        }
    }

    private void cerrarSesion() {
        Login vistal = new Login();
        ControladorPrincipal control = new ControladorPrincipal(vistal);
        control.iniciarControl();
        this.vista.dispose();
    }
}

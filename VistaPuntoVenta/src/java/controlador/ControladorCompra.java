/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import vista.Compra;
import ws.Persona;
import ws.Producto;
import ws.PuntoVentaOperaciones_Service;
import ws.PuntoVentaOperaciones;
import ws.TipoPago;

/**
 *
 * @author Usuario
 */
public class ControladorCompra {

    private final Compra vistaCompra;
    private final PuntoVentaOperaciones_Service servicio;
    private final PuntoVentaOperaciones servicios;

    public ControladorCompra(Compra vistaCompra) {
        this.vistaCompra = vistaCompra;
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();
        vistaCompra.setVisible(true);
        vistaCompra.setLocationRelativeTo(null);
    }

    public void iniciarControl() {
        setModelCombox();
        cargarComboCliente();
        cargarComboProducto();
        cargarComboTipoPago();
    }

    /*
    private void cargarListaProducto() {
        List<ws.Producto> listaPr = servicios.getListaProductos();

        for (ws.Producto producto : listaPr) {
            System.out.println(producto.getUnidad());
        }

        DefaultTableModel dt;
        dt = (DefaultTableModel) vista.getTableProductos().getModel();
        dt.setRowCount(0);

        vista.getTableProductos().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        vista.getTableProductos().getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        vista.getTableProductos().getTableHeader().setOpaque(false);
        vista.getTableProductos().getTableHeader().setBackground(new Color(32, 136, 203));
        vista.getTableProductos().getTableHeader().setForeground(new Color(255, 255, 255));
        vista.getTableProductos().setRowHeight(25);

        listaPr.stream().forEach(pr -> {
            String[] fila = {
                pr.getUnidad(),
                Integer.toString(pr.getStock()),
                Double.toString(pr.getPrecioUnitario()),
                Boolean.toString(pr.isIva())
            };
            dt.addRow(fila);
        });
    }
     */
    private void mostrarFrameFactura() {
        vistaCompra.getFrameFactura().setSize(435, 375);
        vistaCompra.setLocationRelativeTo(vistaCompra);
        vistaCompra.getFrameFactura().setVisible(true);
    }

    private void registrarCompra() {

    }

    private void cargarComboTipoPago() {
        vistaCompra.getComboTipoPago().removeAllItems();

        List<TipoPago> lis = servicios.getListaTipoPago();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboTipoPago().addItem(new TipoPago(ob.getTipo()));
        });
    }

    private void cargarComboProducto() {
        vistaCompra.getComboProducto().removeAllItems();

        List<Producto> lis = servicios.getListaProductos();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboProducto().addItem(new Producto(ob.getIdProducto(), ob.getUnidad()));
        });
    }

    private void cargarComboCliente() {
        vistaCompra.getComboClientes().removeAllItems();

        List<Persona> lis = servicios.getListaPersonas();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboClientes().addItem(new Persona(ob.getApellido(), ob.getNombre(), ob.getDni()));
        });
    }

    private void setModelCombox() {
        DefaultComboBoxModel<TipoPago> modelTipoPago = new DefaultComboBoxModel<>();
        vistaCompra.getComboTipoPago().setModel(modelTipoPago);
        DefaultComboBoxModel<Producto> modelProducto = new DefaultComboBoxModel<>();
        vistaCompra.getComboProducto().setModel(modelProducto);
        DefaultComboBoxModel<Persona> modelPersona = new DefaultComboBoxModel<>();
        vistaCompra.getComboClientes().setModel(modelPersona);
    }

}

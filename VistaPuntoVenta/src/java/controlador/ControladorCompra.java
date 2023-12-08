/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Compra;
import ws.Factura;
import ws.ItemFactura;
import ws.LocalDateTime;
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
        vistaCompra.getBtnCompra().addActionListener(l -> registrarCompra());
        vistaCompra.getComboProducto().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    llenarTablaDetalle();
                }
            }
        });
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
    private void llenarFactura() {
        List<ItemFactura> listaItems = servicios.getListaItemsFacturas();
        DefaultTableModel dt;
        dt = (DefaultTableModel) vistaCompra.getTableFactura().getModel();
        dt.setRowCount(0);
        listaItems.get(vistaCompra.getComboProducto().getSelectedIndex());

        listaItems.stream().forEach(item -> {
            String[] fila = {
                item.getProducto().getUnidad()
            };
            dt.addRow(fila);
        });
    }

    private void llenarTablaDetalle() {
        List<ItemFactura> listaItems = servicios.getListaItemsFacturas();
        DefaultTableModel dt = (DefaultTableModel) vistaCompra.getTableProductosLista().getModel();
        dt.setRowCount(0);

        int selectedIndex = vistaCompra.getComboProducto().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listaItems.size()) {
            ItemFactura selectedItem = listaItems.get(selectedIndex);
            String[] fila = {
                selectedItem.getProducto().getUnidad()
            };
            dt.addRow(fila);
        }
    }

    private void mostrarFrameFactura() {
        vistaCompra.getFrameFactura().setSize(435, 375);
        vistaCompra.setLocationRelativeTo(vistaCompra);
        vistaCompra.getFrameFactura().setVisible(true);
    }

    private void registrarCompra() {
        TipoPago tipoPago = (TipoPago) vistaCompra.getComboTipoPago().getSelectedItem();
        Producto producto = (Producto) vistaCompra.getComboProducto().getSelectedItem();
        Persona cliente = (Persona) vistaCompra.getComboClientes().getSelectedItem();

        Factura factura = new Factura();
        factura.setPersona(cliente);
        factura.setTipoPago(tipoPago);
        factura.setRuc("0123");

        ItemFactura itemFactura = new ItemFactura();
        itemFactura.setFactura(factura);
        itemFactura.setProducto(producto);
        /*
        List<Producto> listaItems = new ArrayList<>();
        listaItems.add(producto);
        DefaultTableModel dt;
        dt = (DefaultTableModel) vistaCompra.getTableProductosLista().getModel();
        dt.setRowCount(0);
        
        listaItems.stream().forEach(pro -> {
            String[] fila = {
                pro.getUnidad(),
                String.valueOf(pro.getPrecioUnitario())
                //pro.get
            };
            dt.addRow(fila);
        });  
         */
        if (servicios.registrarCompra(cliente, producto, factura, tipoPago, itemFactura)) {
            JOptionPane.showMessageDialog(vistaCompra, "Factura generada ahora");
            mostrarFrameFactura();
            llenarFactura();
        } else {
            JOptionPane.showMessageDialog(vistaCompra, "Error con la Factura");
        }

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

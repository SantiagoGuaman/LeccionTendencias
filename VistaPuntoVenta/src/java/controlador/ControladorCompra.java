/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Compra;
import ws.Factura;
import ws.ItemFactura;
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

    private void llenarTablaDetalle() {
        DefaultTableModel dt = (DefaultTableModel) vistaCompra.getTableProductosLista().getModel();

        int selectedIndex = vistaCompra.getComboProducto().getSelectedIndex();

        if (selectedIndex >= 0) {
            ws.Producto pr = (ws.Producto) vistaCompra.getComboProducto().getSelectedItem();
            for (int i = 0; i < dt.getRowCount(); i++) {
                if (dt.getValueAt(i, 0).equals(pr.getUnidad())) {
                    dt.removeRow(i);
                    break;
                }
            }

            String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad deseada");
            try {
                if ((Integer.valueOf(cantidad) > pr.getStock()) || cantidad.isEmpty()) {
                    JOptionPane.showMessageDialog(vistaCompra, "No hay tal cantidad de stock disponible");
                } else {
                    double total = Integer.parseInt(cantidad) * pr.getPrecioUnitario();
                    String[] fila = {
                        pr.getUnidad(),
                        String.valueOf(pr.getPrecioUnitario()),
                        cantidad,
                        String.valueOf(total)
                    };
                    dt.addRow(fila);
                }
            } catch (NumberFormatException | NullPointerException ex) {
                JOptionPane.showMessageDialog(vistaCompra, "Ingrese únicamente numeros");
            }

        }
    }

    private void mostrarFrameFactura() {
        vistaCompra.getFrameFactura().setSize(435, 375);
        vistaCompra.setLocationRelativeTo(vistaCompra);
        vistaCompra.getFrameFactura().setVisible(true);
        
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        List<ItemFactura> listaItems = servicios.getListaItemsFacturas();
        List<Factura> listaFactura = servicios.getListaFacturas();
        
        listaFactura.stream().forEach(fac -> {
            listaItems.stream().forEach(it -> {
               if(it.getFactura().getRuc().equals(fac.getRuc())){
                   modeloLista.addElement(fac.getRuc());
                   modeloLista.addElement(String.valueOf(fac.getTotal()));
                   modeloLista.addElement(fac.getPersona().toString());
                   modeloLista.addElement(it.getProducto().toString());
               } 
            });
        });
        
        vistaCompra.getListFactura().setModel(modeloLista);
    }

    private void registrarCompra() {
        DefaultTableModel dt = (DefaultTableModel) vistaCompra.getTableProductosLista().getModel();
        TipoPago tipoPago = (TipoPago) vistaCompra.getComboTipoPago().getSelectedItem();
        Producto producto = (Producto) vistaCompra.getComboProducto().getSelectedItem();
        Persona cliente = (Persona) vistaCompra.getComboClientes().getSelectedItem();
        Double total = 0.0;
        
        Factura factura = new Factura();
        factura.setPersona(cliente);
        factura.setTipoPago(tipoPago);
        factura.setRuc("0123");
        
        for(int i = 0; i < dt.getRowCount(); i++){
            total += Double.valueOf((String) dt.getValueAt(i, 3));
            System.out.println(Double.valueOf((String) dt.getValueAt(i, 3)));
        }
        factura.setTotal(total);

        ItemFactura itemFactura = new ItemFactura();
        itemFactura.setFactura(factura);
        itemFactura.setProducto(producto);
        
        if (servicios.registrarCompra(cliente, producto, factura, tipoPago, itemFactura)) {
            JOptionPane.showMessageDialog(vistaCompra, "Factura generada ahora");
            mostrarFrameFactura();
        } else {
            JOptionPane.showMessageDialog(vistaCompra, "Error con la Factura");
        }

    }

    private void cargarComboTipoPago() {
        vistaCompra.getComboTipoPago().removeAllItems();

        List<TipoPago> lis = servicios.getListaTipoPago();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboTipoPago().addItem(new TipoPago(ob));
        });
    }

    private void cargarComboProducto() {
        vistaCompra.getComboProducto().removeAllItems();

        List<Producto> lis = servicios.getListaProductos();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboProducto().addItem(new Producto(ob));
        });
    }

    private void cargarComboCliente() {
        vistaCompra.getComboClientes().removeAllItems();

        List<Persona> lis = servicios.getListaPersonas();

        lis.stream().forEach(ob -> {
            vistaCompra.getComboClientes().addItem(new Persona(ob));
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

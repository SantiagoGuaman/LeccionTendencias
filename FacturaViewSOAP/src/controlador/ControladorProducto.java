/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Producto;
import ws.Clasificacion;
import ws.PuntoVentaOperaciones;
import ws.PuntoVentaOperaciones_Service;

/**
 *
 * @author Usuario
 */
public class ControladorProducto {
    private Producto vista;
    private PuntoVentaOperaciones_Service servicio; 
    private PuntoVentaOperaciones servicios;

    public ControladorProducto(Producto vista) {
        servicio = new PuntoVentaOperaciones_Service();
        servicios = servicio.getPuntoVentaOperacionesPort();
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void iniciarControl(){
        cargarLista();
        vista.getBtnAgregarProd().addActionListener(l -> mostrarFrameProducto());
        vista.getBtnAgregar().addActionListener(l -> agregarProducto());
    }
    
    private void cargarLista(){
        List<String> listaPr = new ArrayList<>();
        
        DefaultTableModel dt;
        dt = (DefaultTableModel) vista.getTblProducto().getModel();
        vista.getTblProducto().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        vista.getTblProducto().getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        vista.getTblProducto().getTableHeader().setOpaque(false);
        vista.getTblProducto().getTableHeader().setBackground(new Color(32, 136, 203));
        vista.getTblProducto().getTableHeader().setForeground(new Color(255, 255, 255));
        vista.getTblProducto().setRowHeight(25);
        
        listaPr.stream().forEach(pr -> {
            String[] fila = {
                /*pr.getUnidad(),
                Integer.toString(pr.getStock),
                Double.toString(pr.getPrecio_unitario()),
                Boolean.toString(pr.getIva())*/
            };
            dt.addRow(fila);
        });
    }
    
    private void mostrarFrameProducto(){
        vista.getFrameAddPr().setSize(435, 375);
        vista.setLocationRelativeTo(vista);
        vista.getFrameAddPr().setVisible(true);
    }
    
    private void agregarProducto(){
        String unidad = vista.getTxtUnidad().getText().trim();
        String stock = vista.getTxtStock().getText();
        String precio_unitario = vista.getTxtPrecio().getText();
        //Clasificacion clasi;
        //Proveedor prov;
        
        if(!unidad.isEmpty() || !stock.isEmpty() || !precio_unitario.isEmpty()){
            
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
            vista.getFrameAddPr().dispose();
        }
    }
    
    private void cargarComboClasificacion(){
        List<Clasificacion> lis = servicios.getListaClasificaciones();
        
        vista.getComboClasificacion().removeAllItems();
        
        lis.stream().forEach(cl -> {
            System.out.println("asd");
        });
    }
    
    private void cargarComboProveedor(){
        
    }
}

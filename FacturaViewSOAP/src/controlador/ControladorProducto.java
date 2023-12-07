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
import javax.swing.table.DefaultTableModel;
import vista.Producto;

/**
 *
 * @author Usuario
 */
public class ControladorProducto {
    private Producto vista;

    public ControladorProducto(Producto vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void iniciarControl(){
        cargarLista();
        vista.getBtnAgregarProd().addActionListener(l -> agregarProducto());
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
    
    private void agregarProducto(){
        vista.getFrameAddPr().setVisible(true);
    }
    
    private void cargarComboClasificacion(){
        
    }
    
    private void cargarComboProveedor(){
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class Factura {
    
    private int id_factura;
    private String ruc;
    private Persona persona;
    private LocalDateTime fecha;
    private TipoPago tipoPago;
    private Double descuento;
    private Double total;

    public Factura() {
    }

    public Factura(Persona persona) {
        this.persona = persona;
    }

    public Factura(int id_factura, String ruc, Persona persona, LocalDateTime fecha, TipoPago tipoPago, Double descuento, Double total) {
        this.id_factura = id_factura;
        this.ruc = ruc;
        this.persona = persona;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
        this.descuento = descuento;
        this.total = total;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", ruc=" + ruc + ", persona=" + persona + ", fecha=" + fecha + ", tipoPago=" + tipoPago + ", descuento=" + descuento + ", total=" + total + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class TipoPago {
    
    private int id_tipo_pago;
    private String tipo;
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(int id_tipo_pago, String tipo, String descripcion) {
        this.id_tipo_pago = id_tipo_pago;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "id_tipo_pago=" + id_tipo_pago + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
    
}

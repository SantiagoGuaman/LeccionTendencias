/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Producto {

    private int id_producto;
    private int stock;
    private Double precioUnitario;
    private String unidad;
    private Clasificacion clasificacion;
    private Proveedor proveedor;
    private boolean iva;

    public Producto() {
    }

    public Producto(int id_producto, int stock, Double precioUnitario, String unidad, Clasificacion clasificacion, Proveedor proveedor, boolean iva) {
        this.id_producto = id_producto;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.unidad = unidad;
        this.clasificacion = clasificacion;
        this.proveedor = proveedor;
        this.iva = iva;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", stock=" + stock + ", precioUnitario=" + precioUnitario + ", unidad=" + unidad + ", clasificacion=" + clasificacion + ", proveedor=" + proveedor + ", iva=" + iva + '}';
    }

}

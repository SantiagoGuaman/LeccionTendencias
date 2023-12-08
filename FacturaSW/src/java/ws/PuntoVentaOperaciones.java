/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JOptionPane;
import modelo.Clasificacion;
import modelo.Competencia;
import modelo.Factura;
import modelo.ItemFactura;
import modelo.Persona;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Rol;
import modelo.RolCompetencia;
import modelo.TipoPago;
import modelo.Usuario;
import modelo.UsuarioRol;
import security.AES_ENCRYPTOR;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "PuntoVentaOperaciones")
public class PuntoVentaOperaciones {

    AES_ENCRYPTOR ac = new AES_ENCRYPTOR();
    List<Persona> listaPersonas = new ArrayList<>();
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Rol> listaRoles = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();
    List<UsuarioRol> listaUsuariosRol = new ArrayList<>();
    List<Competencia> listaCompetencias = new ArrayList<>();
    List<Proveedor> listaProveedores = new ArrayList<>();
    List<RolCompetencia> listaRolCompetencias = new ArrayList<>();
    List<Factura> listaFacturas = new ArrayList<>();
    List<TipoPago> listaTipoPagos = new ArrayList<>();
    List<ItemFactura> listaItemFacturas = new ArrayList<>();
    List<Clasificacion> listaClasificaciones = new ArrayList<>();

    @WebMethod(operationName = "registrarPersona")
    public boolean registrarPersona(@WebParam(name = "persona") Persona persona, @WebParam(name = "usuario") Usuario usuario,
            @WebParam(name = "rol") Rol rol, @WebParam(name = "competencia") Competencia competencia) {

        UsuarioRol userWithRol = new UsuarioRol(usuario, rol);
        RolCompetencia rolWithCompetencia = new RolCompetencia(rol, competencia);
        listaUsuariosRol.add(userWithRol);
        listaRolCompetencias.add(rolWithCompetencia);
        listaUsuarios.add(usuario);
        usuario.setUsuarioRol(listaUsuariosRol);
        competencia.setRolCompetencia(listaRolCompetencias);

        return listaPersonas.add(persona);
    }

    @WebMethod(operationName = "registrarProducto")
    public boolean registrarProducto(@WebParam(name = "producto") Producto producto,
            @WebParam(name = "proveedor") Proveedor proveedor, @WebParam(name = "clasificacion") Clasificacion clasificacion) {

        try {
            producto.setClasificacion(clasificacion);
            producto.setProveedor(proveedor);
            listaClasificaciones.add(clasificacion);
            listaProveedores.add(proveedor);

            return listaProductos.add(producto);
        } catch (Exception e) {
            return false;
        }
    }

    @WebMethod(operationName = "registrarCompra")
    public boolean registrarCompra(@WebParam(name = "persona") Persona persona,
            @WebParam(name = "producto") Producto producto, @WebParam(name = "factura") Factura factura,
            @WebParam(name = "tipoPago") TipoPago tipoPago, @WebParam(name = "itemFac") ItemFactura itemFac) {

        factura.setPersona(persona);
        factura.setTipoPago(tipoPago);
        itemFac.setFactura(factura);
        itemFac.setProducto(producto);

        listaFacturas.add(factura);

        return listaItemFacturas.add(itemFac);
    }

    @WebMethod(operationName = "getListaProveedores")
    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    @WebMethod(operationName = "getListaClasificaciones")
    public List<Clasificacion> getListaClasificaciones() {
        return listaClasificaciones;
    }

    @WebMethod(operationName = "getListaPersonas")
    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    @WebMethod(operationName = "getListaTipoPago")
    public List<TipoPago> getListaTipoPago() {
        return listaTipoPagos;
    }

    @WebMethod(operationName = "getListaProductos")
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    @WebMethod(operationName = "getListaRoles")
    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    @WebMethod(operationName = "getListaFacturas")
    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    @WebMethod(operationName = "getListaItemsFacturas")
    public List<ItemFactura> getListaItemsFacturas() {
        return listaItemFacturas;
    }

    @WebMethod(operationName = "buscarPorDNI")
    public Persona buscarPorDNI(@WebParam(name = "dni") String dni) {

        Persona persona = new Persona();
        try {
            for (Persona listaPersona : listaPersonas) {
                if (listaPersona.getDni().equals(dni)) {
                    return listaPersona;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return persona;
    }

    @WebMethod(operationName = "buscarNombreCompleto")
    public String buscarNombreCompleto(@WebParam(name = "dni") String dni) {

        String flag = null;

        try {
            for (Persona listaPersona : listaPersonas) {
                if (listaPersona.getDni().equals(dni)) {
                    return listaPersona.getNombre() + " " + listaPersona.getApellido();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return flag;
    }

    @WebMethod(operationName = "siExisteUsuario")
    public Boolean siExisteUsuario(@WebParam(name = "user") String user, @WebParam(name = "encryptedPassword") String encryptedPassword) {

        return listaUsuarios.stream().anyMatch(usuario
                -> usuario.getUser().equals(user)
                && usuario.getPassword().equals(encryptedPassword));
    }

    @WebMethod(operationName = "siExisteRol")
    public Boolean siExisteRol(@WebParam(name = "rolNombre") String rolNombre) {

        return listaRoles.stream().anyMatch(rol
                -> rol.getNombreRol().equals(rolNombre));
    }

    @WebMethod(operationName = "estadoRol")
    public Boolean estadoRol(@WebParam(name = "rolNombre") String rolNombre) {
        //boolean state = false;
        for (Rol listaRol : listaRoles) {
            if (listaRol.equals(rolNombre)) {
                return listaRol.isEstado();
            }
        }
        return false;
    }

    @WebMethod(operationName = "siExisteCompetencia")
    public Boolean siExisteCompetencia(@WebParam(name = "competenciaNombre") String competenciaNombre) {

        return listaCompetencias.stream().anyMatch(compe
                -> compe.getNombreCompetencia().equals(competenciaNombre));
    }

    @WebMethod(operationName = "encrypt")
    public String encrypt(@WebParam(name = "data") String data) {
        return ac.encrypt(data);
    }

    @WebMethod(operationName = "decrypt")
    public String decrypt(@WebParam(name = "encryptData") String encryptData) {
        return ac.decrypt(encryptData);
    }

    @WebMethod(operationName = "loadData")
    public void loadData() {
        Proveedor prov = new Proveedor(1, "123", "none", "EC", "none", "Dólar");
        Proveedor prov_2 = new Proveedor(2, "123", "none", "EC", "none", "Dólar");
        Proveedor prov_3 = new Proveedor(3, "123", "none", "EC", "none", "Dólar");
        listaProveedores.add(prov);
        listaProveedores.add(prov_2);
        listaProveedores.add(prov_3);

        Clasificacion class_1 = new Clasificacion(1, "Fruta");
        Clasificacion class_2 = new Clasificacion(1, "Coche");
        Clasificacion class_3 = new Clasificacion(1, "Tejidos");
        listaClasificaciones.add(class_1);
        listaClasificaciones.add(class_2);
        listaClasificaciones.add(class_3);
    }

    public static void main(String[] args) {
        PuntoVentaOperaciones pv = new PuntoVentaOperaciones();

        Persona person = new Persona(1, "Mike", "Thompson", "0105449649", "No tiene", "abc@gamil.com");
        Rol rol = new Rol(1, "ADMIN", true);
        Competencia competencia = new Competencia(1, "2", "2");
        List<UsuarioRol> userRol = new ArrayList<>();

        Usuario user = new Usuario(1, person, "abc", "123", userRol);
        UsuarioRol userWithRol = new UsuarioRol(user, rol);
        user.getUsuarioRol().add(userWithRol);

        System.out.println("Here " + user.getUser() + " - " + user.getPassword());
        System.out.println("Here " + userWithRol);

        if (pv.registrarPersona(person, user, rol, competencia)) {
            System.out.println("Register Person");
            System.out.println(user);
        }

        if (pv.siExisteUsuario(user.getUser(), "123")) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
        } else {
            System.out.println("Nope");
        }
    }
}

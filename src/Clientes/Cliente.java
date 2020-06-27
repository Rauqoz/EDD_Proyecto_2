/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

/**
 *
 * @author josed
 */
public class Cliente {
   String dpi, nombre,apellido,genero,fechnac,telefono,direccion;

    public Cliente(String dpi, String nombre, String apellido, String genero, String fechnac, String telefono, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechnac = fechnac;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
        this.dpi = "";
        this.nombre = "";
        this.apellido = "";
        this.genero = "";
        this.fechnac = "";
        this.telefono = "";
        this.direccion = "";
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechnac() {
        return fechnac;
    }

    public void setFechnac(String fechnac) {
        this.fechnac = fechnac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
}

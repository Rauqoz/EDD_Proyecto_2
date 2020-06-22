/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conductores;

/**
 *
 * @author josed
 */
public class Conductor {
    private String dpi, nombre, appelido, TdeL, genero, Fnac, telefono, direccion;

    public Conductor(String dpi, String nombre, String appelido, String TdeL, String genero, String Fnac, String telefono, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.appelido = appelido;
        this.TdeL = TdeL;
        this.genero = genero;
        this.Fnac = Fnac;
        this.telefono = telefono;
        this.direccion = direccion;
    }

  

    public Conductor() {
        this.dpi = "";
        this.nombre = "";
        this.appelido = "";
        this.TdeL = "";
        this.genero="";
        this.Fnac = "";
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

    public String getAppelido() {
        return appelido;
    }

    public void setAppelido(String appelido) {
        this.appelido = appelido;
    }

    public String getTdeL() {
        return TdeL;
    }

    public void setTdeL(String TdeL) {
        this.TdeL = TdeL;
    }

    public String getFnac() {
        return Fnac;
    }

    public void setFnac(String Fnac) {
        this.Fnac = Fnac;
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
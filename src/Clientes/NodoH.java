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
public class NodoH {
    Cliente dato;
    NodoH derecha;

    public NodoH() {
        dato=null;
        derecha=null;
    }

    public NodoH(Cliente dato, NodoH derecha) {
        this.dato = dato;
        this.derecha = derecha;
    }
      public NodoH(Cliente dato) {
        this.dato = dato;
        this.derecha = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoH getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoH derecha) {
        this.derecha = derecha;
    }
}

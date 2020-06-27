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
public class NodoC {
    Conductor dato;
    NodoC siguiente;
    NodoC atras;

    public NodoC() {
         this.dato = null;
        this.siguiente = null;
        this.atras = null;
    }

    public NodoC(Conductor dato) {
        this.dato = dato;
        this.siguiente = null;
        this.atras = null;
    }

    public Conductor getDato() {
        return dato;
    }

    public void setDato(Conductor dato) {
        this.dato = dato;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }
    
}

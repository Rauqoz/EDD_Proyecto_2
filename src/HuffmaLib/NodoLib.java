/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HuffmaLib;

/**
 *
 * @author josed
 */
public class NodoLib {
  char letra;
  char tipoHijo;
  int repitencia;
  NodoLib siguiente;

    public NodoLib(char letra, int repitencia) {
        this.letra = letra;
        this.tipoHijo =' ';
        this.repitencia = repitencia;
        this.siguiente = null;
    }
    public NodoLib(char letra, int repitencia, NodoLib sig) {
        this.letra = letra;
        this.tipoHijo =' ';
        this.repitencia = repitencia;
        this.siguiente = sig;
    }
    public NodoLib() {
        this.letra = ' ';
        this.tipoHijo =' ';
        this.repitencia = 0;
        this.siguiente = null;
    }

    public char getLetra() {
        return letra;
    }

    public NodoLib getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLib siguiente) {
        this.siguiente = siguiente;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public char getTipoHijo() {
        return tipoHijo;
    }

    public void setTipoHijo(char tipoHijo) {
        this.tipoHijo = tipoHijo;
    }

    public int getRepitencia() {
        return repitencia;
    }

    public void setRepitencia(int repitencia) {
        this.repitencia = repitencia;
    }

    public NodoLib getPadre() {
        return siguiente;
    }

    public void setPadre(NodoLib padre) {
        this.siguiente = padre;
    }
  
}

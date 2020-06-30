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
public class Diccionario {
    char simbolo;
    String binario;
    int cc;

    public Diccionario(char simbolo, String binario, int cc) {
        this.simbolo = simbolo;
        this.binario = binario;
        this.cc = cc;
    }


 
    public String getBinario() {
        return binario;
    }

    public void setBinario(String binario) {
        this.binario = binario;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    
}

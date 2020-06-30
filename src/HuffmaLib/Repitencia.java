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
public class Repitencia {

   char letra;
    int repi;

    public Repitencia(char letra, int repi) {
        this.letra = letra;
        this.repi = repi;
    }

    public Repitencia() {
        this.letra = ' ';
        this.repi = 0;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getRepi() {
        return repi;
    }

    public void setRepi(int repi) {
        this.repi = repi;
    }

}

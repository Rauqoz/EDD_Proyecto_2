/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculo;

/**
 *
 * @author josed
 */
public class Mifuncion {
    
    public Mifuncion() {
    }

    public int ValuString(String n) {
        String entrada = n;
        int valor = 0;
        if (!n.equals("")) {
            char[] convercion = entrada.toCharArray();
            
            for (int i = 0; i < convercion.length; i++) {
                valor = valor + (int) convercion[i];
            }
        }
        return valor;
    }
}

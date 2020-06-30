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
public class Libreria {

    NodoLib no1 = null, no2 = null, no3;
    NodoLib raiz[] = new NodoLib[200];

    public Libreria() {
    }

    public void LlenarR(Repitencia n[]) {
        for (int i = 0; i < n.length; i++) {
            raiz[i] = new NodoLib(n[i].letra, n[i].getRepi(), null);
        }
    }

    void ParPeque(int numnodes) {
        int min1 = 9999;
        int min2 = 9999;
        no1 = null;
        no2 = null;
        for (int i = 0; i < numnodes; i++) {
            if (raiz[i].getSiguiente() == null) {
                if (raiz[i].getRepitencia() < min1) {
                    min2 = min1;
                    min1 = raiz[i].getRepitencia();
                    no2 = no1;
                    no1 = raiz[i];
                } else if (raiz[i].getRepitencia() < min2) {
                    min2 = raiz[i].getRepitencia();
                    no2 = raiz[i];
                }
            }
        }

    }

    public void GenerarArbol(Repitencia n[], Diccionario jd[]) {
        LlenarR(n);
        int ns = n.length;
        for (int j = ns; j < 2 * ns - 1; j++) {
            no3 = new NodoLib();
            raiz[j] = no3;
            no3.setSiguiente(null);
            ParPeque(j);
            no1.setSiguiente(no3);
            no2.setSiguiente(no3);
            no1.setTipoHijo('L');
            no2.setTipoHijo('R');
            no3.setLetra(' ');
            no3.repitencia = no1.getRepitencia() + no2.getRepitencia();
        }
        for (int k = 0; k < ns; k++) {
            LlenarDic(k, jd);
        }
    }

    void LlenarDic(int ss,Diccionario dic[]) {
        char yo=' ';
        int cc=0;
        String tu="";
        NodoLib t = raiz[ss];
        char code[] = new char[10];
        int size = 0;
        yo=t.getLetra();
        System.out.print(t.getLetra() + "-> ");
        while (t.getSiguiente() != null) {
            if (t.getTipoHijo() == 'L') {
                code[size] = '0';
            } else {
                code[size] = '1';
            }
            t = t.getSiguiente();
            size++;
        }
        cc=size;
        for (int j = size - 1; j >= 0; j--) {
            System.out.print(code[j]);
            tu=tu+String.valueOf(code[j]);
        }
        dic[ss]=new Diccionario(yo,tu,cc);
        System.out.println("------------------");
    }
}

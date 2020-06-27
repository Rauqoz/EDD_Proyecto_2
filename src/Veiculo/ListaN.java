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
public class ListaN {

    public class NodoM {

        MiniClase dato;
        NodoM siguiete;

        NodoM(MiniClase d) {
            dato = d;
        }

        public MiniClase getDato() {
            return dato;
        }

        public void setDato(MiniClase dato) {
            this.dato = dato;
        }

        public NodoM getSiguiete() {
            return siguiete;
        }

        public void setSiguiete(NodoM siguiete) {
            this.siguiete = siguiete;
        }
    }
    int tama;
    NodoM root;

    public ListaN() {

        root = null;
        tama = 0;
    }

    public ListaN(NodoM r, int tam) {
        root = r;
        tama = tam;
    }

    public int getTama() {
        return tama;
    }

    public void setTama(int tama) {
        this.tama = tama;
    }

    public NodoM getRoot() {
        return root;
    }

    public void setRoot(NodoM root) {
        this.root = root;
    }

    public void Add(MiniClase n) {
        NodoM nuevo = new NodoM(n);
        NodoM aux;
        if (root == null) {
            root = nuevo;
            tama++;
        } else {
            aux = root;
            while (aux.getSiguiete() != null) {
                aux = aux.getSiguiete();
            }
            aux.setSiguiete(nuevo);
            tama++;
        }
    }

    public void AddU(MiniClase n) {
        NodoM nuevo = new NodoM(n);
        NodoM aux;
        if (root == null) {
            root = nuevo;
            tama++;
        } else {
            aux = root;

            aux.setSiguiete(nuevo);
            tama++;
        }
    }

    public NodoM Pop() {
        NodoM aux = root;
        if (aux != null) {
            NodoM aux1 = root.getSiguiete();
            if (root.getSiguiete() != null) {
                root.setSiguiete(null);
                root = aux1;
                tama--;
            } else {
                root = null;
            }
        }
        return aux;
    }

    public void Imprimir() {
        NodoM aux = root;
        while (aux != null) {
            System.out.println("su POsible: " + aux.getDato().getUnion() + "; es hoja: " + aux.getDato().isHoja());
            aux = aux.getSiguiete();
        }
    }

    public NodoM Recorriodo(int i) {
        NodoM auxM = root;
        int contador = 0;
        if (auxM != null) {
            while (contador != i) {
                auxM = auxM.getSiguiete();
                contador++;
            }
        }
        return auxM;
    }

    public NodoM DevuelveNH() {
        NodoM auxM = root;
        while (auxM != null) {
            if (auxM.getDato().isHoja() == false) {
                return auxM;
            }
            auxM = auxM.getSiguiete();
        }
        return null;
    }

    public NodoM DevuelveR() {
        NodoM auxM = root;
        int cont = 0;
        if (root != null) {
            while (auxM != null && cont != (tama - 1)) {
                auxM = auxM.getSiguiete();
                cont++;
            }
        }
        return auxM;
    }

    public String CodigoC(int c, String envio) {

        String envio2 = "";
        int contador = c;
        if (root != null) {
            NodoM Nhoja = DevuelveNH();
            NodoM hoja = Pop();
            while (hoja != null && hoja.getDato().isHoja() != Nhoja.getDato().isHoja()) {
                envio = envio + Nhoja.getDato().getUnion() + "->" + hoja.getDato().getUnion() + ";\n";
                hoja = Pop();
                contador++;

            }

        }
        return envio;
    }

    public String CodigoC2(int c, String envio) {

        String envio2 = "";
        int contador = c;
        if (root != null) {
            NodoM Nhoja = DevuelveR();
            NodoM hoja = Pop();
            while (hoja != null) {
                if (hoja.getDato().isHoja() == false && !hoja.getDato().getUnion().equals(Nhoja.getDato().getUnion())) {
                    envio = envio + Nhoja.getDato().getUnion() + "->" + hoja.getDato().getUnion() + ";\n";
                }
                hoja = Pop();

            }

        }
        return envio;
    }
}

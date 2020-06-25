/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Conductores.NodoC;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 *
 * @author josed
 */
public class TablaH {

    int m = 37;
    NodoH[] tabla = new NodoH[m];
    int tama = 0;
    float pm = 0;

    public TablaH() {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = null;
        }
    }

    public BigInteger GenerarLLave(String valor) {
        BigInteger aux = new BigInteger(valor);
        BigInteger aux1 = new BigInteger(String.valueOf(m));
        BigInteger aux2 = new BigInteger("0");
        if (m != 0) {
            return aux.mod(aux1);
        }
        return aux2;
    }

    public void Insertar(Cliente dato) {
        NodoH nuevo = new NodoH(dato);
        NodoH aux, aux1 = null;
        float por = Porcentaje();
        if (por < 0.75) {
            if (tabla[GenerarLLave(dato.getDpi()).intValue()] == null) {
                tabla[GenerarLLave(dato.getDpi()).intValue()] = nuevo;
                tama++;
            } else {
                aux = tabla[GenerarLLave(dato.getDpi()).intValue()];
                while (aux != null) {
                    aux1 = aux;
                    aux = aux.getDerecha();
                }
                aux1.setDerecha(nuevo);
                tama++;
            }
        } else {
            ITablaR(tabla, nuevo);
            tama++;
            m = m + 37;
            tabla = Rehash();
        }

    }

    public float Porcentaje() {
        pm = 0;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                pm++;
            }
        }
        return pm / m;
    }

    public void Imprimir() {
        NodoH aux = null;
        String nu = "";
        for (int i = 0; i < tabla.length; i++) {
            nu = "";
            aux = tabla[i];
            if (aux != null && aux.derecha != null) {
                nu = nu + aux.getDato().getDpi();
                aux = aux.getDerecha();
                while (aux != null) {
                    nu = nu + "->" + aux.getDato().getDpi();
                    aux = aux.getDerecha();
                }
                System.out.println(nu);
            } else {
                if (aux != null) {
                    System.out.println(aux.getDato().getDpi());
                } else {
                    System.out.println("Null");
                }
            }
        }
    }

    public void Imprimir2() {
        NodoH aux = null;
        String nu = "";
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                System.out.println(tabla[i].getDato().getDpi());
            } else {
                System.out.println("Null");
            }
        }
    }

    private NodoH[] Rehash() {
        tama = 0;
        NodoH[] aux = new NodoH[m];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = null;
        }
        NodoH aux1 = null;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getDerecha() == null) {
                    ITablaR(aux, tabla[i]);

                } else {
                    aux1 = tabla[i];
                    while (aux1 != null) {
                        ITablaR(aux, aux1);
                        aux1 = aux1.getDerecha();
                    }
                }
            }
        }
        return aux;
    }

    private void ITablaR(NodoH[] n, NodoH e) {
        NodoH aux = null, aux1 = null, nuevo = new NodoH(e.getDato());
        if (n[GenerarLLave(e.getDato().getDpi()).intValue()] == null) {
            n[GenerarLLave(e.getDato().getDpi()).intValue()] = nuevo;
            tama++;
        } else {
            aux = n[GenerarLLave(e.getDato().getDpi()).intValue()];
            while (aux != null) {
                aux1 = aux;
                aux = aux.getDerecha();
            }
            aux1.setDerecha(nuevo);
            tama++;
        }
    }

    public boolean Eliminar(String el) {

        NodoH aux = null, aux2 = null, aux3 = null;
        int modulo = GenerarLLave(el).intValue();
        if (modulo < m) {
            aux = tabla[modulo];
            if (aux.getDerecha() == null) {
                tabla[modulo] = null;
                tama--;
                return true;
            } else {
                aux = tabla[modulo];
                while (aux != null) {
                    if (aux.getDato().getDpi().equals(el)) {
                        if (aux2 == null) {
                            aux3 = aux.getDerecha();
                            aux.setDerecha(null);
                            tabla[modulo] = aux3;
                            tama--;
                            return true;
                        } else {
                            if (aux.getDerecha() == null) {
                                aux2.setDerecha(null);
                                tama--;
                                return true;
                            } else {
                                aux3 = aux.getDerecha();
                                aux2.setDerecha(aux3);
                                aux.setDerecha(null);
                                tama--;
                                return true;
                            }
                        }
                    }
                    aux2 = aux;
                    aux = aux.getDerecha();
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public NodoH Busqueda(String d) {
        int llave = GenerarLLave(d).intValue();
        NodoH aux = null;
        if (llave < m) {
            if (tabla[llave] != null && tabla[llave].getDato().getDpi().equals(d)) {
                return tabla[llave];
            } else if (tabla[llave] != null) {
                aux = tabla[llave];
                while (aux != null) {
                    if (aux.getDato().getDpi().equals(d)) {
                        return aux;
                    }
                    aux = aux.getDerecha();
                }
            }
        }
        return null;
    }

    public boolean Modificicar(String d, Cliente mo) {
        NodoH aux = Busqueda(d);
        if (aux != null) {
            aux.setDato(mo);
            return true;
        }
        return false;
    }

    public NodoH[] getTabla() {
        return tabla;
    }

    public void setTabla(NodoH[] tabla) {
        this.tabla = tabla;
    }

    public int getTama() {
        return tama;
    }

    public void setTama(int tama) {
        this.tama = tama;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void GenerarGrafico() {
        try {
            //escribir dot
            FileWriter codigo = new FileWriter("Tablahash" + ".dot");
            PrintWriter documento = new PrintWriter(codigo);
            documento.println("digraph G {\n  nodesep=.05;\n  rankdir=LR; ");
            documento.println("node[shape=record,color=\"red\"]; \n");
            documento.println("\t\t//tabla hash \n");
            documento.println(Codigohash());

            documento.println("}");
            codigo.close();

            //compilar dot y generar imagen
            File miDir = new File(".");
            String ruta = miDir.getCanonicalPath() + "\\";//ruta actual
            String salida = "dot -Tpng " + ruta + "Tablahash" + ".dot -o " + ruta + "Tablahash" + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(salida);
            //abrir imagen
            /* miDir = new File(ruta +"conductores" + ".png");
            Desktop.getDesktop().open(miDir);*/

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String Codigohash() {

        String cc = "";
        int contador = 0;
        for (int i = 0; i < m; i++) {
            if (tabla[i] != null) {
                cc = cc + "<f" + i + ">" + tabla[i].getDato().dpi + " |";
            } else {
                cc = cc + "<f" + i + "> |";
            }
        }
        String codigo = "node0[label = \"" + cc + " \",height=1.5 ];\n";
        // creacion de nodos a la derecha 
        cc = "";
        contador = 0;
        NodoH aux = null;
        for (int i = 0; i < m; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getDerecha() != null) {
                    contador = 0;
                    aux = tabla[i].getDerecha();
                    while (aux != null) {
                        cc = cc + "f" + i + "n" + contador + "[label = \"" + aux.getDato().getDpi() + "\" width = 1.5, height=.05, style = filled,color=\"chocolate1\"];\n";
                        contador++;
                        aux = aux.getDerecha();
                    }
                }
            }
        }
        // conexion de todos los nodos 
        codigo = codigo + cc;
        cc = "";
        contador = 0;
        aux = null;
        for (int i = 0; i < m; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getDerecha() != null) {
                    contador = 0;
                    aux=tabla[i].getDerecha();
                    cc = cc + "node0:f" + i;
                    while (aux != null) {
                        cc = cc + "->" + "f" + i + "n" + contador + "";
                        contador++;
                        aux = aux.getDerecha();
                    }
                    cc = cc + ";\n";
                }
            }
        }
        codigo = codigo + cc;
        return codigo;
    }
}

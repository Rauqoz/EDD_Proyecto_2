/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author josed
 */
public class ArbolB {

    NodoB raiz;
    int gradoM;
    int tam;

    public ArbolB(int gradoM_) {
        this.raiz = null;
        gradoM = gradoM_;
        tam=0;
    }

    public void Ge() {
        ListaN nu = new ListaN();

        if (raiz != null) {
            if (tam>5) {
                 try {
                System.out.println(raiz.Gcodigo(0));
                raiz.Vector(0, nu);
                nu.getTama();
                nu.Imprimir();
                ListaN craiz = new ListaN();
                int cont = 0;
                while (cont < nu.getTama()) {
                    craiz.Add(nu.Recorriodo(cont).getDato());
                    cont++;
                }
                String n = "";
                String ya = raiz.Gcodigo(0) + nu.CodigoC(0, n);
                while (nu.getRoot() != null) {
                    ya = ya + nu.CodigoC(0, n);
                }
                ya = ya + craiz.CodigoC2(0, n);
                System.out.println(ya);

                //escribir dot
                FileWriter codigo = new FileWriter("ArbolB" + ".dot");
                PrintWriter documento = new PrintWriter(codigo);
                documento.println("digraph G {\n  ");
                documento.println("node[shape=record,color=\"red\"]; \n");
                documento.println("\t\t//Arbol B \n");
                documento.println(ya);
                documento.println("\n");
                documento.println("}");
                codigo.close();

                //compilar dot y generar imagen
                File miDir = new File(".");
                String ruta = miDir.getCanonicalPath() + "\\";//ruta actual
                String salida = "dot -Tpng " + ruta + "ArbolB" + ".dot -o " + ruta + "ArbolB" + ".png";
                Runtime rt = Runtime.getRuntime();
                rt.exec(salida);
                //abrir imagen
                /* miDir = new File(ruta +"conductores" + ".png");
            Desktop.getDesktop().open(miDir);*/

            } catch (IOException e) {
                System.out.println(e);
            }
            }else{
            raiz.Ggraphyz();
            }

        }
    }

    public void ImprimirB() {
        if (raiz != null) {
            raiz.Imprimir();
        }
    }

    public String Datos() {
        if (raiz != null) {
            return raiz.Texto();
        }
        return "";
    }

    public Carro BusquedaB(String n) {
        if (raiz != null) {
            return raiz.Buscar(n);
        }
        return null;
    }

    public int Indi(String n) {
        if (raiz != null) {
            return raiz.BuscarIn(n);
        }
        return 0;
    }

    public void InsertarB(Carro n) {
        if (raiz == null) {
            raiz = new NodoB(gradoM, true);
            raiz.LLave[0] = n;
            raiz.nA = 1;
            tam++;
        } else {
            if (raiz.nA == (2 * gradoM - 1)) {
                NodoB s = new NodoB(gradoM, false);
                s.segun[0] = raiz;
                s.SepararHijo(0, raiz);
                int i = 0;
                if (ValuString(s.LLave[0].plasca) < ValuString(n.plasca)) {
                    i++;
                }
                s.segun[i].InsertarNll(n);
                raiz = s;
                tam++;
            } else {
                raiz.InsertarNll(n);
                tam++;
            }
        }
    }

    public boolean EliminarB(String n) {
        NodoB tmp;
        if (raiz == null) {
            return false;
        }
        raiz.Eliminar(n);
        if (raiz.nA == 0) {
            tmp = raiz;
            if (raiz.hoja) {
                raiz = null;
            } else {
                raiz = raiz.segun[0];
            }
        }
        return true;
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

    public boolean Modificar(String n, Carro s) {
        if (EliminarB(n)) {
            InsertarB(s);
            return true;
        } else {
            return false;
        }
    }
}

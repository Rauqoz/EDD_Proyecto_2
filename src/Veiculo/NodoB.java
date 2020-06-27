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
import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class NodoB {

    Carro LLave[];
    int grado;
    NodoB segun[];
    int nA;
    boolean hoja;
    String co;
    String map[] = new String[5];

    NodoB(int grado1, boolean hoja1) {
        grado = grado1;
        hoja = hoja1;
        LLave = new Carro[2 * grado - 1];
        segun = new NodoB[2 * grado];
        nA = 0;
        co = "";
        Llenvec(map);

    }

    public Carro[] getLLave() {
        return LLave;
    }

    public void setLLave(Carro[] LLave) {
        this.LLave = LLave;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public NodoB[] getSegun() {
        return segun;
    }

    public void setSegun(NodoB[] segun) {
        this.segun = segun;
    }

    public boolean isHoja() {
        return hoja;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }

    public int getnA() {
        return nA;
    }

    public void setnA(int nA) {
        this.nA = nA;
    }

    public void Imprimir() {
        String imp = "";
        int aux = 0;
        int i;
        for (i = 0; i < nA; i++) {
            if (hoja == false) {
                segun[i].Imprimir();
            }
            imp = imp + LLave[i].getPlasca() + ",";
            //System.out.print(aux+" ");
        }
        if (hoja == false) {
            segun[i].Imprimir();
            System.out.println("yo salgo de aqui " + segun[i].LLave[0]);
            System.out.println("yo y depues yo: " + imp);
        }
        System.out.println(imp);
    }

    public Carro Buscar(String s) {
        int n=ValuString(s);
        int i = 0;
        while (i < nA && n > ValuString(LLave[i].getPlasca())) {
            i++;
        }
        if (ValuString(LLave[i].getPlasca()) == n) {
            return this.LLave[i];
        }
        if (hoja == true) {
            return null;
        }
        return segun[i].Buscar(s);
    }

    public int BuscarIn(String s) {
        int n=ValuString(s);
        int i = 0;
        while (i < nA && n > ValuString(LLave[i].getPlasca())) {
            i++;
        }
        if (ValuString(LLave[i].getPlasca()) == n) {
            return ValuString(LLave[i].getPlasca());
        }
        if (hoja == true) {
            return ValuString(LLave[i].getPlasca());
        }
        return segun[i].BuscarIn(s);
    }

    public int EnContrarLLave(int n) {
        int Auxn = 0;
        while (Auxn < nA && ValuString(LLave[Auxn].getPlasca()) < n) {
            ++Auxn;
        }
        return Auxn;
    }

    public void InsertarNll(Carro s) {
        int i = nA - 1;
        if (hoja == true) {
            while (i >= 0 && ValuString(LLave[i].getPlasca()) > ValuString(s.plasca)) {
                LLave[i + 1] = LLave[i];
                i--;
            }
            LLave[i + 1] = s;
            nA = nA + 1;
        } else {

            while (i >= 0 && ValuString(LLave[i].getPlasca()) > ValuString(s.plasca)) {
                i--;
            }
            if (segun[i + 1].nA == 2 * grado - 1) {
                SepararHijo(i + 1, segun[i + 1]);
                if (i >= 0 && ValuString(LLave[i].getPlasca()) < ValuString(s.plasca)) {
                    i++;
                }
            }
            segun[i + 1].InsertarNll(s);
        }
    }

    public void SepararHijo(int i, NodoB y) {
        NodoB z = new NodoB(y.grado, y.hoja);
        z.nA = grado - 1;
        for (int j = 0; j < grado - 1; j++) {
            z.LLave[j] = y.LLave[j + grado];
        }
        if (y.hoja == false) {
            for (int j = 0; j < grado; j++) {
                z.segun[j] = y.segun[j + grado];
            }
        }
        y.nA = grado - 1;
        for (int j = nA; j >= i + 1; j--) {
            segun[j + 1] = segun[j];
        }
        segun[i + 1] = z;
        for (int j = nA - 1; j >= i; j--) {
            LLave[j + 1] = LLave[j];
        }
        LLave[i] = y.LLave[grado - 1];
        nA = nA + 1;
    }

    public boolean Eliminar(String s) {
        int n=ValuString(s);
        int auxn = EnContrarLLave(n);
        if (auxn < nA && ValuString(LLave[auxn].plasca) == n) {
            if (hoja) {
                EliminarDhoja(auxn);
                return true;
            } else {
                EliminarDraiz(auxn);
                return true;
            }
        } else {
            if (hoja) {
                return false;
            }
            boolean hoja1 = ((auxn == nA)) ? true : false;

            if (segun[auxn].getnA() < grado) {
                LlenarHijo(auxn);
            }
            if (hoja1 && auxn > nA) {
                segun[auxn - 1].Eliminar(s);
            } else {
                segun[auxn].Eliminar(s);
            }

        }
        return true;
    }

    public void EliminarDhoja(int n) {

        for (int i = n + 1; i < nA; ++i) {
            LLave[i - 1] = LLave[i];
        }
        nA--;
    }

    public void EliminarDraiz(int n) {
        Carro k = LLave[n];
        if (segun[n].getnA() >= grado) {
            Carro pred = getPredecesor(n);
            LLave[n] = pred;
            segun[n].Eliminar(pred.plasca);
        } else if (segun[n + 1].getnA() >= grado) {
            Carro succ = getSucesor(n);
            LLave[n] = succ;
            segun[n + 1].Eliminar(succ.plasca);
        } else {
            FusionHijo(n);
            segun[n].Eliminar(k.plasca);
        }
    }

    public Carro getPredecesor(int n) {

        NodoB cur = segun[n];
        while (!cur.isHoja()) {
            cur = cur.getSegun()[cur.getnA()];
        }
        return cur.getLLave()[cur.getnA() - 1];
    }

    public Carro getSucesor(int n) {
        NodoB cur = segun[n + 1];
        while (!cur.isHoja()) {
            cur = cur.getSegun()[0];
        }
        return cur.getLLave()[0];
    }

    public void LlenarHijo(int n) {
        if (n != 0 && segun[n - 1].getnA() >= grado) {
            MoverAnterior(n);
        } else if (n != nA && segun[n + 1].getnA() >= grado) {
            MoverSiguiente(n);
        } else {
            if (n != nA) {
                FusionHijo(n);
            } else {
                FusionHijo(n - 1);
            }
        }

    }

    public void MoverAnterior(int n) {
        NodoB hijoaux = segun[n];
        NodoB hermano = segun[n - 1];

        for (int i = (hijoaux.nA - 1); i >= 0; --i) {
            hijoaux.LLave[i + 1] = hijoaux.LLave[i];
        }
        if (!hijoaux.isHoja()) {
            for (int i = hijoaux.nA; i >= 0; --i) {
                hijoaux.segun[i + 1] = hijoaux.segun[i];
            }
        }
        hijoaux.LLave[0] = LLave[n - 1];
        if (!hijoaux.isHoja()) {
            hijoaux.segun[0] = hermano.segun[hermano.nA];
        }
        LLave[n - 1] = hermano.LLave[hermano.nA - 1];
        hijoaux.nA += 1;
        hermano.nA -= 1;

        return;
    }

    public void MoverSiguiente(int n) {
        NodoB child = segun[n];
        NodoB sibling = segun[n + 1];

        child.LLave[(child.nA)] = LLave[n];
        if (!(child.isHoja())) {
            child.segun[(child.nA) + 1] = sibling.segun[0];
        }
        LLave[n] = sibling.LLave[0];
        for (int i = 1; i < sibling.nA; ++i) {
            sibling.LLave[i - 1] = sibling.LLave[i];
        }
        if (!sibling.isHoja()) {
            for (int i = 1; i <= sibling.nA; ++i) {
                sibling.segun[i - 1] = sibling.segun[i];
            }
        }
        child.nA += 1;
        sibling.nA -= 1;
    }

    public void FusionHijo(int n) {
        NodoB child = segun[n];
        NodoB sibling = segun[n + 1];
        child.LLave[grado - 1] = LLave[n];
        for (int i = 0; i < sibling.nA; ++i) {
            child.LLave[i + grado] = sibling.LLave[i];
        }
        if (!child.isHoja()) {
            for (int i = 0; i <= sibling.nA; ++i) {
                child.segun[i + grado] = sibling.segun[i];
            }
        }
        for (int i = n + 1; i < nA; ++i) {
            LLave[i - 1] = LLave[i];
        }
        for (int i = n + 2; i <= nA; ++i) {
            segun[i - 1] = segun[i];
        }
        child.nA += sibling.nA + 1;
        nA--;
    }

    public void Ggraphyz() {
        try {
            //escribir dot
            FileWriter codigo = new FileWriter("ArbolB" + ".dot");
            PrintWriter documento = new PrintWriter(codigo);
            documento.println("digraph G {\n ");
            documento.println("node[shape=record,color=\"red\"]; \n");
            documento.println("\t\t//Arbol B \n");
            documento.println(Gcodigo(0));
            documento.println("\n");
            // Vector(0);
            documento.println(co);
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
    }

    public String Gcodigo(int id) {
        String imp = "";
        String rrr = "";
        Carro aux = null;
        int i;
        for (i = 0; i < nA; i++) {
            if (hoja == false) {
                rrr = rrr + segun[i].Gcodigo(id + 1);

            }
            imp = imp + "|" + LLave[i].plasca + "|";
            aux = LLave[i];
        }
        if (hoja == false) {
            rrr = rrr + segun[i].Gcodigo(id + 1);
        }
        id++;
        rrr = rrr + "R8" + id + aux.plasca + "[label=\"" + imp + "\"];\n";
        // System.out.println(imp);
        return rrr;
    }

    public ListaN Vector(int id, ListaN n) {
        String imp = "";
        String rrr = "";
        boolean ss = false;
        Carro aux = null;
        int i;
        for (i = 0; i < nA; i++) {
            if (hoja == false) {
                segun[i].Vector(id + 1, n);
            }
            aux = LLave[i];
        }
        if (hoja == false) {
            segun[i].Vector(id + 1, n);
        }
        if (id == 0) {
            System.out.println("yo soy cero ");
            id++;
            rrr = "R8" + id + aux.plasca;
            n.Add(new MiniClase(rrr, hoja));
            return n;
        }
        id++;
        rrr = "R8" + id + aux.plasca;
        n.Add(new MiniClase(rrr, hoja));
        return n;
    }

    public void SetCo(String n) {
        co = co + n;
    }

    public void Llenvec(String n[]) {

        for (int i = 0; i < n.length; i++) {
            n[i] = "";
        }
    }

    public void PasLabel(MiniClase n[], MiniClase d) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] == null) {
                n[i] = d;
                break;
            }
        }
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

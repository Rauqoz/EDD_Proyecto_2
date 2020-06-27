package Rutas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listaParaLaRuta {

    public nodoParaRuta inicioRuta;

    public listaParaLaRuta() {
        this.inicioRuta = null;
    }

    public void insertar(String contenido, String tiempo) {
        nodoParaRuta nuevo = new nodoParaRuta(contenido, tiempo);
        if (inicioRuta == null) {
            inicioRuta = nuevo;
        } else {
            nodoParaRuta tempo = inicioRuta;
            while (tempo.derecha != null) {
                tempo = tempo.derecha;
            }
            tempo.derecha = nuevo;
        }
    }

    public void mostrarParaRuta(nodoParaRuta tempo) {
        if (tempo != null) {
            System.out.print(tempo.contenido + " - " + tempo.tiempo + " -> ");
            mostrarParaRuta(tempo.derecha);
        } else {
            System.out.println();
        }
    }

    void graficar() {
        FileWriter archivo;
        try {
            archivo = new FileWriter("rutaActual.dot");
            String inicioDot = "digraph G { \n";
            String finalDot = "} ";
            archivo.write(inicioDot);
            archivo.write("node [style=circle, color = blue];");
            graficar2(inicioRuta, archivo);
            archivo.write(" label = \"Ruta Actual\";");
            archivo.write(finalDot);
            archivo.close();
            Runtime exe = Runtime.getRuntime();
            exe.exec("dot -Tpng rutaActual.dot -o rutaActual.png");
        } catch (IOException ex) {
            Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void graficar2(nodoParaRuta tempo_, FileWriter archivo) {
        if (tempo_ != null) {

            try {
                archivo.write("\"" + tempo_.contenido + " " + tempo_.tiempo + "\"");
            } catch (IOException ex) {
                Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tempo_.derecha != null) {
                try {
                    archivo.write(" ->");
                    graficar2(tempo_.derecha, archivo);
                } catch (IOException ex) {
                    Logger.getLogger(listaParaLaRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    archivo.write(";");
                } catch (IOException ex) {
                    Logger.getLogger(listaParaLaRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

}

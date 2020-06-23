package Rutas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class listaRutas {

    public nodoRutas inicio;
    nodoRutas temporalOrigen;

    public void insertarRuta(String origen_, String destino_, int tiempo) {
        if (vacia()) {
            nodoRutas primero = new nodoRutas(origen_);
            inicio = primero;
            if (!origen_.equalsIgnoreCase(destino_)) {
                insertarOrigenes(destino_, inicio);
                insertarDestinos(destino_, tiempo, inicio);
            }

        } else {

            if (existeOrigen(origen_, inicio) && temporalOrigen != null) {
                if (existeDestino(destino_, temporalOrigen)) {

                } else {
                    insertarDestinos(destino_, tiempo, temporalOrigen);
                }
            } else {
                nodoRutas tempo = insertarOrigenes(origen_, inicio);
                insertarDestinos(destino_, tiempo, tempo);
            }

        }

    }

    public listaRutas() {
        this.inicio = null;
    }

    boolean existeOrigen(String origen_, nodoRutas temporal) {
        while (temporal != null) {
            if (temporal.contenido.equalsIgnoreCase(origen_)) {
                temporalOrigen = temporal;
                return true;
            }
            temporal = temporal.abajo;
        }
        temporalOrigen = null;
        return false;

    }

    boolean existeDestino(String destino_, nodoRutas temporal) {
        while (temporal != null) {
            if (temporal.contenido.equalsIgnoreCase(destino_)) {
                return true;
            }
            temporal = temporal.derecha;
        }
        return false;
    }

    boolean vacia() {
        return inicio == null;
    }

    nodoRutas insertarOrigenes(String origen_, nodoRutas temporal) {
        nodoRutas nuevo = new nodoRutas(origen_);
        while (temporal.abajo != null) {
            temporal = temporal.abajo;
        }
        temporal.abajo = nuevo;

        return nuevo;
    }

    nodoRutas insertarDestinos(String destino_, int tiempo_, nodoRutas temporal) {
        nodoRutas nuevo = new nodoRutas(destino_, tiempo_);
        while (temporal.derecha != null) {
            temporal = temporal.derecha;
        }
        temporal.derecha = nuevo;
        return nuevo;
    }

    public void mostrarOrigenes(nodoRutas tempo_) {
        if (tempo_ != null) {
            System.out.print(tempo_.contenido);
            mostrarDestinos(tempo_.derecha);
            mostrarOrigenes(tempo_.abajo);
        }

    }

    public void mostrarDestinos(nodoRutas tempo_) {
        if (tempo_ != null) {
            System.out.print(" - " + tempo_.contenido + " " + tempo_.tiempo);
            mostrarDestinos(tempo_.derecha);
        } else {
            System.out.println();
        }
    }

    public void cargaMasiva() {
        JFileChooser escoger = new JFileChooser();
        escoger.setApproveButtonText("Cargar Datos");
        escoger.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
        int a = escoger.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            File archivo = new File(escoger.getSelectedFile().toString());
            try {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String fila = "";
                while ((fila = lector.readLine().trim()) != null) {
                    String todo[] = fila.trim().split("%");
                    String limpio[] = todo[0].trim().split("/");
                    insertarRuta(limpio[0].trim(), limpio[1].trim(), Integer.parseInt(limpio[2].trim()));
                }

            } catch (Exception ex) {

            }

        }
    }

    public void graficar() {
        FileWriter archivo;
        try {
            archivo = new FileWriter("rutas.dot");
            String inicioDot = "digraph G { \n";
            String finalDot = "} ";
            archivo.write(inicioDot);
            archivo.write("node [style=circle, color = blue];");
            graficar2(inicio, archivo);
            archivo.write(" label = \"Rutas\";");
            archivo.write(finalDot);
            archivo.close();
            Runtime exe = Runtime.getRuntime();
            exe.exec("dot -Tpng rutas.dot -o rutas.png");
        } catch (IOException ex) {
            Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void graficar2(nodoRutas tempo_, FileWriter archivo) {
        if (tempo_ != null) {
            boolean bandera = false;
            nodoRutas otro = tempo_;
            while (otro.derecha != null) {
                bandera = true;
                try {
                    otro = otro.derecha;
                    archivo.write(tempo_.contenido + " -> " + otro.contenido + "[label=\"" + otro.tiempo + "\"];");
                } catch (IOException ex) {
                    Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!bandera) {
                try {
                    archivo.write(tempo_.contenido + ";");
                } catch (IOException ex) {
                    Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            graficar2(tempo_.abajo, archivo);

        }
    }

//    void graficar3(nodoRutas tempo_, FileWriter archivo,nodoRutas padre) {
//        if (tempo_ != null) {
//            try {
//                archivo.write(" -> " + tempo_.contenido + "[label=\"" + tempo_.tiempo + "\"];");
//                graficar3(tempo_.derecha, archivo,padre);
//            } catch (IOException ex) {
//                Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            try {
//                archivo.write("\n");
//            } catch (IOException ex) {
//                Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}

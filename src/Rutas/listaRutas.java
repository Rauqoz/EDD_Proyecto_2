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
    String[][] distancias;
    String[][] recorridos;

    void insertarRuta(String origen_, String destino_, int tiempo) {
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

    void mostrarOrigenes(nodoRutas tempo_) {
        if (tempo_ != null) {
            System.out.print(tempo_.contenido);
            mostrarDestinos(tempo_.derecha);
            mostrarOrigenes(tempo_.abajo);
        }

    }

    void mostrarDestinos(nodoRutas tempo_) {
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
            graficar();

        }
    }

    void graficar() {
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

    int calcularTamaño() {
        nodoRutas tempo = inicio;
        int tamaño = 0;
        while (tempo != null) {
            tamaño++;
            tempo = tempo.abajo;
        }
        return tamaño;
    }

    void llenarRutas() {
        int tamaño = calcularTamaño();
        distancias = new String[tamaño][tamaño];
        recorridos = new String[tamaño][tamaño];
        nodoRutas temporal = inicio;
        int marca = 0;
        while (temporal != null) {
            distancias[0][marca] = temporal.getContenido();
            distancias[marca][0] = temporal.getContenido();
            recorridos[0][marca] = temporal.getContenido();
            recorridos[marca][0] = temporal.getContenido();
            marca++;
            temporal = temporal.abajo;

        }
        for (int i = 1; i < tamaño; i++) {
            for (int j = 1; j < tamaño; j++) {
                recorridos[i][j] = recorridos[0][j];
            }
        }
        for (int i = 1; i < tamaño; i++) {
            for (int j = 1; j < tamaño; j++) {
                if (distancias[i][j] == null) {
                    distancias[i][j] = "Infinity";
                }
            }
        }
        for (int i = 0; i < tamaño; i++) {
            distancias[i][i] = "0";
            recorridos[i][i] = "-";
        }

        temporal = inicio;
        while (temporal != null) {
            nodoRutas otro = temporal.derecha;
            while (otro != null) {
                for (int i = 0; i < tamaño; i++) {
                    for (int j = 0; j < tamaño; j++) {
                        if (distancias[i][0].equalsIgnoreCase(temporal.getContenido()) && distancias[0][j].equalsIgnoreCase(otro.getContenido())) {
                            distancias[i][j] = String.valueOf(otro.getTiempo());
                            break;
                        }
                    }
                }
                otro = otro.derecha;
            }
            temporal = temporal.abajo;
        }
        algoritmoFloyd();

    }

    void algoritmoFloyd() {
        int tamaño = calcularTamaño();

        for (int k = 1; k < tamaño; k++) {
            for (int i = 1; i < tamaño; i++) {
                for (int j = 1; j < tamaño; j++) {
                    double dato = Double.parseDouble(distancias[i][k]) + Double.parseDouble(distancias[k][j]);
                    if (Double.parseDouble(distancias[i][j]) > dato) {
                        distancias[i][j] = String.valueOf(dato);
                        recorridos[i][j] = distancias[0][k];

                    }

                }
            }
        }
//        System.out.println("Matriz distancia 2 --------------------------------");
//        for (int i = 0; i < tamaño; i++) {
//            for (int j = 0; j < tamaño; j++) {
//                System.out.print("(" + distancias[i][j] + ") ");
//            }
//            System.out.println();
//        }
//        System.out.println("Matriz Ruta 2 --------------------------------");
//        for (int i = 0; i < tamaño; i++) {
//            for (int j = 0; j < tamaño; j++) {
//                System.out.print("(" + recorridos[i][j] + ") ");
//            }
//            System.out.println();
//        }

    }

    public String buscarRuta(String origen_, String destino_) {
        llenarRutas();
        String rutaCompleta = "";
        int tamaño = calcularTamaño();
        int iDestino = -1, iOrigen = -1;
        for (int i = 1; i < tamaño; i++) {
            if (recorridos[0][i].equalsIgnoreCase(destino_)) {
                iDestino = i;
            }
            if (recorridos[i][0].equalsIgnoreCase(origen_)) {
                iOrigen = i;
            }
        }

        if (iOrigen != -1 && iDestino != -1) {
            while (!origen_.equalsIgnoreCase("-")) {
                for (int i = 0; i < tamaño; i++) {
                    if (recorridos[i][0].equalsIgnoreCase(origen_)) {
                        origen_ = recorridos[i][iDestino];
//                        System.out.print(recorridos[i][0] + " -> ");
                        rutaCompleta += recorridos[i][0] + " -> ";
                        break;
                    }
                }
            }
//            System.out.println("Tiempo: " + distancias[iOrigen][iDestino]);
            rutaCompleta += "Tiempo: " + distancias[iOrigen][iDestino];
        } else {
            if (iOrigen == -1) {
//                System.out.println("Origen no Existe");
                return "Origen no Existe";
            } else {
//                System.out.println("Destino no Existe");
                return "Destino no Existe";
            }
        }
        return rutaCompleta;
    }

}

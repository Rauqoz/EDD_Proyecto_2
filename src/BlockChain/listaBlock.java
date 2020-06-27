package BlockChain;

import Rutas.listaParaLaRuta;
import Rutas.listaRutas;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static edd_proyecto2.EDD_Proyecto2.*;

public class listaBlock {

    nodoBlock inicio;

    public listaBlock() {
        this.inicio = null;
    }

    public void insertarViaje(String origen_, String destino_, String cliente, String conductor) {
        nodoBlock nuevo = new nodoBlock(origen_, destino_);
        nuevo.cliente = tablita.Busqueda(cliente);
        nuevo.conductor = lista.Buscar(conductor);
        String fechaHoraNodo = generarFechaHoraNodo();
        String fechaHoraLlave = generarFechaHoraLlave();
        nuevo.fechaHora = fechaHoraNodo;
        nuevo.llave = encriptarMD5(fechaHoraLlave);
        nuevo.ruta = ListaRutas.buscarRuta(origen_, destino_);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nodoBlock tempo = inicio;
            while (tempo.derecha != null) {
                tempo = tempo.derecha;
            }
            tempo.derecha = nuevo;

        }
        graficar();

    }

    String generarFechaHoraLlave() {
        Date fecha = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
        String formato = "ddMMyyyyHH:mm"; // El formato de fecha está especificado  
        SimpleDateFormat formatoFecha = new SimpleDateFormat(formato); // La cadena de formato de fecha se pasa como un argumento al objeto de formato de fecha
        return formatoFecha.format(fecha);
    }

    String generarFechaHoraNodo() {
        Date fecha = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
        String formato = "dd:MM:yyyy HH:mm"; // El formato de fecha está especificado  
        SimpleDateFormat formatoFecha = new SimpleDateFormat(formato); // La cadena de formato de fecha se pasa como un argumento al objeto de formato de fecha
        return formatoFecha.format(fecha);
    }

    String encriptarMD5(String llave_) {
        try {
            MessageDigest codificacion = MessageDigest.getInstance("MD5");
            byte[] messageDigest = codificacion.digest(llave_.getBytes());
            BigInteger numero = new BigInteger(1, messageDigest);
            String textoEncriptado = numero.toString(16);

            while (textoEncriptado.length() < 32) {
                textoEncriptado = "0" + textoEncriptado;
            }
            System.out.println(textoEncriptado + " Viaje");
            return textoEncriptado;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public void graficar() {
        FileWriter archivo;
        try {
            archivo = new FileWriter("blockChain.dot");
            String inicioDot = "digraph G { \n";
            String finalDot = "} ";
            archivo.write(inicioDot);
            archivo.write("node [style=circle, color = blue];");
            graficar2(inicio, archivo);
            archivo.write(" label = \"BlockChain\";");
            archivo.write(finalDot);
            archivo.close();
            Runtime exe = Runtime.getRuntime();
            exe.exec("dot -Tpng blockChain.dot -o blockChain.png");
        } catch (IOException ex) {
            Logger.getLogger(listaRutas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void graficar2(nodoBlock tempo_, FileWriter archivo) {
        if (tempo_ != null) {

            try {
                archivo.write("\"" + tempo_.llave + " " + tempo_.lugarOrigen + " " + tempo_.lugarDestino + " " + tempo_.fechaHora + " Cliente: " + tempo_.cliente.getDato().getNombre() + " Conductor: " + tempo_.conductor.getDato().getNombre() + "\"");
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
                    Logger.getLogger(listaBlock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

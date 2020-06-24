package edd_proyecto2;

import Rutas.listaRutas;

public class EDD_Proyecto2 {

    public static void main(String[] args) {
        // TODO code application logic here

        listaRutas p = new listaRutas();
        p.cargaMasiva();
        p.graficar();
        p.mostrarRutas();

    }

}

package edd_proyecto2;

import Rutas.listaRutas;

public class EDD_Proyecto2 {

    public static listaRutas ListaRutas = new listaRutas();

    public static void main(String[] args) {
        // TODO code application logic here
//        String y = "Infinity";
//        Ejemplo de Rutas
//
        listaRutas p = new listaRutas();
        p.cargaMasiva();
        System.out.println(p.buscarRuta("valencia", "madrid"));

    }

}

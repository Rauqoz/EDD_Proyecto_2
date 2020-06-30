package edd_proyecto2;

import BlockChain.listaBlock;
import Clientes.*;
import Conductores.*;
import Rutas.listaRutas;
import Veiculo.*;

public class EDD_Proyecto2 {

    public static TablaH tablita = new TablaH();
    public static ListaC lista = new ListaC();
    public static ArbolB t = new ArbolB(3);
    public static listaRutas ListaRutas = new listaRutas();
    public static listaBlock ListaViajes = new listaBlock();

    public static void main(String[] args) {
        // TODO code application logic here

        ListaRutas.cargaMasiva();

    }

}

package edd_proyecto2;

import BlockChain.formViajes;
import BlockChain.listaBlock;
import Clientes.MenuCli;
import Clientes.TablaH;
import Conductores.ListaC;
import Conductores.MenuC;
import Rutas.listaRutas;

public class EDD_Proyecto2 {

    public static TablaH tablita = new TablaH();
    public static ListaC lista = new ListaC();
    public static listaRutas ListaRutas = new listaRutas();
    public static listaBlock ListaBlockChain = new listaBlock();

    public static void main(String[] args) {
        // TODO code application logic here
        ListaRutas.cargaMasiva();
        formViajes menu = new formViajes();
        menu.setVisible(true);
        // TODO code application logic here
        /* para mandar a llamar a la tabla hash que es la variablke tablita 
        NodoH encontrado=tablita.Busqueda("aqui mandas el dpi del cliente ");   }
        para conductore es asi:
        NodoC encontado= lista.Buscar("aqui pones el dpi del conductor a buscar");
        de alli ya buscar el get que queras 
         */

        MenuCli clientes = new MenuCli();
        clientes.setVisible(true);
        MenuC conductores = new MenuC();
        conductores.setVisible(true);

    }

}

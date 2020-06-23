/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conductores;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 *
 * @author josed
 */
public class ListaC {
    int tam;
    NodoC inicio;
    NodoC fin;

    public ListaC() {
    inicio=null;
    fin=null;
    tam=0;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    // inserta de ultimo en la fila :)
  public void InsertarUltimo(Conductor d){
  NodoC nuevo=new NodoC(d);
  NodoC aux=new NodoC();
      if (inicio == null) {
      inicio =nuevo;
      inicio.setSiguiente(inicio);
      inicio.setAtras(inicio);
      tam++;
      }else if (tam==1) {
       fin=nuevo;
       fin.setSiguiente(inicio);
       fin.setAtras(inicio);
       inicio.setSiguiente(fin);
       inicio.setAtras(fin);
       tam++;
      }else{
       aux=fin;
       fin=nuevo;
       aux.setSiguiente(fin);
       fin.setAtras(aux);
       fin.setSiguiente(inicio);
       inicio.setAtras(fin);
       tam++;
      }
  }
  // devuelve un nodo con el dato usado 
  public NodoC Buscar(String d){
      NodoC aux=inicio;
      int cont= 0;
      if (inicio != null) {
          while (cont<tam) {              
              if (aux.getDato().getDpi().compareTo(d)==0) {
                  return aux;
              }
              aux=aux.getSiguiente();
              cont++;
          }
      }
      return null;
      }
   public boolean BuscarB(String d){
      NodoC aux=inicio;
      int cont= 0;
      if (inicio != null) {
          while (cont<tam) {              
              if (aux.getDato().getDpi().compareTo(d)==0) {
                  return true;
              }
              aux=aux.getSiguiente();
              cont++;
          }
      }
      return false;
      }
 
  // metodo de modificacion 
  public void ModificarD(String dato,Conductor modif){
  NodoC aux =inicio;
  int conta=0;
      if (inicio !=null) {
          while (conta<tam) {              
              if (aux.getDato().getDpi().compareTo(dato)==0) {
                  aux.setDato(modif);
                  break;
              }
              conta++;
              aux=aux.getSiguiente();
          }
      }
  }
  // elimina dato 
  public void EliminarD(String dato){
      NodoC aux =inicio;
      NodoC aux1,aux2;
      int cont=0;
      if (inicio!=null) {
          while (cont<tam) {              
              if (aux.getDato().getDpi().compareTo(dato)==0) {
                  aux1=aux.getAtras();
                  aux2=aux.getSiguiente();
                  aux1.setSiguiente(aux2);
                  aux2.setAtras(aux1);
                  aux.setAtras(null);
                  aux.setSiguiente(null);
                  tam--;
                  break;
              }
              cont++;
              aux=aux.getSiguiente();
          }
      }
  }  
// imprime en consola la lista 
  public void Imprimir(){
     int cont=0;
     NodoC aux=inicio;
      if (inicio!=null) {
          while (cont<tam) {              
              System.out.println("Su Dato: "+aux.getDato().getDpi()+" Nombre: "+aux.getDato().getNombre());
              aux=aux.getSiguiente();
              cont++;
          }
      }
  }
   public String DevolverCg(){
     int cont=0;
     String cadena="";
     NodoC aux=inicio;
      if (inicio!=null) {
          while (cont<tam) {              
              cadena=cadena+"DPI: "+aux.getDato().getDpi()+";  Nombre: "+aux.getDato().getNombre()+";  Licencia tipo: "+aux.getDato().getTdeL()+";  No. Telefono: "+aux.getDato().getTelefono()+"\n";
              aux=aux.getSiguiente();
              cont++;
          }
          return cadena;
      }
      return cadena;
  }
  // ordena la ista de mayor a menor
  public void ordenarListaMayorM(){
    int t;
	if (inicio !=null)
	{
            BigInteger p = null,f = null;
		NodoC presente,futuro;
		int contador = 0, contador2 = 0;
                Conductor d;
                
		presente = inicio;
		while (contador < tam)
		{
			contador2 = 0;
			futuro = presente.getSiguiente();

			while (contador2 < tam-1)
			{
                              p=new BigInteger(presente.getDato().getDpi());
                            f=new BigInteger(futuro.getDato().getDpi());
				if (p.compareTo(f)==1)
				{
					d = futuro.getDato();
					futuro.setDato(presente.getDato());
					presente.setDato(d);
				}
				contador2++;
				futuro = futuro.getSiguiente();
			}
			contador++;
			presente = presente.getSiguiente();
			futuro = presente.getSiguiente();

		}

		          System.out.println("\t***************Lista ordenada de Forma Mayor a Menor*************");
	}
	else
	{
		          System.out.println("\t***************No hay elementos en la lista*************");
	}
}
  // ordena la lista de menor a mayor 
  public void ordenarListaMenorM(){
	if (inicio!=null)
	{
                 BigInteger p = null,f = null;
		NodoC presente,  futuro;
		Conductor t;
		int contador = 0, contador2 = 0;
                presente = inicio;
		while (contador < tam)
		{
			contador2 = 0;
			futuro = presente.getSiguiente();

			while (contador2 < tam-1)
			{
                            p=new BigInteger(presente.getDato().getDpi());
                            f=new BigInteger(futuro.getDato().getDpi());
				if (p.compareTo(f)==-1)
				{
					t = futuro.getDato();
					futuro.setDato(presente.getDato());
					presente.setDato(t);
				}
				contador2++;
				futuro = futuro.getSiguiente();
			}
			contador++;
			presente = presente.getSiguiente();
			futuro = presente.getSiguiente();

		}
		          System.out.println("\t***** Lista ordenada de Forma Menor a Mayor************");
	}
	else
	{
		          System.out.println("\t***************** no hay elementos en la lista***********");
	}
}
  // genear y ejecuta el codigo de graphys para imprimir la lista doblemente  enlazada 
  public void GenerarGraphyz() {
        try {
            //escribir dot
            FileWriter codigo = new FileWriter("conductores" + ".dot");
            PrintWriter documento = new PrintWriter(codigo);
            documento.println("digraph G {\n");
            documento.println("node[shape=box]\n");
            documento.println("\t\t//generar lista doble\n");
            documento.println(ListacircularG());

            documento.println("}");
            codigo.close();

            //compilar dot y generar imagen
            File miDir = new File(".");
            String ruta = miDir.getCanonicalPath() + "\\";//ruta actual
            String salida = "C:\\graphviz-2.38\\release\\bin\\dot -Tpng " + ruta + "conductores" + ".dot -o " + ruta + "conductores"+ ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(salida);
            //abrir imagen
           /* miDir = new File(ruta +"conductores" + ".png");
            Desktop.getDesktop().open(miDir);*/

        } catch (IOException e) {
            System.out.println(e);
        }

    }
   // genera el codigo para graphyz 
   private String ListacircularG(){
  String codigo = "";
	if (inicio!=null)
	{
		NodoC aux = inicio;
		NodoC aux1 = new NodoC();
		NodoC aux2 = new NodoC();
		
		String rank1 = "";

		//==============================================crecacion de nodos  nodos=================================
		int contador1 = 0;
		int retro = 0;
		aux1 = aux;
		while (contador1 < tam)
		{
			codigo = codigo + "DD8" + contador1 + "[label=\"DPI: "+aux1.getDato().getDpi() +"\\n Nombre: "+aux1.getDato().getNombre()+"\",color=\"burlywood\", shape=box,style=filled];\n";
			aux1 = aux1.getSiguiente();
			contador1++;
		}
		//=============================================================== conexcion de nodos en fila ==========================================
		contador1 = 0;
		aux1 = aux;
		while (contador1 < tam)
		{
			if (aux1 == inicio)
			{
				rank1 = rank1 + "DD8" + contador1;
			}
			else
			{
				rank1 = rank1 + "->" + "DD8" + contador1;
			}
			retro = contador1;
			contador1++;
			aux2 = aux1;
			aux1 = aux1.getSiguiente();
		}
		codigo = codigo + "{rank=same; " + rank1 + "->" +"DD8" + "0" + ";}\n";
		rank1 = "";
		while (retro >= 0)
		{
        		if (aux2 == inicio)
			{
				rank1 = rank1 + "DD8" + retro;
			}
			else
			{
				rank1 = rank1 + "DD8" + retro + "->";
			}
			retro--;
			aux2 = aux2.getAtras();
		}
		codigo = codigo + rank1 + "->" + "DD8" +(contador1-1)+ ";\n";
		return codigo;
	}
	else
	{
		return codigo= "RR[label = \"Lista vacia\"   width = 1.5 style = filled,shape=box,style=filled,color=\"chocolate1\"]; \n";
	}
   }
   
}


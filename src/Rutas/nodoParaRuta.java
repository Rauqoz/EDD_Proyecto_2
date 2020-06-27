package Rutas;

public class nodoParaRuta {

    String contenido;
    String tiempo;
    nodoParaRuta derecha;

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public nodoParaRuta getDerecha() {
        return derecha;
    }

    public void setDerecha(nodoParaRuta derecha) {
        this.derecha = derecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public nodoParaRuta(String contenido, String tiempo) {
        this.contenido = contenido;
        this.tiempo = tiempo;
        this.derecha = null;
    }

}

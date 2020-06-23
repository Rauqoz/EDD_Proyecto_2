package Rutas;

public class nodoRutas {

    String contenido;
    int tiempo;
    nodoRutas abajo = null;
    nodoRutas derecha = null;

    public nodoRutas(String contenido, int tiempo) {
        this.contenido = contenido;
        this.tiempo = tiempo;
    }
    public nodoRutas(String contenido) {
        this.contenido = contenido;
        this.tiempo = 0;
        this.abajo = null;
        this.derecha = null;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public nodoRutas getAbajo() {
        return abajo;
    }

    public void setAbajo(nodoRutas abajo) {
        this.abajo = abajo;
    }

    public nodoRutas getDerecha() {
        return derecha;
    }

    public void setDerecha(nodoRutas derecha) {
        this.derecha = derecha;
    }

}

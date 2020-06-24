package Rutas;

public class nodoParaCrearRuta {

    int tiempo;
    String origen;
    String destino;

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public nodoParaCrearRuta(int tiempo, String origen, String destino) {
        this.tiempo = tiempo;
        this.origen = origen;
        this.destino = destino;
    }

}

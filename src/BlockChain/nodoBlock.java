package BlockChain;

import Rutas.nodoParaRuta;

public class nodoBlock {

    String llave;
    nodoBlock derecha;
    String lugarOrigen;
    String lugarDestino;
    String fechaHora;
    nodoParaRuta ruta;

    public nodoBlock(String lugarOrigen, String lugarDestino) {
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.derecha = null;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public nodoBlock getDerecha() {
        return derecha;
    }

    public void setDerecha(nodoBlock derecha) {
        this.derecha = derecha;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public nodoParaRuta getRuta() {
        return ruta;
    }

    public void setRuta(nodoParaRuta ruta) {
        this.ruta = ruta;
    }

}

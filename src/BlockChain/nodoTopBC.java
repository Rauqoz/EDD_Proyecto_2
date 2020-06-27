package BlockChain;

public class nodoTopBC {

    String nombre;
    int top;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public nodoTopBC() {
        this.nombre = "";
        this.top = 0;
    }

}

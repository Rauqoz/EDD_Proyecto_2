/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculo;
/**
 *
 * @author josed
 */
public class Carro {
    String plasca, marca, modelo,ano,color,precio,transmision;

    public Carro() {
        this.plasca = "";
        this.marca = "";
        this.modelo = "";
        this.ano = "";
        this.color = "";
        this.precio = "";
        this.transmision = "";
    }

    public Carro(String plasca, String marca, String modelo, String ano, String color, String precio, String transmision) {
        this.plasca = plasca;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
        this.precio = precio;
        this.transmision = transmision;
    }

    public String getPlasca() {
        return plasca;
    }

    public void setPlasca(String plasca) {
        this.plasca = plasca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
}

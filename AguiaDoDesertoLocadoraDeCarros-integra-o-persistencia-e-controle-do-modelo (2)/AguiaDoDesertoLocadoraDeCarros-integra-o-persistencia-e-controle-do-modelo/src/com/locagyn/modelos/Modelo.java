/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.modelos;
import com.locagyn.modelos.Marca;

/**
 *
 * @author drpvr
 */
public class Modelo {
    
    private int idModelo = 0;
    private String descricaoModelo = "";
    private String urlModelo = "";
    private Marca marca;
    
    public Modelo(){
    
}
    
public Modelo (int id, String descricao, String url, Marca marca){
    this.idModelo = id;
    this.urlModelo = url;
    this.descricaoModelo = descricao;
    this.marca = marca;
}

    public Modelo(int i, String toUpperCase, String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getidModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricaoModelo() {
        return descricaoModelo;
    }

    public void setDescricaoModelo(String descricaoModelo) {
        this.descricaoModelo = descricaoModelo;
    }

    public String getUrlModelo() {
        return urlModelo;
    }

    public void setUrlModelo(String urlModelo) {
        this.urlModelo = urlModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        //ADICIONAR O RESTO CAMPO DE EXIT DA TELA
         return idModelo + ";" + descricaoModelo + ";" + urlModelo + ";" + marca.getId() + ";"  ;
    }
    
    

}

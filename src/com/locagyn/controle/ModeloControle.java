/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.controle;
import com.locagyn.controle.IModeloControle;
import com.locagyn.persistencia.IModeloDao;
import com.locagyn.persistencia.ModeloDao;
import java.util.ArrayList;
import java.util.Iterator;
import com.locagyn.modelos.Modelo;

/**
 *
 * @author drpvr
 */
public class ModeloControle implements IModeloControle{
    IModeloDao modeloPersitencia = null;
    public ModeloControle(){
        this.modeloPersitencia = new ModeloDao();
    }
    
private boolean buscarModelo(String descricao)throws Exception{
        try {
            ArrayList<Modelo> listagemModelo = modeloPersitencia.listagemModelo();
            Iterator<Modelo> lista = listagemModelo.iterator();
            while(lista.hasNext()){
                 Modelo aux = lista.next();
                if(aux.getDescricaoModelo().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
            
        } catch (Exception erro) {
            throw erro;
        } 
        }
        
@Override
    public void incluirModelo(Modelo objeto) throws Exception {
        if(buscarModelo(objeto.getDescricaoModelo())){
            throw new Exception("Modelo já foi cadastrado");
        }
        modeloPersitencia.incluirModelo(objeto);
    }

    @Override
    public void alterarModelo(Modelo objeto) throws Exception {
        if(buscarModelo(objeto.getDescricaoModelo())){
            throw new Exception("Modelo já foi cadastrado");
        }
        modeloPersitencia.alterarModelo(objeto);
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        return modeloPersitencia.listagemModelo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

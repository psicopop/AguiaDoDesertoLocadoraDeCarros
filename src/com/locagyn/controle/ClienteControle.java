/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.controle;
import com.locagyn.modelos.Cliente;
import java.util.ArrayList;
import com.locagyn.persistencia.ClienteDao;
import com.locagyn.persistencia.IClienteDao;
import java.util.Iterator;
/**
 *
 * @author Aluno
 */
public class ClienteControle implements IClienteControle{
    IClienteDao clientePersistencia = null;
    public ClienteControle(){
        this.clientePersistencia = new ClienteDao();
    }
    private boolean buscarCliente(String nome)throws Exception{
        try {
            ArrayList<Cliente> listagem = clientePersistencia.listagemCliente();
            Iterator<Cliente> lista = listagem.iterator();
            while(lista.hasNext()){
                 Cliente aux = lista.next();
                if(aux.getNome().equalsIgnoreCase(nome)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}

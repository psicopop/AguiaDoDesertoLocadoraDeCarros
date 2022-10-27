/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.locagyn.controle;

import com.locagyn.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public interface IClienteControle {
    void incluir(Cliente objeto) throws Exception;

    void alterar(Cliente objeto) throws Exception;

    Cliente buscar(Cliente objeto) throws Exception;

    ArrayList<Cliente> listagemCliente() throws Exception;

}

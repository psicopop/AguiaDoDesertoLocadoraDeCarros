/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.locagyn.controle;
import com.locagyn.modelos.Modelo;
import java.util.ArrayList;


/**
 *
 * @author drpvr
 */
public interface IModeloControle {
   void incluirModelo(Modelo objeto)throws Exception;
    void alterarModelo(Modelo objeto)throws Exception;
    ArrayList<Modelo> listagemModelo()throws Exception;
}

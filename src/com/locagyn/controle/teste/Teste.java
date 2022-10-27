/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.controle.teste;

import com.locagyn.modelos.Marca;
import com.locagyn.modelos.Modelo;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.processing.ProcessingEnvironment;
import javax.swing.ImageIcon;
import com.locagyn.persistencia.ModeloDao;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Teste {

    public static void main(String[] args) throws Exception {
        ModeloDao modeloDao = new ModeloDao();
        ArrayList<Modelo> lista = modeloDao.listagemModelo();
        String[] saida = new String[5];
         Marca marca = new Marca();
        for (int i = 0; i < lista.size(); i++) {
           
            saida[0] = lista.get(i).getidModelo() + "";
            saida[1] = lista.get(i).getDescricaoModelo();
            saida[2] = lista.get(i).getUrlModelo();
            saida[3] = lista.get(i).getMarca().getId() + "";
            saida[4] = lista.get(i).getMarca().getDescricao();

            marca.setId(Integer.parseInt(saida[3]));
            marca.setDescricao(saida[4]);
            Modelo aux = new Modelo(Integer.parseInt(saida[0]), saida[1], saida[2], marca);

            ImageIcon iconlogoModelo = new ImageIcon((aux.getUrlModelo()));

            //Incluir nova linha na Tabela
            Object[] dados = {saida[0], saida[1], saida[2], saida[3], saida[4]};
            System.out.println(Arrays.asList(dados));
        }

    }

}

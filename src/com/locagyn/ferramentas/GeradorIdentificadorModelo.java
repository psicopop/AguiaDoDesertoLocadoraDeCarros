/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.ferramentas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author drpvr
 */
public class GeradorIdentificadorModelo {
    public static void criarArquivoDeIDModelo()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/locagyn/arquivosdedados/idModeloGerado.txt";
        //String nomeDoArquivo ="idGerado.txt";
         FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = 10+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
}
    
public static int getIDModelo()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/locagyn/arquivosdedados/idModeloGerado.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int idModelo = Integer.parseInt(linha);
        br.close();
        idModelo++;
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = idModelo+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
        return idModelo;
    }     
    
    
    
    
    
    
}

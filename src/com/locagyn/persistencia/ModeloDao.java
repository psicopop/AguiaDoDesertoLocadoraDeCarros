/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.persistencia;
import com.locagyn.modelos.Modelo;
import com.locagyn.ferramentas.GeradorIdentificador;
import com.locagyn.ferramentas.GeradorIdentificadorModelo;
import com.locagyn.modelos.Marca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 * @author Aluno
 */
public class ModeloDao implements IModeloDao{

    private String nomeDoArquivoNoDiscoModelo;
    public ModeloDao() {
        nomeDoArquivoNoDiscoModelo = "./src/com/locagyn/arquivosdedados/Modelo.txt";
    }

    @Override
    public void incluirModelo(Modelo objeto) throws Exception {
        try {
            //Cria o Arquivo 
            FileWriter fw = new FileWriter(nomeDoArquivoNoDiscoModelo, true);
            //Criar o Buffer do Arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Incluindo o ID do Objeto referenciado na Marrca
            objeto.setId(GeradorIdentificadorModelo.getIDModelo());
            //Escrevendo os dados no arquivo 
            bw.write(objeto.toString() + "\n");
            //Criando o Arqueivo 
            //FileWriter fww = new FileWriter(nomeDoArquivoNoDisco2,true);
            //Criar o Buffered
            //BufferedWriter bww = new BufferedWriter(fww);
            //Incluindo o Id do Objeto referenciado na Marca
            Modelo objetoModelo = new Modelo();
            //objeto2.setId(GeradorIdentificador.getID());
            //Escrevendo os dados no Arquivo
            //bww.write(objeto2.toString()+ "\n");
            //Fechando o Arquivo 
            bw.close();
            //bww.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        try {
            //Criando uma ArrayList que funciona como um vetor pra Arquivos
            ArrayList<Modelo> listaDeModelos = new ArrayList<Modelo>();
            
            //Abrindo o arquivo pra poder escrever
            FileReader fr = new FileReader(nomeDoArquivoNoDiscoModelo);
            //Abrindo um armazenamento
            BufferedReader br = new BufferedReader(fr);
            //Selecionando a linha pra ser escrita 
            String linha = "";
            //Looping que proporciona a verificação das linhas e geração da tabela
            while ((linha = br.readLine()) != null) {
                //Referencial para o objeto
                Modelo objetoModelo = new Modelo();
                Marca objetoMarca = new Marca();
                //Geração das informações na tabela
                String vetorString[] = linha.split(";");
                objetoModelo.setId(Integer.parseInt(vetorString[0]));
                objetoModelo.setDescricao(vetorString[1]);
                objetoModelo.setUrl(vetorString[2]);
                vetorString[3] = objetoMarca.getId()+"";
                //Se colocar na frente de uma int +"", transforma em uma String;
                //Acrecentando as informações na Lista
                listaDeModelos.add(objetoModelo);

            }
            //Fechando arquivo
            br.close();
            return listaDeModelos;
        }catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public void alterarModelo(Modelo objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
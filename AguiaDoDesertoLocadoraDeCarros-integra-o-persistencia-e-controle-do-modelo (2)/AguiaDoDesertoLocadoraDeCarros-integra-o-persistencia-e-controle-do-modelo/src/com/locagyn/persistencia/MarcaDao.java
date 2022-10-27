/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.persistencia;

import com.locagyn.ferramentas.GeradorIdentificador;
import com.locagyn.modelos.Marca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ejmcc
 */
public class MarcaDao implements IMarcaDao{
    private String nomeDoArquivoNoDisco;
    public MarcaDao() {
        nomeDoArquivoNoDisco = "./src/com/locagyn/arquivosdedados/Marca.txt";
    }
    
    @Override
    public void incluir(Marca objeto) throws Exception {
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco,true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            objeto.setId(GeradorIdentificador.getID());
            //Escreve no arquivo
            bw.write(objeto.toString()+"\n");
            //fecha o arquivo
            bw.close();		
      }catch(Exception erro){
         throw erro;
      }
    }

    @Override
    public void alterar(Marca objeto) throws Exception {
        try {
            
            ArrayList<Marca> listOfStrings = listagem();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(listOfStrings.size() + "");
            System.out.println(objeto.toString() + "");
            for(int pos=0;pos < listOfStrings.size();pos++){
                if(objeto.getId()==listOfStrings.get(pos).getId()){
                    bw.write(objeto.toString()+"\n");  
                    
                }else{
                    bw.write(listOfStrings.get(pos).toString()+"\n");  
                    System.out.println(listOfStrings.get(pos).toString() + "");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
            
       }
            
                    
    @Override
    public Marca buscar(Marca objeto) throws Exception {
    try{
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        String descricao = "";
         String url = "";
         int id = objeto.getId();
         //Buscando pelo Id a localização 
         if(objeto.getId() != 0){
             while((linha = br.readLine())!= null){
                 String marcaString[] = linha.split(";");
                 if(Integer.parseInt(marcaString[0])== objeto.getId()){
                     descricao = marcaString[1];
                     url = marcaString[2];
                     break;
                 }
             }
         }
         //Busca pela Descrição da Marca
         if(id == 0){
             while((linha = br.readLine()) != null){
                 String marcaString[] = linha.split(";");
                 if(marcaString[1].equals(objeto.getDescricao())){
                     id = Integer.parseInt(marcaString[0]);
                     descricao = marcaString[1];
                     url = marcaString[2];
                     break;
                 }
             }
             
         }
         return new Marca(id, descricao, url);
    }catch(Exception erro){
        throw erro;
    }
    
}
        
   

    @Override
    public ArrayList<Marca> listagem() throws Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                Marca objetoMarca = new Marca();
                String vetorString[] = linha.split(";");
                objetoMarca.setId(Integer.parseInt(vetorString[0]));
                objetoMarca.setDescricao(vetorString[1]);
                objetoMarca.setUrl(vetorString[2]);
                listaDeMarcas.add(objetoMarca);
            }
         br.close();
         return listaDeMarcas;
        } catch(Exception erro){
         throw erro;
        }
    }
    
}

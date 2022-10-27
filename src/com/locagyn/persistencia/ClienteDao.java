/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.persistencia;

import com.locagyn.ferramentas.GeradorIdentificador;
import com.locagyn.modelos.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ClienteDao implements IClienteDao {

    private String nomeDoArquivoNoDisco;

    public ClienteDao() {
        nomeDoArquivoNoDisco = "./src/com/locagyn/arquivosdedados/Cliente.txt";
    }

    @Override
    public void incluir(Cliente objeto) throws Exception {
        try {
            //Criando o Arquivo Cliente
            //Arquivo de escrita criando 
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            //Criando o Buffer do Arquivo Cliente
            //Buffer utiliza um mecanismo de armazenamento dentro do arquivo pra escrita
            BufferedWriter bw = new BufferedWriter(fw);
            //Incluindo o idCliente no Objeto referencial
            objeto.setIdCliente(GeradorIdentificador.getID() + 1);
            //Escrevendo no Arquivo que a gente abriu 
            bw.write(objeto.toString() + "\n");
            //Fechando o arquivo de escrita 
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
        throw new UnsupportedOperationException("IncluirClienteDao ta com erro ze ");
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {
        //Criando um lista de dados do Cliente
        ArrayList<Cliente> listOfStrings = listagemCliente();
        //Abrindo arquivo pra escrita referente a lista
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
        //Usando o Buffered pra poder armazenar no arquivo de escrita
        BufferedWriter bw = new BufferedWriter(fw);
        //Colocando pra sair as informações no arquivo de tamanho indeterminado
        System.out.println(listOfStrings.size() + "");
        //Escrever as informações do construtor do cliente no arquivo 
        System.out.println(objeto.toString() + "");
        //Uma repetição pra poder verirficar se a ordem que esta sendo apresentada no arquivo esta correta 
        for (int pos = 0; pos < listOfStrings.size(); pos++) {
            if (objeto.getIdCliente() == listOfStrings.get(pos).getIdCliente()) {
                //Usando o armazenador de dados para alterar o que ta escrito pra ordem certa
                bw.write(objeto.toString() + "\n");
            } else {
                //Mesma alteração mas caso nao passe na analise acima 
                bw.write(listOfStrings.get(pos).toString() + "\n");
                //Fazer sair na tela pro cliente o que foi alterado ou as correções 
                System.out.println(listOfStrings.get(pos).toString() + "");
            }

        }

        //Fechando o arquivo que estava aberto para a escrita 
        bw.close();
        throw new UnsupportedOperationException("AlterarClienteDao ta com erro ze ");
    }

    @Override
    public Cliente buscar(Cliente objeto) throws Exception {
        try {
            //Abrindo o Arquivo para escrita 
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            //Utilizando um armazenador para poder colocar os dados escritos
            BufferedReader br = new BufferedReader(fr);
            //Usando a linha de maneira vazia pra poder utiliza-la no arquivo
            String linha = "";
            String nome = "";
            //Usando o referencial do objeto pra poder fazer o identificador do cliente pelo nome 
            int id = objeto.getIdCliente();
            //Buscando pelo Id a Localização
            if (objeto.getIdCliente() != 0) {
                //Repetição que verifica linha por linha 
                while ((linha = br.readLine()) != null) {
                    //Utiliza um metodo de split que cria um vetor na linha do inico ate o ";"
                    String clienteString[] = linha.split(";");
                    if (Integer.parseInt(clienteString[0]) == objeto.getIdCliente()) {
//                   cpf_cnpj = clienteString[1];
//                    cnpj = clienteString[2];
                        nome = clienteString[2];
//                    razaoSocial = clienteString[3];
//                    identidade = clienteString[4];
//                    email = clienteString[5];
//                    endereco = clienteString[6];
                        break;
                    }
                }
            }
            return new Cliente(idCliente, cpf_cnpj, nome, razaoSocial, identidade, email, endereco);
        } catch (Exception erro) {
            throw new UnsupportedOperationException("BuscarClienteDao ta com erro ze ");
        }

    }

    @Override
    public ArrayList<Cliente> listagemCliente() throws Exception {
        try {
            //Utilizando novamente a Lista pra poder colocar as informações nele 
            ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
            //Abrindo o arquivo pra poder ler as informações dele 
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            //Utilizando o Buffer do arquivo pra poder ler o que ja esta armazenado
            BufferedReader br = new BufferedReader(fr);
            //Lendo de linha em linha pra poder colocar num arquivo maior 
            String linha = "";
            //Esse repita vai repetir enquanto tiver informação dentro do arquivo e so para quando nao tiver mais nada escrito
            while ((linha = br.readLine()) != null) {
                //Usando o construtor dentro do arquivo pra ler 
                Cliente objetoCliente = new Cliente();
                //Reservando um espaço de vetor pra cada componente da linha que tenha ;
                String vetorString[] = linha.split(";");
                //Colocar as informações em ordem na linha 
                objetoCliente.setIdCliente(Integer.parseInt(vetorString[0]));
                objetoCliente.setCpf_cnpj(vetorString[1]);
                //objetoCliente.setCnpj(vetorString[2]);
                objetoCliente.setNome(vetorString[2]);
                objetoCliente.setRazaoSocial(vetorString[3]);
                objetoCliente.setIdentidade(vetorString[4]);
                objetoCliente.setEmail(vetorString[5]);
                objetoCliente.setEndereco(Integer.parseInt(vetorString[6]));
                //Colocando as informações que a gente pegou no objeto em cada vetor na ArrayList
                listaDeClientes.add(objetoCliente);
            }
            //Fechando o arquivo que estava aberto para a escrita 
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
        throw new UnsupportedOperationException("IncluirClienteDao ta com erro ze ");
    }

}

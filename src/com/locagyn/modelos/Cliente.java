/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locagyn.modelos;

/**
 *
 * @author Aluno
 */
public class Cliente {

    // Atributos 
    private int idCliente = 0;
    private String cpf_cnpj = "";
    //private String cnpj = "";
    private String nome = "";
    private String razaoSocial = "";
    private String identidade = "";
    //private Telefone telefone = null ;
    private String email = "";
    private int endereco = 0;

    //Metodos 
    public Cliente(int idCliente, String cpf_cnpj, String nome, String razaoSocial, String identidade, String email, int endereco) {
        this.idCliente = idCliente;
        this.cpf_cnpj = cpf_cnpj;
        //this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.identidade = identidade;
        this.email = email;
        this.endereco = endereco;

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

//    public String getCnpj() {
//        return cnpj;
//    }
//
//    public void setCnpj(String cnpj) {
//        this.cnpj = cnpj;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }
    @Override 
    public String toString(){
        return idCliente +";"+ cpf_cnpj +";"+ nome +";"+ razaoSocial +";"+ identidade +";"+ email +";"+ endereco;
    }
}

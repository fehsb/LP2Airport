/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

/**
 *
 * @author Fabio
 */
public class Usuario {
    private int id_usuario;
    private String nome;
    private String endereco;
    private String cpf;
    private String rg;

    public Usuario() {
        this.id_usuario = -1;
        this.nome = "Nome";
        this.endereco = "Endereco";
        this.cpf = "CPF";
        this.rg = "RG";
    }

    public Usuario(int id_usuario, String nome, String endereco, String cpf, String rg) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", rg=" + rg + '}';
    }


    
}

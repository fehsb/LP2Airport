/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.util.ArrayList;

/**
 *
 * @author 41407946
 */
public class Aeroporto {
    private int id_aeroporto;
    private String nome;
    private String cidade;
    private String destino;

    public Aeroporto(int id_aeroporto, String nome, String cidade, String destino) {
        this.id_aeroporto = id_aeroporto;
        this.nome = nome;
        this.cidade = cidade;
        this.destino = destino;
    }

    public Aeroporto() {
        this.id_aeroporto = -1;
        this.nome = "nome";
        this.cidade = "cidade";
        this.destino = "destino";
    }

    public int getId_aeroporto() {
        return id_aeroporto;
    }

    public void setId_aeroporto(int id_aeroporto) {
        this.id_aeroporto = id_aeroporto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Aereporto{" + "id_aeroporto=" + id_aeroporto + ", nome=" + nome + ", cidade=" + cidade + ", destino=" + destino + '}';
    }

    
}

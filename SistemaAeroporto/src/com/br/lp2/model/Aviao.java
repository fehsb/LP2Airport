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
public class Aviao {
    private int id_aviao;
    private String modelo;
    private String capacidade;

    public Aviao() {
        this.id_aviao = -1;
        this.modelo = "modelo";
        this.capacidade = "capacidade";
    }
    
    public Aviao(int id_aviao, String modelo, String capacidade) {
        this.id_aviao = id_aviao;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public int getId_aviao() {
        return id_aviao;
    }

    public void setId_aviao(int id_aviao) {
        this.id_aviao = id_aviao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Aviao{" + "id_aviao=" + id_aviao + ", modelo=" + modelo + ", capacidade=" + capacidade + '}';
    }
    
    
}

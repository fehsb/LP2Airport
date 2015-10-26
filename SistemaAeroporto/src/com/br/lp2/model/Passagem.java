/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.util.Date;

/**
 *
 * @author Fabio
 */
public class Passagem {
    private int id_passagem;
    private String destino;
    private Date horario;
    private String poltrona;
    private String plataforma;
    private String aviao;

    public Passagem() {
        this.id_passagem = -1;
        this.destino = "destino";
        this.horario = horario;
        this.poltrona = "poltrona";
        this.plataforma = "plataforma";
        this.aviao = "aviao";
    }

    
    public Passagem(int id_passagem, String destino, Date horario, String poltrona, String plataforma, String aviao) {
        this.id_passagem = id_passagem;
        this.destino = destino;
        this.horario = horario;
        this.poltrona = poltrona;
        this.plataforma = plataforma;
        this.aviao = aviao;
    }

    public int getId_Passagem() {
        return id_passagem;
    }

    public void setId_Passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(String poltrona) {
        this.poltrona = poltrona;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    @Override
    public String toString() {
        return "Passagem{" + "id_passagem=" + id_passagem + ", destino=" + destino + ", horario=" + horario + ", poltrona=" + poltrona + ", plataforma=" + plataforma + ", aviao=" + aviao + '}';
    }
}

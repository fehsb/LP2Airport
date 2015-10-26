/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Passagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41407946
 */
public class PassagemDAO implements GenericDAO<Passagem> {

    
    private Connection connection;
    
    public PassagemDAO (){
        connection = ConnectionFactory.getConnection();
    }
    
    @Override
    public boolean insert(Passagem p) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO passagem(destino,horario,poltrona,plataforma,aviao) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getDestino());
            
            ps.setDate(2, new java.sql.Date(p.getHorario().getTime()));
            ps.setString(3, p.getPoltrona());
            ps.setString(4, p.getPlataforma());
            ps.setString(5, p.getAviao());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    @Override
    public List<Passagem> read() {
        List<Passagem> passagens = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM passagem";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Passagem p = new Passagem();
                p.setId_Passagem(rs.getInt("id_passagem"));
                p.setDestino(rs.getString("destino"));
                p.setHorario(rs.getDate("horario"));
                p.setPoltrona(rs.getString("poltrona"));
                p.setPlataforma(rs.getString("plataforma"));
                p.setAviao(rs.getString("aviao"));
                
                passagens.add(p);
            }
            rs.close();
            ps.close();
            connection.close();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

    @Override
    public boolean update(Passagem p) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "UPDATE passagem SET destino=?,horario=?,poltrona=?,plataforma=?,aviao=? WHERE id_passagem = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getDestino());
            ps.setDate(2, new java.sql.Date(p.getHorario().getTime()));
            ps.setString(3, p.getPoltrona());
            ps.setString(4, p.getPlataforma());
            ps.setString(5, p.getAviao());
            ps.setInt(6, p.getId_Passagem());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    @Override
    public boolean delete(Passagem p) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM passagem WHERE id_passagem=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getId_Passagem());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return resposta;
    }
}

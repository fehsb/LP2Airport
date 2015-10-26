/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Aviao;
import com.br.lp2.model.Usuario;
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
public class AviaoDAO implements GenericDAO<Aviao>{
    
    private Connection connection;
    
    public AviaoDAO (){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public boolean insert(Aviao a) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO aviao(modelo,capacidade) values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getModelo());
            ps.setString(2, a.getCapacidade());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    @Override
    public List<Aviao> read() {
        List<Aviao> avioes = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM aviao";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Aviao a = new Aviao();
                a.setId_aviao(rs.getInt("id_aviao"));
                a.setModelo(rs.getString("modelo"));
                a.setCapacidade(rs.getString("capacidade"));
                
                avioes.add(a);
            }
            rs.close();
            ps.close();
            connection.close();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(AviaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avioes;
    }

    @Override
    public boolean update(Aviao a) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "UPDATE aviao SET modelo=?,capacidade=? WHERE id_aviao = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getModelo());
            ps.setString(2, a.getCapacidade());
            ps.setInt(3, a.getId_aviao());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    @Override
    public boolean delete(Aviao a) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM aviao WHERE id_aviao=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getId_aviao());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return resposta;
    }
}

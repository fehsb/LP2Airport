/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;
import com.br.lp2.model.Aeroporto;
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
 * @author 41404750
 */
public class AeroportoDAO implements GenericDAO<Aeroporto>{
    private Connection connection;

    @Override
    public boolean insert(Aeroporto a) {
boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO aeroporto(nome,cidade,destino) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCidade());
            ps.setString(3, a.getDestino());
            
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
      
        return resposta;
    
    }

    @Override
    public List<Aeroporto> read() {
    List<Aeroporto> aeroportos = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM aeroporto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Aeroporto a = new Aeroporto();
                a.setId_aeroporto(rs.getInt("id_aeroporto"));
                a.setNome(rs.getString("nome"));
                a.setCidade(rs.getString("cidade"));
                a.setDestino(rs.getString("destino"));
                
                aeroportos.add(a);
            }
            rs.close();
            ps.close();
            connection.close();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aeroportos;
    }

    @Override
    public boolean update(Aeroporto a) {
    boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "UPDATE aeroporto SET nome=?,cidade=?,destino=? WHERE id_aeroporto = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCidade());
            ps.setString(3, a.getDestino());
            ps.setInt(4, a.getId_aeroporto());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    
    
    }

    @Override
    public boolean delete(Aeroporto a) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM aeroporto WHERE id_aeroporto=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getId_aeroporto());
            int resp = ps.executeUpdate();
            if(resp<0){
                resposta = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return resposta;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

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
 * @author Fabio
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private Connection connection;
    
    public UsuarioDAO() {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public boolean insert(Usuario u) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO usuario(nome,endereco,cpf,rg) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEndereco());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getRg());
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

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM usuario";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
                u.setCpf(rs.getString("cpf"));
                u.setRg(rs.getString("rg"));
                
                usuarios.add(u);
            }
            rs.close();
            ps.close();
            connection.close();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }

    @Override
    public boolean update(Usuario u) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "UPDATE usuario SET nome=?,endereco=?,cpf=?,rg=? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEndereco());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getRg());
            ps.setInt(5, u.getId_usuario());
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

    @Override
    public boolean delete(Usuario u) {
        boolean resposta = false;
        connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, u.getId_usuario());
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

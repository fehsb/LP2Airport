/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.teste;

import com.br.lp2.model.Aeroporto;
import com.br.lp2.model.Aviao;
import com.br.lp2.model.Passagem;
import com.br.lp2.model.Usuario;
import com.br.lp2.model.dao.AeroportoDAO;
import com.br.lp2.model.dao.AviaoDAO;
import com.br.lp2.model.dao.PassagemDAO;
import com.br.lp2.model.dao.UsuarioDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class testeDao {
    public static void main(String[] args) {
        System.out.println("----- Usuario -----");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("Ler");
        List<Usuario> listaU = usuarioDAO.read();
        for (Usuario usuario : listaU) {
            System.out.println(usuario);
        }
        System.out.println("Deletar");
        Usuario u2 = listaU.get(listaU.size()-1);
        usuarioDAO.delete(u2);
        
        
        
        listaU = usuarioDAO.read();
        for (Usuario usuario : listaU) {
            System.out.println(usuario);
        }
        System.out.println("Inserir");
        Usuario u3 = listaU.get(listaU.size()-1);
        u3.setNome("Mad");
        u3.setEndereco("OtraRua");
        u3.setCpf("Otrocpf");
        u3.setRg("Otrorg");
        usuarioDAO.insert(u3);
        
        listaU = usuarioDAO.read();
        for (Usuario usuario : listaU) {
            System.out.println(usuario);
        }
        
        System.out.println("Update");
        Usuario u = listaU.get(listaU.size()-1);
        u.setNome("MadGordo");
        u.setEndereco("OtraRua2");
        u.setCpf("Otrocpf2");
        u.setRg("Otrorg2");
        usuarioDAO.update(u);
        
        listaU = usuarioDAO.read();
        for (Usuario usuario : listaU) {
            System.out.println(usuario);
        }
        
        
        System.out.println("----- Aeroporto -----");
        AeroportoDAO aeroportoDAO = new AeroportoDAO();
        System.out.println("Ler");
        List<Aeroporto> listaU2 = aeroportoDAO.read();
        for (Aeroporto aeroporto : listaU2) {
            System.out.println(aeroporto);
        }
        
        System.out.println("Inserir");
        Aeroporto a3 = listaU2.get(listaU2.size()-1);
        a3.setNome("Mad");
        a3.setCidade("OtraRua");
        a3.setDestino("Otrocpf");
        aeroportoDAO.insert(a3);
        listaU2 = aeroportoDAO.read();
        for (Aeroporto aeroporto : listaU2) {
            System.out.println(aeroporto);
        }
        
        System.out.println("Update");
        Aeroporto a = listaU2.get(listaU2.size()-1);
        a.setNome("MadGordo");
        a.setCidade("OtraRua2");
        a.setDestino("Otrocpf2");
        aeroportoDAO.update(a);
        listaU2 = aeroportoDAO.read();
        for (Aeroporto aeroporto : listaU2) {
            System.out.println(aeroporto);
        }
        
        System.out.println("Deletar");
        Aeroporto a2 = listaU2.get(listaU2.size()-1);
        aeroportoDAO.delete(a2);
        listaU2 = aeroportoDAO.read();
        for (Aeroporto aeroporto : listaU2) {
            System.out.println(aeroporto);
        }
        
        System.out.println("----- Aviao -----");
        AviaoDAO aviaoDAO = new AviaoDAO();
        System.out.println("Ler");
        List<Aviao> listaU3 = aviaoDAO.read();
        for (Aviao aviao : listaU3) {
            System.out.println(aviao);            
        }
        
        System.out.println("Inserir");
        Aviao av3 = listaU3.get(listaU3.size()-1);
        av3.setModelo("Mad");
        av3.setCapacidade("OtraRua");
        aviaoDAO.insert(av3);
        listaU3 = aviaoDAO.read();
        for (Aviao aviao : listaU3) {
            System.out.println(aviao);
        }
        
        System.out.println("Update");
        Aviao av = listaU3.get(listaU3.size()-1);
        av.setModelo("MadGordo");
        av.setCapacidade("OtraRua2");
        aviaoDAO.update(av);
        listaU3 = aviaoDAO.read();
        for (Aviao aviao : listaU3) {
            System.out.println(aviao);
        }
        
        System.out.println("Deletar");
        Aviao av2 = listaU3.get(listaU3.size()-1);
        aviaoDAO.delete(av2);
        listaU3 = aviaoDAO.read();
        for (Aviao aviao : listaU3) {
            System.out.println(aviao);
        }
        
        System.out.println("----- Passagem -----");
        PassagemDAO passagemDAO = new PassagemDAO();
        System.out.println("Ler");
        List<Passagem> listaU4 = passagemDAO.read();
        for (Passagem passagem : listaU4) {
            System.out.println(passagem);
        }
        
        System.out.println("Inserir");
        Passagem p3 = listaU4.get(listaU4.size()-1);
        p3.setDestino("Mad");
        Date date = new Date();
        p3.setHorario(date);
        p3.setPoltrona("OtraRua");
        p3.setPlataforma("OtraRua");
        p3.setAviao("OtraRua");
        passagemDAO.insert(p3);
        listaU4 = passagemDAO.read();
        for (Passagem passagem : listaU4) {
            System.out.println(passagem);
        }
        
        System.out.println("Update");
        Passagem p = listaU4.get(listaU4.size()-1);
        p.setDestino("Mad");
        
        p.setHorario(date);
        p.setPoltrona("OtraRua3w");
        p.setPlataforma("OtraRuae3");
        p.setAviao("OtraRua232");
        passagemDAO.update(p);
        listaU4 = passagemDAO.read();
        for (Passagem passagem : listaU4) {
            System.out.println(passagem);
        }
        
        System.out.println("Deletar");
        Passagem p2 = listaU4.get(listaU4.size()-1);
        passagemDAO.delete(p2);
        listaU4 = passagemDAO.read();
        for (Passagem passagem : listaU4) {
            System.out.println(passagem);
        }
    }
    
}

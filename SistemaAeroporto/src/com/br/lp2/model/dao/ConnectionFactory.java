/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabio
 */
public class ConnectionFactory {
    
    private static String driver = "org.apache.derby.jdbc.ClientDriver";
    private static String protocolo = "jdbc:derby:";
    private static String db = "Aeroporto";
    private static String dominio = "//localhost:1527/";
    private static String user = "fabimz";
    private static String pass = "123";
    private static Connection connection;
    
    public static Connection getConnection(){
        try{
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(protocolo+dominio+db, user, pass);
        } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex){
            ex.printStackTrace();
        } 
        
        return connection;
                
    }
    
}

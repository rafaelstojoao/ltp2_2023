/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author unifai
 */
public class Conexao2 {
    private String user;
    private String password;
    private String database;
    private String port;
    private String server;
    private String url;
    
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet res  = null;
    
    public void Conecta(){
        try{ 
            ReadINI();
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            stmt = con.createStatement();
            System.out.println("Conectado");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void ReadINI(){
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream("config.ini"));
            user        = prop.getProperty("User");
            password    = prop.getProperty("Password");
            database    = prop.getProperty("Database");
            port        = prop.getProperty("Port"); 
            server      = prop.getProperty("Server");       
            url         = prop.getProperty("Url") + server + ":" + port + "/" + database;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }     
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author unifai
 */
public class Conexao2 {
    String url = "jdbc:mysql://localhost:3306/dbfaindmap";
    private final String user = "sistema";
    private final String senha = "498123498";
    
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet res  = null;
    
    public void Conecta(){
        try{          
            this.con = DriverManager.getConnection(this.url, this.user, this.senha);
            stmt = con.createStatement();
            System.out.println("Conectado");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

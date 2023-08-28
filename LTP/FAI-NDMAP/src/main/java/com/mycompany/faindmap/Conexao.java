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
public class Conexao {
    String url = "jdbc:mysql://localhost:3306/faindmapdb";
    private final String user = "sistema";
    private final String senha = "om315";
    
    public Connection con = null;
    public Statement stmt = null;
    
    public void Conecta(){
        try{
            this.con = DriverManager.getConnection(this.url, this.user, this.senha);
            System.out.println("Conectado");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Grava(String sql) throws SQLException{
        stmt = con.createStatement();
        if (stmt.execute(sql)) {
            System.out.println("Gravado");
        }
    }
    
    public void ListData(String sql) throws SQLException{
        stmt = con.createStatement();
        
        ResultSet res = stmt.executeQuery(sql);
        
        while (res.next()){
            int ID = res.getInt("cod_vertice");
            String Nome = res.getString("Nome");
            System.out.println("ID: " + ID + "Nome: " + Nome);
        }
    }
}

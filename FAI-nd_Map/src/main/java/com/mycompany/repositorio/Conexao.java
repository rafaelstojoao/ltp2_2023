/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author unifai
 */
public class Conexao {
    
    String url =  "jdbc:mysql://localhost:3306/faindmapdb";
    private String user = "root";
    private String password = "";

    public Connection con = null;
    public Statement stmt = null;
    
    public void Conecta()
    {
        try
        {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        conexao.Conecta();
    }
}

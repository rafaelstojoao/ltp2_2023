/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author unifai
 */
public class Repositorio extends Conexao {
    
    public Repositorio()
    {
        this.Conecta();
    }
    
    public void Gravar(String sql) throws SQLException {
        stmt = con.createStatement();
        if(stmt.execute(sql)) {
            System.out.println("Gravado");
        }
    }
    
    public void ListData() throws SQLException {
        stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from vertices");
        while (res.next()) {
            String nome = res.getString("Nome");
            System.out.println(nome + "\n");
        }
    }
    
}

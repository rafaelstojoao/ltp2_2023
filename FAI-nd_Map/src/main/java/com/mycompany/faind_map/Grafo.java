/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faind_map;

import com.mycompany.repositorio.Repositorio;
import java.sql.SQLException;

/**
 *
 * @author unifai
 */
public class Grafo {
    
    public static void main(String[] args) {

        Repositorio repositorio = new Repositorio();
        
        String sql = "insert into vertices (Nome) values ('Testando a inserção de vertice 2')";
        
        try
        {
            repositorio.Gravar(sql);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

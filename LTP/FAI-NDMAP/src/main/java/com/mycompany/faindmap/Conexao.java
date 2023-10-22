package com.mycompany.faindmap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    public Statement stm; // Responsavel por preparar e realizar pesquisas no banco de dados;
    public ResultSet rs; // Responsavel por armazenar o resultado de um pesquisa passada para o statement;
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String servidor = "192.168.0.114";
    private String banco = "faindmap";
    private String usuario = "sa";
    private String senha = "498123498";
    
    private String caminho = "jdbc:sqlserver://"+ servidor +";databaseName=" + banco + ";user=" + usuario + ";password=" + senha; // O "control" representa a minha database 
    public Connection conexao; // Responsavel por realizar a conexão com o banco de dados;

    public void conectar() throws ClassNotFoundException, SQLException { 
        try{
            conexao = DriverManager.getConnection("jdbc:sqlserver://192.168.0.114:1433;databaseName=faindmap;user=sa;password=498123498");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() { // Metodo responsavel por fechar a conexão
        try {
            conexao.close(); // Fechar conexão
            JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
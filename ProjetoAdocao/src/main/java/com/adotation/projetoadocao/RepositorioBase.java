/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adotation.projetoadocao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author unifai
 */
public abstract class RepositorioBase {
    
    protected static String caminhoPadrao = "C:\\Users\\unifai\\Downloads\\ltp2_2023-proter\\Arquivos";
    
    protected String fileName;
    
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;
    
    private FileReader fr;
    private BufferedReader br;
    
    public RepositorioBase(String fileName) {
        this.fileName = fileName;
        this.CriarArquivo();
    }
    
    private void CriarArquivo() {
        try
        {
            file = new File(caminhoPadrao + "\\" + fileName);
            
            if(!file.exists())
            {
                file.mkdir();
                file.createNewFile();
            }
        }
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void InserirDado(String data) {
    
        try
        {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            bw.append(data);
            
            fw.close();
            bw.close();
        }
        catch (IOException ex) 
        { 
            System.out.println(ex.getMessage());
        }
    }
    
    protected ArrayList<String> LerDados()
    {
        try
        {
            ArrayList<String> dados = new ArrayList();
            
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            
            while( br.ready() )
            {
                dados.add(br.readLine());
            }
            
            return dados;
        }
        catch (IOException ex) 
        {
            return null;
        }
    }
}

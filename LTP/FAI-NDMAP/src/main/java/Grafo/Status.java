/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.Random;

/**
 *
 * @author unifai
 */
public class Status {
    protected String Descricao;
    protected Boolean Ativo;
    protected int Id;
    
    public Status(String descricao){
       Random r = new Random();
       this.Id = r.nextInt();
       this.Descricao = descricao;
       this.Ativo = true;
    }    
    
    public Status(){
       Random r = new Random();
       this.Id = r.nextInt();
       this.Descricao = "Ativo";
       this.Ativo = true;
    }
    
    protected void InativaStatus(){
        this.Ativo = false;
        this.Descricao = "Inativo";
    }
    
    protected void BloqueiaStatus(){
        this.Ativo = false;
        this.Descricao = "Bloqueado";
    }
}

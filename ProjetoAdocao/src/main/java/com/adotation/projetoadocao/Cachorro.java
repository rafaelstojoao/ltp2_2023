/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adotation.projetoadocao;

/**
 *
 * @author unifai
 */
public class Cachorro {
    
    public String raca;
    public int idade;
    public String pelagem;
    public String cor;
    private int codigoChip;
    public String nome;
    
    
    public void latir(){
        System.out.println("au au...");
    }
    
    public void DaNomeProCachorro(String nome){
        this.nome = nome;
    }
    
    public void setCodigoChip(int codigo){
        this.codigoChip = codigo;
    }

    public int getChip(){
        return this.codigoChip;
    }
    
}

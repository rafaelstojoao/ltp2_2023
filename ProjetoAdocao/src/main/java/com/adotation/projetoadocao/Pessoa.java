/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.adotation.projetoadocao;

import java.util.Random;

/**
 *
 * @author unifai
 */
public class Pessoa {

    public String nome;
   private char sexo;
   private float altura;
   private float peso;
   public Cachorro c;

   
   
   public void AdotaCachorro(
                            String cor, 
                            int idd, 
                            String raca,
                            String pelo){
      this.c = new Cachorro();
      this.c.cor = cor;
      this.c.idade = idd;
      this.c.raca = raca;
      this.c.pelagem = pelo;
      Random r = new Random();
      this.c.setCodigoChip(r.nextInt(999999));
      
   
     
   }
  
    public static void main(String[] args) {
        Pessoa p  = new Pessoa();
        p.nome = "Maria";
        p.peso = 45.8f;
        p.altura = 1.76f;
        p.sexo  = 'M';
        
        p.AdotaCachorro("caramelo", 3, "Vira Lata Brasiliensis", "curto");
        p.c.DaNomeProCachorro("totó");
        
        System.out.println("A pessoa: " + p.nome);
        System.out.println("adotou o cachorro: " + p.c.nome);
        System.out.println("Chipado com o número: " + p.c.getChip());

        RepositorioPessoa repositorio = new RepositorioPessoa("pessoas.dat");
        
    }
    
}

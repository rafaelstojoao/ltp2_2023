/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.meuprimeiroprojeto;

/**
 *
 * @author Leticia Mineguini
 */
public class Calculadora {
    public String cor;
    public String tecla;
    public float tamanho;
    public float peso;
    public float resultados;
    public int resultadosint;
   
    public int somar(int valor1, int valor2){
        this.resultadosint = valor1 +valor2;
        return this.resultadosint;
    }
      public float somar(float valor1, float valor2){
        this.resultados = valor1 +valor2;
        return this.resultados;
    }
    public static void main(String[] args) {
        Calculadora hp = new Calculadora();
        System.out.println( hp.somar(5, 6));
         System.out.println( hp.somar(34.56f, 12.54f));
   
    }
    
}

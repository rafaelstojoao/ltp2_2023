/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

/**
 *
 * @author unifai
 */
public class Calculadora {
    
    public String cor;
    public String teclas;
    public float tamanho;
    public float peso;
    public float resultado;
    
    public float somar(float valor1, float valor2){
        this.resultado = valor1 + valor2;
        return this.resultado;
    }
    
    public float somar(int valor1, int valor2){
        this.resultado = valor1 + valor2;
        return this.resultado;
    }
    
    public static void main(String[] args) {
        Calculadora hp = new Calculadora();
        Calculadora multilaser = new Calculadora();
        
        System.out.println(hp.somar(5, 6));
        System.out.println(multilaser.somar(5.24f, 6.56f));
    }
}

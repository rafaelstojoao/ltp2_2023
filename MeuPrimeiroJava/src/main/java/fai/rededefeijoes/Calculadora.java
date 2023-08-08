/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fai.rededefeijoes;

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

    public float Somar(float valor1, float valor2) {
        this.resultado = valor1 + valor2;
        return this.resultado;
    }

    public float Somar(int valor1, int valor2) {
        this.resultado = valor1 + valor2;
        return this.resultado;
    }

    public static void main(String[] args) {
        Calculadora hp = new Calculadora();
        Calculadora multilaser = new Calculadora();
        Calculadora microsoft = new Calculadora();

        System.out.println(multilaser.Somar(15, 4));
    }
}

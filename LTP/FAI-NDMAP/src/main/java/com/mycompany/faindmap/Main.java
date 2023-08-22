/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.faindmap;

import Grafo.Direcao;
import Grafo.Grafo;
import Grafo.Status;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        Conexao c = new Conexao();
        int vOpcao = 0;   
        
        Grafo grafo = new Grafo();
        grafo.CriaAresta();
        grafo.CriarVertice();
        
        System.out.println("Digite um nome: ");
        grafo.vertices.get(0).MudaNome(teclado.nextLine()); 
        
        System.out.println("Digite o Andar: ");
        grafo.vertices.get(0).MudaAndar(teclado.nextInt());
        
        System.out.println("Digite o Bloco: ");
        grafo.vertices.get(0).MudaBloco(teclado.nextInt());
        
        System.out.println("Digite o Campos: ");
        grafo.vertices.get(0).MudaCampos(teclado.nextInt());
        
        System.out.println("Digite o Número da Sala: ");
        grafo.vertices.get(0).MudaNumeroSala(teclado.nextInt());
        
        System.out.println("Digite o Latitude, Longitude e Altitude respectivamente: ");
        grafo.vertices.get(0).MudaLocalizacao(teclado.nextDouble(), teclado.nextDouble(), teclado.nextDouble());
        
        do {
            System.out.println("Digite o Status [0: DEFAULT; 1: ATIVO; 2: INATIVO; 3: BLOQUEADO; 4: EM_REFORMA;]: ");
            vOpcao = teclado.nextInt();
            
            switch (vOpcao) {
                case 1 -> {
                   grafo.vertices.get(0).MudaStatus(Status.ATIVO); 
                   vOpcao = 0;
                }
                case 2 -> {
                    grafo.vertices.get(0).MudaStatus(Status.INATIVO);   
                    vOpcao = 0;
                }
                case 3 -> {
                    grafo.vertices.get(0).MudaStatus(Status.BLOQUEADO);  
                    vOpcao = 0;
                }
                case 4 -> {
                    grafo.vertices.get(0).MudaStatus(Status.EM_REFORMA);   
                    vOpcao = 0;
                }
                case 0 -> {
                    grafo.vertices.get(0).MudaStatus(Status.ATIVO);   
                }
                default -> {
                   System.out.println("Opção não encontrada ");
                }
            }   
        } while (vOpcao != 0);
        
    
        c.Conecta(); 
        c.Grava("INSERT INTO vertices (nome, andar, bloco, campos, numero_sala, coordenadas, status) values( '" + 
            grafo.vertices.get(0).RetornaNome() + "', '" + grafo.vertices.get(0).RetornaAndar() + "', '" + 
            grafo.vertices.get(0).RetornaBloco() + "', '" + grafo.vertices.get(0).RetornaCampos() + "', " +
            grafo.vertices.get(0).RetornaNumeroSala() + ", ('" + grafo.vertices.get(0).RetornaLatitude() + ", " + 
            grafo.vertices.get(0).RetornaLongitude() + ", " + grafo.vertices.get(0).RetornaAltitude() + "'), '" +
            grafo.vertices.get(0).RetornaStatus() + "');"
        );
                
    }
}
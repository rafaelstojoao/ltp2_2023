/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.Random;

public class Vertice {
    private String Nome;
    private GeoLoc Coordenadas;
    private String Bloco;
    private String Andar;
    private Integer NumeroSala;
    private Status Status;
    private String Campos;
    private final int Id;
    
    
    public Vertice(){
        Random r = new Random();
        this.Id = r.nextInt();
    }
    
    public void MudaNome(String nome){
        this.Nome = nome;
    }
    
    public String RetornaNome(){
        return this.Nome;
    }
    
    public void MudaLocalizacao(double latitude, double longitudo, double elevacao){
        Coordenadas = new GeoLoc();
        this.Coordenadas.Altitude = latitude;
        this.Coordenadas.Latitude = longitudo;
        this.Coordenadas.Longitude = elevacao;
    }
    
    public ArrayList<Double> RetornaLocalizacao(){
        ArrayList<Double> CoordenadasMap = new ArrayList<>();
        CoordenadasMap.add(this.Coordenadas.Latitude);
        CoordenadasMap.add(this.Coordenadas.Longitude);
        CoordenadasMap.add(this.Coordenadas.Altitude);
        return CoordenadasMap;
    }
    
    public void MudaBloco(String bloco){
        this.Bloco = bloco;
    }
    
    public String RetornaBloco(){
        return this.Bloco;
    }
    
    public void MudaAndar(String andar){
        this.Andar = andar;
    }
    
    public String RetornaAndar(){
        return this.Andar;
    }
    
    public void MudaNumeroSala(Integer numeroSala){
        this.NumeroSala = numeroSala;
    }
    
    public Integer RetornaNumeroSala(){
        return this.NumeroSala;
    }
    
    public void MudaStatus(Status status){
        this.Status = status;
    }
    
    public Status RetornaStatus(){
        return this.Status; 
    }
    
    public void MudaCampos(String campos){
        this.Campos = campos;
    }
    
    public String RetornaCampos(){
        return this.Campos;
    }
    
    public Integer RetornaId(){
        return this.Id;
    }
}

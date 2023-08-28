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
    private int Bloco;
    private int Andar;
    private int NumeroSala;
    private Status Status;
    private int Campos;
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
    
    public Double RetornaLatitude(){
        return this.Coordenadas.Latitude;
    }
    public Double RetornaLongitude(){
        return this.Coordenadas.Longitude;
    }
    public Double RetornaAltitude(){
        return this.Coordenadas.Altitude;
    }
    
    public void MudaBloco(int bloco){
        this.Bloco = bloco;
    }
    
    public int RetornaBloco(){
        return this.Bloco;
    }
    
    public void MudaAndar(int andar){
        this.Andar = andar;
    }
    
    public int RetornaAndar(){
        return this.Andar;
    }
    
    public void MudaNumeroSala(Integer numeroSala){
        this.NumeroSala = numeroSala;
    }
    
    public int RetornaNumeroSala(){
        return this.NumeroSala;
    }
    
    public void MudaStatus(Status status){
        this.Status = status;
    }
    
    public Status RetornaStatus(){
        return this.Status; 
    }
    
    public void MudaCampos(int campos){
        this.Campos = campos;
    }
    
    public int RetornaCampos(){
        return this.Campos;
    }
    
    public Integer RetornaId(){
        return this.Id;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

public class GeoLoc {
    double Longitude;
    double Latitude;
    double Altitude;
    
    public void MudaLongitude(double longitude){
        this.Longitude = longitude;
    }
    
    public double RetornaLongitude(){
        return this.Longitude;
    }
    
    public void MudaLatitude(double latitude){
        this.Latitude = latitude;
    }
    
    public double RetornaLatitude(){
        return this.Latitude;
    }
    
    public void MudaAltitude(double altitude){
        this.Altitude = altitude;
    }
    
    public double RetornaAltitude(){
        return this.Altitude;
    }
}

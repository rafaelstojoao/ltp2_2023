/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package release;

import com.mycompany.faindmap.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Cezarine
 */
 class Vertice{
     
    public int cod_campos;
    public String ver_nome;
    public int cod_bloco;
    public int cod_andar;
    public int cod_vertice;
    public double peso;
   

    public void Add(Vertice vertice) {
        this.cod_vertice = vertice.cod_vertice;
        this.peso = Integer.MAX_VALUE;
        
        this.cod_campos = vertice.cod_campos;
        this.cod_andar = vertice.cod_andar;
        this.cod_bloco = vertice.cod_bloco;
        this.ver_nome = vertice.ver_nome;
    }

    

  
}

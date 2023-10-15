package com.mycompany.faindmap;


import Fomularios.Principal;
import Grafo.Aresta;
import Grafo.Direcao;
import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public void CriaVertice(Conexao c, Grafo grafo) throws SQLException{        
        PerguntasVertice(grafo, c);
        GravaVertice(grafo, c);    
    }
    public void PerguntasVertice(Grafo grafo, Conexao c) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        String nome;
        Vertice vertice = new Vertice();
        
        System.out.println("Digite um nome: ");
        vertice.setVer_nome(teclado.nextLine()); 

        System.out.println("-------------------------------------------------------------");
        vertice.setCod_andar(RetornaAndar(c));
        
        System.out.println("-------------------------------------------------------------");
        vertice.setCod_bloco(RetornaBloco(c));
        
        System.out.println("-------------------------------------------------------------");
        vertice.setCod_campos(RetornaCampos(c));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Digite o Número da Sala: ");
        vertice.setVer_numero_sala(teclado.nextInt());
        System.out.println("-------------------------------------------------------------");
        
//        System.out.println("-------------------------------------------------------------");
//        System.out.println("Digite o Longitude, Latitude e Altitude respectivamente: ");
//        vertice.setCoordenadas(teclado.nextDouble(), teclado.nextDouble(), teclado.nextDouble());
//        System.out.println("-------------------------------------------------------------");
        
        vertice.setVer_status(RetornaStatus());
        
        grafo.adicionarVertice(vertice);
    }
    public void GravaVertice(Grafo grafo, Conexao c) throws SQLException{
        String sql ="INSERT INTO vertices (ver_nome, cod_andar, cod_bloco, cod_campos, ver_numero_sala, ver_status) values(?,?,?,?,?,?)"; 
        c.pstmt = c.con.prepareStatement(sql);  
        
        c.pstmt.setString(1, grafo.vertices.get(0).getVer_nome());
        c.pstmt.setInt(2, grafo.vertices.get(0).getCod_andar());
        c.pstmt.setInt(3, grafo.vertices.get(0).getCod_bloco());
        c.pstmt.setInt(4, grafo.vertices.get(0).getCod_campos());
        c.pstmt.setInt(5, grafo.vertices.get(0).getVer_numero_sala());
        c.pstmt.setString(6, grafo.vertices.get(0).getVer_status().toString());
        c.pstmt.execute();
        c.pstmt.close();
    }
    public int BuscaVertice(Conexao c, int Origem) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        int vOpcao, vVertice=0; 
        String sql = "SELECT " +
                     "  ver.*, " +
                     "  camp.cam_nome, " +
                     "  bloc.blo_descricao, " +
                     "  ands.and_descricao  " +
                     "FROM " +
                     "  vertices ver  " +
                     "  LEFT OUTER JOIN campos camp " +
                     "    ON ver.cod_campos = camp.cod_campos " +
                     "  LEFT OUTER JOIN blocos bloc  " +
                     "    ON ver.cod_bloco = bloc.cod_bloco  " +
                     "  LEFT OUTER JOIN andares ands  " +
                     "    ON ver.cod_andar = ands.cod_andar";
        if (Origem != 0) {
            sql = sql + " WHERE ver.cod_vertice <> " + Integer.toString(Origem);
        }
        
        c.stmt = c.con.createStatement();
        
        ResultSet res = c.stmt.executeQuery(sql);   
        
        System.out.println(""); 
        System.out.println("");
        do {
            while (res.next()){
                System.out.println("Código do Vertice: " + res.getInt("cod_vertice"));
                System.out.println("Vertice: " + res.getString("ver_nome") + "- Sala " + res.getString("ver_numero_sala"));
                System.out.println("Campos: " + res.getString("cam_nome"));
                System.out.println("Bloco: " + res.getString("blo_descricao"));
                System.out.println("Andar: " + res.getString("and_descricao"));
                System.out.println("Status: " + res.getString("ver_status"));
                System.out.println("-------------------------------------------------------------");
            } 
            
            System.out.print("Digite o código: ");
            vOpcao = teclado.nextInt();
            sql = "SELECT cod_vertice FROM vertices WHERE cod_vertice = " + Integer.toString(vOpcao);
            ResultSet vBuscaVertice = c.stmt.executeQuery(sql);  
            if (vBuscaVertice == null)
                vOpcao = 0;
    
            vVertice = vOpcao;
            
        } while (vOpcao == 0);  
        return vVertice;
    }
    public int RetornaBloco(Conexao c) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        int vOpcao, vBloco=0; 
        String sql = "SELECT * FROM blocos";
        
        c.stmt = c.con.createStatement();
        
        ResultSet res = c.stmt.executeQuery(sql);   
        
        do {
            while (res.next()){
                System.out.println("Código do Bloco: " + res.getInt("cod_bloco"));
                System.out.println("Bloco: " + res.getString("blo_descricao"));
            } 
            
            System.out.print("Qual Bloco esse Laboratório está(pelo código): ");
            vOpcao = teclado.nextInt();
            sql = "SELECT cod_bloco FROM blocos WHERE cod_bloco = " + Integer.toString(vOpcao);
            ResultSet vBuscaBloco = c.stmt.executeQuery(sql);  
            if (vBuscaBloco == null)
                vOpcao = 0;
    
            vBloco = vOpcao;
            
        } while (vOpcao == 0);  
        return vBloco;
    }
    public int RetornaCampos(Conexao c) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        String sql = "SELECT * FROM campos";
        int vOpcao, vCampos=0;
        
        c.stmt = c.con.createStatement();
        ResultSet res = c.stmt.executeQuery(sql);
        
        do {
            
            while (res.next()){
                System.out.println("Código do Campos: " + res.getInt("cod_campos"));
                System.out.println("Campos: " + res.getString("cam_nome"));
            } 
            System.out.print("Qual Campos esse Laboratório está(pelo código): ");
            vOpcao = teclado.nextInt();
            sql = "SELECT cod_campos FROM campos WHERE cod_campos = " + Integer.toString(vOpcao);
            ResultSet vBuscaCampos = c.stmt.executeQuery(sql);  
            if (vBuscaCampos == null)
                vOpcao = 0;
    
            vCampos = vOpcao;
            
        } while (vOpcao == 0);  
        return vCampos;
    }
    public int RetornaAndar(Conexao c) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        String sql = "SELECT * FROM andares";
        int vOpcao, vAndares=0;
        
        c.stmt = c.con.createStatement();
        ResultSet res = c.stmt.executeQuery(sql);
        
        do {
            
            while (res.next()){
                System.out.println("Código do Andar: " + res.getInt("cod_andar"));
                System.out.println("Andar: " + res.getString("and_descricao"));
            } 
            
            System.out.print("Qual Andar esse Laboratório está(pelo código): ");
            vOpcao = teclado.nextInt();
            sql = "SELECT cod_andar FROM andares WHERE cod_andar = " + Integer.toString(vOpcao);
            ResultSet vBuscaAndar = c.stmt.executeQuery(sql);  
            if (vBuscaAndar == null)
                vOpcao = 0;
    
            vAndares = vOpcao;
            
        } while (vOpcao == 0);  
        return vAndares;
    }
    public Status RetornaStatus(){
        Scanner teclado = new Scanner(System.in);
        Status status = Status.ATIVO;
        int vOpcao ; 
        do {
            System.out.println("Digite o Status [0: DEFAULT; 1: ATIVO; 2: INATIVO; 3: BLOQUEADO; 4: EM_REFORMA;]: ");
            vOpcao = teclado.nextInt();
            
            switch (vOpcao) {
                case 1 -> {
                   status = Status.ATIVO; 
                   vOpcao = 0;
                }
                case 2 -> {
                    status = Status.INATIVO;
                    vOpcao = 0;
                }
                case 3 -> {
                    status = Status.BLOQUEADO;  
                    vOpcao = 0;
                }
                case 4 -> {
                    status = Status.EM_REFORMA;   
                    vOpcao = 0;
                }
                case 0 -> {
                    status = Status.ATIVO;   
                }
                default -> {
                   System.out.println("Opção não encontrada ");
                }
            }   
        } while (vOpcao != 0);
        return status;
    }  
    
    public void CriaAresta(Conexao c, Grafo grafo) throws SQLException{
        Scanner teclado = new Scanner(System.in);
        int vOrigem, Destino;
        Aresta aresta = new Aresta();
        
        System.out.print("Escolha a sala Origem (pelo código): ");
        vOrigem = BuscaVertice(c, 0);
        System.out.println("-------------------------------------------------------------");
        
        System.out.print("Escolha a sala Destino (pelo código): ");
        Destino = BuscaVertice(c, vOrigem);
        System.out.println("-------------------------------------------------------------");
        
        System.out.print("Qual a direção: ");
        aresta.are_direcao = RetornaDirecao();
        System.out.println("-------------------------------------------------------------");
        
        System.out.print("Qual a distância em metros: ");
        aresta.are_distancia = teclado.nextDouble(); 
        System.out.println("-------------------------------------------------------------");
        
        grafo.adicionarAresta(aresta);
        
        c.Grava("INSERT INTO aresta (are_origem, are_destino, are_direcao, are_distancia) values( " + 
                vOrigem + ", " + Destino + ", '" + grafo.vertices.get(0).getArestas().get(vOrigem).are_direcao + "', " + 
                grafo.vertices.get(0).getArestas().get(vOrigem).are_distancia + ");"
        );
        System.out.print("Ligação criada");
    }
    public Direcao RetornaDirecao(){
        Scanner teclado = new Scanner(System.in);
        Direcao direcao = Direcao.FRENTE;
        int vOpcao ; 
        do {
            System.out.println("Digite o Direcao [0: FRENTE; 1: DIREITA; 2: ESQUERDA; 3: TRAS;]: ");
            vOpcao = teclado.nextInt();
            
            switch (vOpcao) {
                case 1 -> {
                   direcao = Direcao.DIREITA; 
                   vOpcao = 0;
                }
                case 2 -> {
                    direcao = Direcao.ESQUERDA;
                    vOpcao = 0;
                }
                case 3 -> {
                    direcao = Direcao.TRAS;  
                    vOpcao = 0;
                }
                case 0 -> {
                    direcao = Direcao.FRENTE;   
                }
                default -> {
                   System.out.println("Opção não encontrada ");
                }
            }   
        } while (vOpcao != 0);
        return direcao;
    } 
    
    public int RetornaID(String tabela, String campo) throws SQLException{
        Conexao c = new Conexao();
        int novoCod=0;
        String sql = "SELECT MAX(" + campo + ") AS " + campo + " FROM " + tabela;
        
        c.Conecta();
        c.stmt = c.con.createStatement();
        
        var vResult = c.stmt.executeQuery(sql);
        if(vResult.next())
            novoCod = vResult.getInt(campo);
        c.stmt.close();
        return novoCod;
    }
    
    public static void main(String[] args) throws SQLException{
        var InstaciaClass = new Main();
        InstaciaClass.Menu();    
        
//        Conexao c = new Conexao();
//        c.Conecta();

//        Principal frm = new Principal();
//        frm.setVisible(true);
    }
    
    public void Menu() throws SQLException{
        Scanner teclado = new Scanner(System.in);
        Grafo grafo = new Grafo();
        Conexao c = new Conexao();
        int vOpcao ; 
        
        c.Conecta();
        
        do {
            System.out.println("0 -> Para sair ");
            System.out.println("1 -> Criar Sala ");
            System.out.println("2 -> Criar Conexao ");
            System.out.println("Digite o que deseja fazer: ");
            vOpcao = teclado.nextInt();
            
            switch (vOpcao) {
                case 1 -> {
                   CriaVertice(c, grafo); 
                }
                case 2 -> {
                    CriaAresta(c, grafo);
                }
                case 0 -> {
                    double LDistancia;
                    Map<Integer, Double> distancias = grafo.dijkstra(1);
                    LDistancia = grafo.dijkstra(1, 4);

                    System.out.println("Distância de " + 1 + " para " + "4" + ": " + LDistancia);

//                    for (Map.Entry<Integer, Double> entrada : distancias.entrySet()) {
//                        int destino = entrada.getKey();
//                        LDistancia = entrada.getValue();
//                        System.out.println("Distância de " + LInicio + " para " + destino + ": " + LDistancia);
//                    }
                    System.out.println("Flw pau na zorba");   
                }
                default -> {
                   System.out.println("Opção não encontrada ");
                }
            }   
        } while (vOpcao != 0);
    }
}
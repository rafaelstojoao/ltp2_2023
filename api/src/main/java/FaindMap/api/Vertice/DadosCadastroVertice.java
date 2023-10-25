package FaindMap.api.Vertice;

import FaindMap.api.Campus.Campus;

public record DadosCadastroVertice(String nome, int status, int bloco, int andar, /*Campus campus*/int campus, double latitude, double longitude) {

}

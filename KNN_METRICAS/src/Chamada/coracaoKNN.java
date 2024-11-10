package Chamada;
import Funções.Ferramentas;
import Util.Leitor_de_txt;

import java.net.URL;

public class coracaoKNN {
    public double[][]  Chamada(int k){
        double[][] matriz;
        double[][] matrizTreino;
        double[][] matrizAvaliacao;
        double[][] rotulosAvaliacao;
        double[][] rotulosTreino;
        double[][] matriz_pertinencia;
        Ferramentas ferramenta = new Ferramentas();
        URL url = getClass().getResource("/Data/wdbc.txt");
        assert url != null;
        matriz = Leitor_de_txt.lerMatrizDeArquivo(url);
        assert matriz != null;
        matrizTreino = ferramenta.partesMatriz(matriz, false);
        matrizAvaliacao = ferramenta.partesMatriz(matriz, true);
        rotulosAvaliacao = ferramenta.obterSegundaColuna(matrizAvaliacao);
        rotulosTreino = ferramenta.obterSegundaColuna(matrizTreino);
        matrizTreino = ferramenta.removerSegundaColuna(matrizTreino);
        matrizAvaliacao = ferramenta.removerSegundaColuna(matrizAvaliacao);
        matriz_pertinencia = ferramenta.dist_eucli(matrizAvaliacao, matrizTreino);
        double[][]vizinhos = ferramenta.ident_vizinho(matriz_pertinencia, rotulosTreino, k);
        double[][] tabela = new double[rotulosAvaliacao.length][2] ;
        for (int i = 0; i < vizinhos.length; i++) {
            tabela[i][1] = vizinhos[i][0];
            tabela[i][0] = rotulosAvaliacao[i][0];  
        }
        return tabela;
    }
}

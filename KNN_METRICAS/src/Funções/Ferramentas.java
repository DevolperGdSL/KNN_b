package Funções;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Ferramentas {

    public double[][] dist_eucli(double[][] matriz_objeto, double[][] matriz_base){
        int linhas = matriz_base.length;
        int colunas = matriz_objeto.length;
        double somaDosQuadrados = 0;
        double pertinencia[][] = new double[linhas][colunas];
        for(int v = 0; v<matriz_objeto.length; v++){
            for(int o=0; o< matriz_base.length; o++){
                somaDosQuadrados = 0;
                for(int i=0; i<matriz_base[0].length; i++){
                    somaDosQuadrados += Math.pow(matriz_base[o][i] - matriz_objeto[v][i], 2); 
                }
                pertinencia[o][v] = Math.sqrt(somaDosQuadrados);
            }
        }
        return pertinencia;
    }

    public static List<double[]> findNMinValuesPerColumn(double[][] matrix, int n) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<double[]> result = new ArrayList<>();
        
        for (int col = 0; col < cols; col++) {
            // Cria uma lista para armazenar pares de valor e índice
            List<double[]> valueIndexPairs = new ArrayList<>();
            for (int row = 0; row < rows; row++) {
                valueIndexPairs.add(new double[]{matrix[row][col], row});
            }
            
            // Ordena os pares pela coluna, baseando-se nos valores
            valueIndexPairs.sort(Comparator.comparingDouble(a -> a[0]));
            
            // Adiciona os n menores valores com índices à lista de resultado
            for (int i = 0; i < Math.min(n, valueIndexPairs.size()); i++) {
                result.add(new double[]{col, valueIndexPairs.get(i)[1]});
            }
        }
        
        return result;
    }

    public Double encontrarModa(double[] vetor) {
        // Mapa para armazenar a frequência de cada elemento
        Map<Double, Integer> frequencia = new HashMap<>();
        
        // Contagem das ocorrências de cada valor
        for (double valor : vetor) {
            frequencia.put(valor, frequencia.getOrDefault(valor, 0) + 1);
        }
        
        // Variáveis para guardar a moda e a frequência máxima encontrada
        double moda = vetor[0];
        int maxFrequencia = 0;
        
        // Encontra o valor com a maior frequência
        for (Map.Entry<Double, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFrequencia) {
                moda = entry.getKey();
                maxFrequencia = entry.getValue();
            }
        }
        
        return moda;
    }

    public double[][] ident_vizinho(double[][] matriz_pertinencia, double[][] rotulos_base, int k){
        int num_obj_base = matriz_pertinencia[0].length;
        double[][] matriz_rotulos_obj_estimados = new double[num_obj_base][1];
        double[] rotulos_vizinhos = new double[k];
        List<double[]> result = findNMinValuesPerColumn(matriz_pertinencia, k);
        int cont = 0;
        for (int i = 0; i < num_obj_base; i++) {
            for (int j = 0; j < k; j++) {
                double[] valueIndex = result.get(cont);
                int linhaOriginal = (int)valueIndex[1];
                rotulos_vizinhos[j] = rotulos_base[linhaOriginal][0];
                cont++;
            }
            matriz_rotulos_obj_estimados[i][0] = encontrarModa(rotulos_vizinhos);
        }
        return matriz_rotulos_obj_estimados;
    }
    public double[][] concatenarPorLinhas(double[][] matriz1, double[][] matriz2) {
        int linhas = matriz1.length + matriz2.length;
        int colunas = matriz1[0].length;
        double[][] resultado = new double[linhas][colunas];

        for (int i = 0; i < matriz1.length; i++) {
            resultado[i] = matriz1[i];
        }
        
        for (int i = 0; i < matriz2.length; i++) {
            resultado[matriz1.length + i] = matriz2[i];
        }

        return resultado;
    }   
    public double[][] partesMatriz(double[][] matriz, boolean parte){
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int meioMatriz = linhas/2;
        double[][] matrizTemp = new double[114][colunas];
        double[][] matrizTemp2 = new double[456][colunas];
        if (parte) {
            for (int i = 0; i < matrizTemp.length; i++) {
                for (int j = 0; j < colunas; j++) {
                    matrizTemp[i][j] = matriz[meioMatriz+i][j];
                }
            }
        } else{
            for (int i = 0; i < 284; i++) {
                for (int j = 0; j < colunas; j++) {
                    matrizTemp2[i][j] = matriz[i][j];
                }
            }
            for (int i = 397; i < matriz.length; i++) {
                for (int j = 0; j < colunas; j++) {
                    matrizTemp2[i-113][j] = matriz[i][j];
                }
            }
        }
        return matriz;
    }
    public double[][] obterSegundaColuna(double[][] matriz) {
        if (matriz.length == 0 || matriz[0].length < 2) {
            throw new IllegalArgumentException("A matriz não possui uma segunda coluna.");
        }
        

        double[][] segundaColuna = new double[matriz.length][1];
        for (int i = 0; i < matriz.length; i++) {
            segundaColuna[i][0] = matriz[i][1];
        }
        return segundaColuna;
    }
    public double[][] removerSegundaColuna(double[][] matriz) {
        if (matriz.length == 0 || matriz[0].length < 2) {
            throw new IllegalArgumentException("A matriz não possui uma segunda coluna para remover.");
        }

        int linhas = matriz.length;
        int colunas = matriz[0].length;
        double[][] novaMatriz = new double[linhas][colunas - 1];

        for (int i = 0; i < linhas; i++) {
            int novaColuna = 0;
            for (int j = 0; j < colunas; j++) {
                if (j == 1) continue; // Pula a segunda coluna
                novaMatriz[i][novaColuna] = matriz[i][j];
                novaColuna++;
            }
        }
        return novaMatriz;
    }

}

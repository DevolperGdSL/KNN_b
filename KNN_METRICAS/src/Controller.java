import Chamada.coracaoKNN;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    @FXML
    private TableView<MatrizConfusao> Tabela1;
    @FXML
    private TableColumn<MatrizConfusao, String> TIPO1;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Positivo1;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Negativo1;
    @FXML
    private TableView<MatrizConfusao> Tabela2;
    @FXML
    private TableColumn<MatrizConfusao, String> TIPO2;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Positivo2;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Negativo2;
    @FXML
    private TableView<MatrizConfusao> Tabela3;
    @FXML
    private TableColumn<MatrizConfusao, String> TIPO3;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Positivo3;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Negativo3;
    @FXML 
    private TableView<IndicadorDesempenho> IndDesemp1;
    @FXML
    private TableColumn<IndicadorDesempenho, String> Indicador1;
    @FXML
    private TableColumn<IndicadorDesempenho, Double> Resultado1;
    @FXML 
    private TableView<IndicadorDesempenho> IndDesemp2;
    @FXML
    private TableColumn<IndicadorDesempenho, String> Indicador2;
    @FXML
    private TableColumn<IndicadorDesempenho, Double> Resultado2;
    @FXML 
    private TableView<IndicadorDesempenho> IndDesemp3;
    @FXML
    private TableColumn<IndicadorDesempenho, String> Indicador3;
    @FXML
    private TableColumn<IndicadorDesempenho, Double> Resultado3;
    @FXML 
    private LineChart<Number, Number> rocChart;

    // Método para inicializar o controlador, chamado automaticamente pelo JavaFX
    @FXML
    public void initialize() {
        coracaoKNN chama = new coracaoKNN();
        double[][] tabela = chama.Chamada(1);
        int[][]matrizConf = matrizConf(tabela);
        TIPO1.setCellValueFactory(data -> data.getValue().tipo);
        TIPO1.setResizable(false);
        Positivo1.setCellValueFactory(data -> data.getValue().valor.asObject());
        Positivo1.setResizable(false);
        Negativo1.setCellValueFactory(data -> data.getValue().value.asObject());
        Negativo1.setResizable(false);
        ObservableList<MatrizConfusao> dados = FXCollections.observableArrayList(
            new MatrizConfusao("Positivo", matrizConf[0][0], matrizConf[0][1]),
            new MatrizConfusao("Negativo", matrizConf[1][0], matrizConf[1][1])
        );
        Tabela1.setItems(dados);
        double TRP = TPRCalc(matrizConf);
        double FRP = FRPCalc(matrizConf);
        double ACC = ACCCalc(matrizConf);
        XYChart.Series<Number, Number> model1 = new XYChart.Series<>();
        model1.setName("K=1");
        // Adicionando apenas 1 ponto para o Modelo 1
        model1.getData().add(new XYChart.Data<>(0.0, 0.0));
        model1.getData().add(new XYChart.Data<>(FRPCalc(matrizConf), TPRCalc(matrizConf)));
        model1.getData().add(new XYChart.Data<>(1, 1));  // Exemplo de FPR=0.2, TPR=0.8
        rocChart.getData().add(model1);
        Indicador1.setCellValueFactory(data -> data.getValue().indicador);
        Indicador1.setResizable(false);
        Resultado1.setCellValueFactory(data -> data.getValue().valor.asObject());
        Resultado1.setResizable(false);
        ObservableList<IndicadorDesempenho> dados2 = FXCollections.observableArrayList(
            new IndicadorDesempenho("TRP", TRP),
            new IndicadorDesempenho("FRP", FRP),
            new IndicadorDesempenho("ACC", ACC)
        );
        IndDesemp1.setItems(dados2);
        

        tabela = chama.Chamada(3);
        matrizConf = matrizConf(tabela);
        TIPO2.setCellValueFactory(data -> data.getValue().tipo);
        TIPO2.setResizable(false);
        Positivo2.setCellValueFactory(data -> data.getValue().valor.asObject());
        Positivo2.setResizable(false);
        Negativo2.setCellValueFactory(data -> data.getValue().value.asObject());
        Negativo2.setResizable(false);
        dados = FXCollections.observableArrayList(
            new MatrizConfusao("Positivo", matrizConf[0][0], matrizConf[0][1]),
            new MatrizConfusao("Negativo", matrizConf[1][0], matrizConf[1][1])
        );
        Tabela2.setItems(dados);
        TRP = TPRCalc(matrizConf);
        FRP = FRPCalc(matrizConf);
        ACC = ACCCalc(matrizConf);
        XYChart.Series<Number, Number> model2 = new XYChart.Series<>();
        model2.setName("K=3");
        // Adicionando apenas 1 ponto para o Modelo 2
        model2.getData().add(new XYChart.Data<>(0.0, 0.0));
        model2.getData().add(new XYChart.Data<>(FRPCalc(matrizConf), TPRCalc(matrizConf)));
        model2.getData().add(new XYChart.Data<>(1, 1));  // Exemplo de FPR=0.4, TPR=0.6
        rocChart.getData().add(model2);
        Indicador2.setCellValueFactory(data -> data.getValue().indicador);
        Indicador2.setResizable(false);
        Resultado2.setCellValueFactory(data -> data.getValue().valor.asObject());
        Resultado2.setResizable(false);
        dados2 = FXCollections.observableArrayList(
            new IndicadorDesempenho("TRP", TRP),
            new IndicadorDesempenho("FRP", FRP),
            new IndicadorDesempenho("ACC", ACC)
        );
        IndDesemp2.setItems(dados2);

        tabela = chama.Chamada(5);
        matrizConf = matrizConf(tabela);

        TIPO3.setCellValueFactory(data -> data.getValue().tipo);
        TIPO3.setResizable(false);
        Positivo3.setCellValueFactory(data -> data.getValue().valor.asObject());
        Positivo3.setResizable(false);
        Negativo3.setCellValueFactory(data -> data.getValue().value.asObject());
        Negativo3.setResizable(false);
        dados = FXCollections.observableArrayList(
            new MatrizConfusao("Positivo", matrizConf[0][0], matrizConf[0][1]),
            new MatrizConfusao("Negativo", matrizConf[1][0], matrizConf[1][1])
        );
        Tabela3.setItems(dados);
        TRP = TPRCalc(matrizConf);
        FRP = FRPCalc(matrizConf);
        ACC = ACCCalc(matrizConf);
        XYChart.Series<Number, Number> model3 = new XYChart.Series<>();
        model3.setName("K=5");
        // Adicionando apenas 1 ponto para o Modelo 3
        model3.getData().add(new XYChart.Data<>(0.0, 0.0));
        model3.getData().add(new XYChart.Data<>(FRPCalc(matrizConf), TPRCalc(matrizConf)));
        model3.getData().add(new XYChart.Data<>(1, 1));  // Exemplo de FPR=0.1, TPR=0.9

        // Adicionando as séries ao gráfico
        rocChart.getData().add(model3);
        Indicador3.setCellValueFactory(data -> data.getValue().indicador);
        Indicador3.setResizable(false);
        Resultado3.setCellValueFactory(data -> data.getValue().valor.asObject());
        Resultado3.setResizable(false);
        dados2 = FXCollections.observableArrayList(
            new IndicadorDesempenho("TRP", TRP),
            new IndicadorDesempenho("FRP", FRP),
            new IndicadorDesempenho("ACC", ACC)
        );
        IndDesemp3.setItems(dados2);
    }
    int[][] matrizConf(double[][] tabela){
        int[][] matrizConfusao = new int[2][2];
        for (double[] doubles : tabela) {
            if (doubles[0] == doubles[1]) {
                if (doubles[0] == 1.0) {
                    matrizConfusao[0][0] += 1; //TP
                } else {
                    matrizConfusao[1][1] += 1;//TN
                }
            } else {
                if (doubles[0] == 1) {
                    matrizConfusao[0][1] += 1;//FN
                } else {
                    matrizConfusao[1][0] += 1;//FP
                }
            }
        }
        return matrizConfusao;
    }
  
    double TPRCalc(int[][]matrizConf){
        double TPR;
        int TP = matrizConf[0][0];
        int FN = matrizConf[0][1];
        TPR =(double) TP/(TP+FN);
        return TPR; 
    }

    double FRPCalc(int[][] matrizConf){
        double FRP;
        int FP = matrizConf[1][0];
        int TN = matrizConf[1][1];
        FRP = (double)FP/(FP + TN);
        return FRP;
    }

    double ACCCalc(int[][] matrizConf){
        double ACC;
        int TP = matrizConf[0][0];
        int FN = matrizConf[0][1];
        int FP = matrizConf[1][0];
        int TN = matrizConf[1][1];
        ACC = (double)(TP + TN)/(TP+FP+TN+FN);
        return ACC;
    }
}

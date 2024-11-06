import Chamada.coracaoKNN;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyController {
    @FXML
    private TableView<MatrizConfusao> Tabela1;
    @FXML
    private TableColumn<MatrizConfusao, String> TIPO1;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Positivo1;
    @FXML
    private TableColumn<MatrizConfusao, Integer> Negativo1;

    // Método para inicializar o controlador, chamado automaticamente pelo JavaFX
    @FXML
    public void initialize() {
        coracaoKNN chama = new coracaoKNN();
        double tabela[][] = chama.Chamada(1);
        Tabela1.getColumns().add(new );
        
    }
}

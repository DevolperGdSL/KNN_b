import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class IndicadorDesempenho {
    public final SimpleStringProperty indicador;
    public final SimpleDoubleProperty valor;
    public IndicadorDesempenho(String indicador, double valor){
        this.indicador = new SimpleStringProperty(indicador);
        this.valor = new SimpleDoubleProperty(valor);
    }
}

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MatrizConfusao {
    public final SimpleStringProperty tipo;
    public final SimpleIntegerProperty valor;
    public final SimpleIntegerProperty value;

    public MatrizConfusao(String tipo, int valor, int value) {
        this.tipo = new SimpleStringProperty(tipo);
        this.valor = new SimpleIntegerProperty(valor);
        this.value = new SimpleIntegerProperty(value);
    }
}

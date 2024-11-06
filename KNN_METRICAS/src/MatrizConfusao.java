import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MatrizConfusao{
    private final SimpleStringProperty actualClass;
    private final SimpleStringProperty predictedClass;
    private final SimpleIntegerProperty value;

    public MatrizConfusao(String actualClass, String predictedClass, int value) {
        this.actualClass = new SimpleStringProperty(actualClass);
        this.predictedClass = new SimpleStringProperty(predictedClass);
        this.value = new SimpleIntegerProperty(value);
    }

    public String getActualClass() {
        return actualClass.get();
    }

    public SimpleStringProperty actualClassProperty() {
        return actualClass;
    }

    public String getPredictedClass() {
        return predictedClass.get();
    }

    public SimpleStringProperty predictedClassProperty() {
        return predictedClass;
    }

    public int getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}

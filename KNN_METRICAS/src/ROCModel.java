public class ROCModel {
    private String nome;  // Nome do modelo
    private double fpr;   // False Positive Rate
    private double tpr;   // True Positive Rate

    public ROCModel(String nome, double fpr, double tpr) {
        this.nome = nome;
        this.fpr = fpr;
        this.tpr = tpr;
    }

    public String getNome() {
        return nome;
    }

    public double getFpr() {
        return fpr;
    }

    public double getTpr() {
        return tpr;
    }
}


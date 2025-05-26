package ootrabalho;

public class Avaliacao {
    private double p1, p2, p3, listas, seminario;
    private double frequencia;
    private String formaAvaliacao;

    public Avaliacao(double p1, double p2, double p3, double listas, double seminario, double frequencia, String formaAvaliacao) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.listas = listas;
        this.seminario = seminario;
        this.frequencia = frequencia;
        this.formaAvaliacao = formaAvaliacao;
    }

    public double getMedia() {
        if (formaAvaliacao.equals("1")) {
            return (p1 + p2 + p3 + listas + seminario) / 5;
        } else {
            return (p1 + p2 * 2 + p3 * 3 + listas + seminario) / 8;
        }
    }

    public String getStatus() {
        double media = getMedia();
        if (frequencia < 75) {
            return "Reprovado por falta";
        } else if (media < 5.0) {
            return "Reprovado por nota";
        } else {
            return "Aprovado";
        }
    }

    public double getFrequencia() {
        return frequencia;
    }
}


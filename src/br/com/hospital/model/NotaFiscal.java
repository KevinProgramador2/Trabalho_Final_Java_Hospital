package br.com.hospital.model;

public class NotaFiscal {
    // Atributos (os campos de impostos que o enunciado pede)
    private String emissor;
    private String paciente;
    private double valorPis;
    private double valorCofins;
    private double valorIss;

    // A associação: A Nota Fiscal sabe de qual Fatura ela veio
    private Fatura fatura;

    // O "porquê" de ser classe: Ela executa lógica de cálculo e guarda o resultado
    public void calcularImpostos(double valorTotal) {
        this.valorPis = valorTotal * 0.0065; // Exemplo de alíquota
        this.valorCofins = valorTotal * 0.03;
    }
}

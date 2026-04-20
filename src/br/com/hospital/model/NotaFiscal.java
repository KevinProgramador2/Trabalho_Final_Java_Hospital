package br.com.hospital.model;

public class NotaFiscal {
    private String emissor;
    private String paciente;
    private double valorPis;
    private double valorCofins;
    private double valorIss;

    private Fatura fatura;

    public void calcularImpostos(double valorTotal) {
        this.valorPis = valorTotal * 0.0065; // Exemplo de alíquota
        this.valorCofins = valorTotal * 0.03;
    }
}

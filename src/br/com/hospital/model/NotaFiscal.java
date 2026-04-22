package br.com.hospital.model;

public class NotaFiscal {

    private String emissor;
    private String paciente;
    private double valorIss;
    private double valorPis;
    private double valorCofins;
    private double valorIrpj;
    private double valorCsll;
    private Fatura fatura;

    public NotaFiscal(String emissor, String paciente, double valorIss, double valorPis, double valorCofins,
            double irpj, double csll, Fatura fatura) {
        this.emissor = emissor;
        this.paciente = paciente;
        this.valorIss = valorIss;
        this.valorPis = valorPis;
        this.valorCofins = valorCofins;
        this.valorIrpj = irpj;
        this.valorCsll = csll;
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "NotaFiscal [emissor=" + emissor + ", paciente=" + paciente + ", valorIss=" + valorIss + ", valorPis="
                + valorPis + ", valorCofins=" + valorCofins + ", valorIrpj=" + valorIrpj + ", valorCsll=" + valorCsll
                + ", fatura=" + fatura + "]";
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public double getValorIss() {
        return valorIss;
    }

    public void setValorIss(double valorIss) {
        this.valorIss = valorIss;
    }

    public double getValorPis() {
        return valorPis;
    }

    public void setValorPis(double valorPis) {
        this.valorPis = valorPis;
    }

    public double getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(double valorCofins) {
        this.valorCofins = valorCofins;
    }

    public double getValorIrpj() {
        return valorIrpj;
    }

    public void setValorIrpj(double valorIrpj) {
        this.valorIrpj = valorIrpj;
    }

    public double getvalorCsll() {
        return valorCsll;
    }

    public void setvalorCsll(double valorCsll) {
        this.valorCsll = valorCsll;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }


public void calcularImpostos() {
        {

            this.valorPis = (0.65 / 100);
            this.valorCofins = (3.00 / 100);
            this.valorIss = (1.20 / 100);
            this.valorCsll = (1.08 / 100);
            this.valorIrpj = (1.20 / 100);

        }
    }
}

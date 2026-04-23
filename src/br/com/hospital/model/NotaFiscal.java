package br.com.hospital.model;

import java.math.BigDecimal;

import br.com.hospital.model.enums.ImpostosEnum;

public class NotaFiscal {

    private String emissor;
    private String paciente;
    private BigDecimal valorIss;
    private BigDecimal valorPis;
    private BigDecimal valorCofins;
    private BigDecimal valorIrpj;
    private BigDecimal valorCsll;
    private Fatura fatura;

    public NotaFiscal(String emissor, String paciente, BigDecimal valorIss, BigDecimal valorPis, BigDecimal valorCofins,
            BigDecimal irpj, BigDecimal csll, Fatura fatura) {
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

    public BigDecimal getValorIss() {
        return valorIss;
    }

    public void setValorIss(BigDecimal valorIss) {
        this.valorIss = valorIss;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getValorIrpj() {
        return valorIrpj;
    }

    public void setValorIrpj(BigDecimal valorIrpj) {
        this.valorIrpj = valorIrpj;
    }

    public BigDecimal getvalorCsll() {
        return valorCsll;
    }

    public void setvalorCsll(BigDecimal valorCsll) {
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
            this.valorPis = ImpostosEnum.PIS.getValor();
            this.valorCofins = ImpostosEnum.COFINS.getValor();
            this.valorIss = ImpostosEnum.ISS.getValor();
            this.valorCsll = ImpostosEnum.CSLL.getValor();
            this.valorIrpj = ImpostosEnum.IRPJ.getValor();

        }
    }
}

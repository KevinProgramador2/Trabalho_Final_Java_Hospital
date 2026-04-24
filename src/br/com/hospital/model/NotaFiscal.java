package br.com.hospital.model;

import java.math.BigDecimal;

import br.com.hospital.model.enums.ImpostosEnum;

public class NotaFiscal {
    private BigDecimal valorIss;
    private BigDecimal valorPis;
    private BigDecimal valorCofins;
    private BigDecimal valorIrpj;
    private BigDecimal valorCsll;
    private Fatura fatura;

    public NotaFiscal(BigDecimal valorIss, BigDecimal valorPis,
            BigDecimal valorCofins,
            BigDecimal valorIrpj, BigDecimal valorCsll, Fatura fatura) {
        this.valorIss = valorIss;
        this.valorPis = valorPis;
        this.valorCofins = valorCofins;
        this.valorIrpj = valorIrpj;
        this.valorCsll = valorCsll;
        this.fatura = fatura;
        calcularImpostos();
    }

    @Override
    public String toString() {
        return "NotaFiscal [valorIss=" + valorIss + ", valorPis=" + valorPis + ", valorCofins=" + valorCofins
                + ", valorIrpj=" + valorIrpj + ", valorCsll=" + valorCsll + ", fatura=" + fatura + ", ="
                + "]";
    }

    public void calcularImpostos() {
        {
            this.valorPis = fatura.getValor().multiply(ImpostosEnum.PIS.getValor());
            this.valorCofins = fatura.getValor().multiply(ImpostosEnum.COFINS.getValor());
            this.valorIss = fatura.getValor().multiply(ImpostosEnum.ISS.getValor());
            this.valorCsll = fatura.getValor().multiply(ImpostosEnum.CSLL.getValor());
            this.valorIrpj = fatura.getValor().multiply(ImpostosEnum.IRPJ.getValor());
        }
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

    public BigDecimal getValorCsll() {
        return valorCsll;
    }

    public void setValorCsll(BigDecimal valorCsll) {
        this.valorCsll = valorCsll;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}

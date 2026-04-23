package br.com.hospital.model;

import java.math.BigDecimal;

import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.interfaces.Cliente;

public class NotaFiscal {

    private Hospital emissor;
    private Cliente cliente;
    private BigDecimal valorIss;
    private BigDecimal valorPis;
    private BigDecimal valorCofins;
    private BigDecimal valorIrpj;
    private BigDecimal valorCsll;
    private Fatura fatura;

    public NotaFiscal(Hospital emissor, Cliente cliente, BigDecimal valorIss, BigDecimal valorPis, BigDecimal valorCofins,
            BigDecimal irpj, BigDecimal csll, Fatura fatura) {
        this.emissor = emissor;
        this.cliente = cliente;
        this.valorIss = valorIss;
        this.valorPis = valorPis;
        this.valorCofins = valorCofins;
        this.valorIrpj = irpj;
        this.valorCsll = csll;
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "NotaFiscal [emissor=" + emissor.getNome() + ", cliente=" + cliente.getNome() + ", valorIss=" + valorIss + ", valorPis="
                + valorPis + ", valorCofins=" + valorCofins + ", valorIrpj=" + valorIrpj + ", valorCsll=" + valorCsll
                + ", fatura=" + fatura.getNumero() + "]";
    }

    public Hospital getEmissor() {
        return emissor;
    }

    public void setEmissor(Hospital emissor) {
        this.emissor = emissor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

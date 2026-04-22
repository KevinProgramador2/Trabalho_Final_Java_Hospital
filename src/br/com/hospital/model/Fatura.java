package br.com.hospital.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.hospital.model.enums.ServicoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;

public class Fatura {
    private Integer id;
    private String numero;
    private BigDecimal valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private StatusCobrancaEnum statusCobranca;
    private FormaPagamentoEnum formaPagamento;
    private Cliente pagador;
    private ServicoEnum servico;

    public Fatura(Integer id, String numero, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,
            StatusCobrancaEnum statusCobranca, FormaPagamentoEnum formaPagamento, Cliente pagador,
            ServicoEnum servico) {
        this.id = id;
        this.numero = numero;
        this.valor = valor;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.statusCobranca = statusCobranca;
        this.formaPagamento = formaPagamento;
        this.pagador = pagador;
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Fatura [id=" + id + ", numero=" + numero + ", valor=" + valor + ", dataEmissao=" + dataEmissao
                + ", dataVencimento=" + dataVencimento + ", statusCobranca=" + statusCobranca + ", formaPagamento="
                + formaPagamento + ", pagador=" + pagador + ", servico=" + servico + "]";
    }

    public void pagar(FormaPagamentoEnum formaPagamento) {
        statusCobranca = StatusCobrancaEnum.PAGO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusCobrancaEnum getStatusCobranca() {
        return statusCobranca;
    }

    public void setStatusCobranca(StatusCobrancaEnum statusCobranca) {
        this.statusCobranca = statusCobranca;
    }

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getPagador() {
        return pagador;
    }

    public void setPagador(Cliente pagador) {
        this.pagador = pagador;
    }

    public ServicoEnum getServico() {
        return servico;
    }

    public void setServico(ServicoEnum servico) {
        this.servico = servico;
    }

}
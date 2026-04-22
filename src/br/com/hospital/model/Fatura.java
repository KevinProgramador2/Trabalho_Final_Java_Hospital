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
<<<<<<< HEAD
    private StatusCobranca status;
    private FormaPagamento formaDePagamento;
    private Servico servico;

    public Fatura(Integer id, Pagador pagador, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,

            StatusCobranca status, FormaPagamento formaPagamento, Servico servico) {
=======
    private StatusCobrancaEnum statusCobranca;
    private FormaPagamentoEnum formaPagamento;
    private Cliente pagador;
    private ServicoEnum servico;
    
    public Fatura(Integer id, String numero, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,
            StatusCobrancaEnum statusCobranca, FormaPagamentoEnum formaPagamento, Cliente pagador,
            ServicoEnum servico) {
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
        this.id = id;
        this.numero = numero;
        this.valor = valor;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
<<<<<<< HEAD
        this.status = status;
        this.formaDePagamento = formaPagamento;
        this.servico = servico;
    }

    public void pagar(FormaPagamento formaPagamento) {
        status = StatusCobranca.PAGO;
=======
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
        statusCobranca= StatusCobrancaEnum.PAGO;
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
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
    }

    public Integer getId() {
        return id;
    }

    public Pagador getPagador() {
        return pagador;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public StatusCobranca getStatus() {
        return status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaDePagamento;
    }

    public Servico getServico() {
        return servico;
    }

}

package br.com.hospital.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Fatura {
    private Integer id;
    private Pagador pagador;
    private BigDecimal valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private StatusCobranca status;
    private FormaPagamento formaDePagamento;
    private Servico servico;

    public Fatura(Integer id, Pagador pagador, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,

            StatusCobranca status, FormaPagamento formaPagamento, Servico servico) {
        this.id = id;
        this.pagador = pagador;
        this.valor = valor;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.formaDePagamento = formaPagamento;
        this.servico = servico;
    }

    public void pagar(FormaPagamento formaPagamento) {
        status = StatusCobranca.PAGO;
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

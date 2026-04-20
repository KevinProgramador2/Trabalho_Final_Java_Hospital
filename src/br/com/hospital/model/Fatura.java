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
    private FormaPagamento formaPagamento;
    private Servico servico;
<<<<<<< HEAD
    private NotaFiscal notaFiscal;

    public Fatura(Integer id, Pagador pagador, Double valor, LocalDate dataEmissao, LocalDate dataVencimento,
=======
    
    public Fatura(Integer id, Pagador pagador, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
            StatusCobranca status, FormaPagamento formaPagamento, Servico servico) {
        this.id = id;
        this.pagador = pagador;
        this.valor = valor;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.servico = servico;
    }

    public void pagar(FormaPagamento formaPagamento) {
        status = StatusCobranca.PAGO;
    }

}

package br.com.hospital.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.hospital.model.Fatura;
import br.com.hospital.model.FormaPagamento;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Pagador;
import br.com.hospital.model.Servico;
import br.com.hospital.model.StatusCobranca;

public class TesteCalculoNotaFiscal {
    public static void main(String[] args) {

        FormaPagamento formaDePagamento = null;
        Pagador pagador = new Pagador() {
            @Override
            public Integer getIdentificador() {
                return 123;
            }

            @Override
            public String getNome() {
                return "João Da Silva";
            }
        };

        BigDecimal valor = new BigDecimal("1500.75");
        Fatura f = new Fatura(1, pagador, valor, LocalDate.now(), LocalDate.now().plusDays(30),
                StatusCobranca.EM_ANALISE,
                formaDePagamento,
                Servico.INTERNCACAO);

        NotaFiscal nf = new NotaFiscal("Clínica Saúde XPTO Ltda.", "João Da Silva", 32.50, 150.0, 54.0, 60.0, 54.0,
                f);

        nf.calcularImpostos();

        System.out.println("Fatura valor: " + f.getValor());
        System.out.println("Nota Fiscal gerada: " + nf);
        System.out.println(
                "PIS: " + nf.getValorPis() + "\n | COFINS: " + nf.getValorCofins() + "\n | ISS: " + nf.getValorIss()
                        + "\nIRPJ" + nf.getValorIrpj() + "\nCSLL" + nf.getvalorCsll());
    }
}

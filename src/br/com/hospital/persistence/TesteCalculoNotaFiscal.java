package br.com.hospital.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import br.com.hospital.model.Cliente;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.FormaPagamentoEnum;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.enums.ServicoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;

public class TesteCalculoNotaFiscal {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente c = new Paciente("Roberto", "1234553411", "22445533", "Rua Alamida 23", LocalDate.now(), 1);
        BigDecimal valor = new BigDecimal("1500.75");
        Fatura f = new Fatura(1, "22322422", valor, LocalDate.now(), LocalDate.now(), StatusCobrancaEnum.EM_ANALISE,
                FormaPagamentoEnum.PIX, c, ServicoEnum.INTERNCACAO);

        NotaFiscal nf = new NotaFiscal("Clínica Saúde XPTO Ltda.", "João Da Silva", 32.50, 150.0, 54.0, 60.0, 54.0,
                f);

        f.equals(nf);
        nf.calcularImpostos();

        System.out.println("Fatura valor: " + f.getValor());
        System.out.println("Nota Fiscal gerada: " + nf);
        System.out.println(
                "PIS: " + nf.getValorPis() + "\n | COFINS: " + nf.getValorCofins() + "\n | ISS: " + nf.getValorIss()
                        + "\nIRPJ" + nf.getValorIrpj() + "\nCSLL" + nf.getvalorCsll());
    }
}

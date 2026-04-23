package br.com.hospital.persistence;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

import br.com.hospital.model.Cliente;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.FormaPagamentoEnum;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.enums.ServicoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;

public class TesteCalculoNotaFiscal {
        Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

                Cliente c = new Paciente("Roberto", "1234553411", "22445533", "Rua Alamida 23", LocalDate.now(), 1);
                BigDecimal valor = new BigDecimal("5000.00");

                Fatura f = new Fatura(1, "22322422", valor, LocalDate.now(), LocalDate.now(),
                                StatusCobrancaEnum.EM_ANALISE,
                                FormaPagamentoEnum.PIX, c, ServicoEnum.INTERNCACAO);

                NotaFiscal nf = new NotaFiscal("Clínica Saúde XPTO Ltda.", "João Da Silva", ImpostosEnum.ISS.getValor(), ImpostosEnum.PIS.getValor(), ImpostosEnum.COFINS.getValor(), ImpostosEnum.IRPJ.getValor(), ImpostosEnum.CSLL.getValor(),
                                f);

                nf.calcularImpostos();

                System.out.println("Fatura valor: " + f.getValor());

                System.out.println("Nota Fiscal gerada: " + nf);

                System.out.println("=== RESUMO DOS IMPOSTOS ===");

                System.out.println("ISS:    " + valor.multiply(nf.getValorIss()).setScale(2, RoundingMode.HALF_UP));
                
                System.out.println("PIS:    " + valor.multiply(nf.getValorPis()).setScale(2, RoundingMode.HALF_UP));
                
                System.out.println("COFINS: " + valor.multiply(nf.getValorCofins()).setScale(2, RoundingMode.HALF_UP));

                System.out.println("IRPJ:   " + valor.multiply(nf.getValorIrpj()).setScale(2, RoundingMode.HALF_UP));

                System.out.println("CSLL:   " + valor.multiply(nf.getvalorCsll()).setScale(2, RoundingMode.HALF_UP));

                System.out.println("================================");
        }
}
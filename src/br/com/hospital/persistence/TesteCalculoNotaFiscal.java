package br.com.hospital.persistence;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

import br.com.hospital.model.Ala;
import br.com.hospital.model.Enfermeiro;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.Internacao;
import br.com.hospital.model.Leito;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.enums.FormaPagamentoEnum;
import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.enums.TipoServicoEnum;
import br.com.hospital.model.enums.TurnoEnum;
import br.com.hospital.model.interfaces.Cliente;
import br.com.hospital.model.interfaces.Servico;
import br.com.hospital.model.enums.StatusCobrancaEnum;
import br.com.hospital.model.enums.StatusLeitoEnum;
import br.com.hospital.model.enums.TipoAlaEnum;

public class TesteCalculoNotaFiscal {
        Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

                Hospital h= new Hospital(1, "Enéas Carneiro", "23866957578");
                Enfermeiro e= new Enfermeiro(1, "Joana D'Arc", "7868757527", "2345-8996", "Rua Barão do Amazonas, 10", LocalDate.now(), "896557", TurnoEnum.NOITE);
                Ala a= new Ala(1, TipoAlaEnum.UTI, h, e);
                e.setAla(a);
                Leito l= new Leito(1, "10001", StatusLeitoEnum.LIVRE, a);
                a.addLeito(l);
                Cliente c = new Paciente("Roberto", "1234553411", "22445533", "Rua Alamida 23", LocalDate.now(), 1);
                Servico s= new Internacao(1, LocalDate.now(), c, l);
                BigDecimal valor = new BigDecimal("5000.00");

                Fatura f = new Fatura(1, "22322422", valor, LocalDate.now(), LocalDate.now(),
                                StatusCobrancaEnum.EM_ANALISE,
                                FormaPagamentoEnum.PIX, s, c);

                NotaFiscal nf = new NotaFiscal(h, c, ImpostosEnum.ISS.getValor(), ImpostosEnum.PIS.getValor(), ImpostosEnum.COFINS.getValor(), ImpostosEnum.IRPJ.getValor(), ImpostosEnum.CSLL.getValor(),
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
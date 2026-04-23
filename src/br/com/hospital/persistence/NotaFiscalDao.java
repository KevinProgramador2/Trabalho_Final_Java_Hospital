package br.com.hospital.persistence;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.Ala;
import br.com.hospital.model.Cliente;
import br.com.hospital.model.Enfermeiro;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.Internacao;
import br.com.hospital.model.Leito;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.enums.FormaPagamentoEnum;
import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.enums.TurnoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;
import br.com.hospital.model.enums.StatusLeitoEnum;
import br.com.hospital.model.enums.TipoAlaEnum;
import br.com.hospital.model.enums.TipoServicoEnum;

public class NotaFiscalDao {
        public static void main(String[] args) {
                Connection connection = new ConnectionFactory().getConnection();
                Scanner sc = new Scanner(System.in);
                FaturaDao fd= new FaturaDao();

                System.out.print("Informe o número da fatura: ");
                String numeroFatura= sc.next();                

                Fatura f = fd.consultar(numeroFatura);

                NotaFiscal nf = new NotaFiscal(h, c,
                                ImpostosEnum.ISS.getValor(),
                                ImpostosEnum.PIS.getValor(),
                                ImpostosEnum.COFINS.getValor(),
                                ImpostosEnum.IRPJ.getValor(),
                                ImpostosEnum.CSLL.getValor(),
                                f);

                nf.calcularImpostos();

                System.out.println("Fatura valor: " + f.getValor());

                System.out.println("Nota gerada: " + nf);

                System.out.println("=== RESUMO DOS IMPOSTOS ===");
                System.out.println("Nome do Paciente: " + paciente.getNome() + " " + h.getNome());
                System.out.println("ISS:    " + valor.multiply(nf.getValorIss()).setScale(2, RoundingMode.HALF_UP));
                System.out.println("PIS:    " + valor.multiply(nf.getValorPis()).setScale(2, RoundingMode.HALF_UP));
                System.out.println("COFINS: " + valor.multiply(nf.getValorCofins()).setScale(2, RoundingMode.HALF_UP));
                System.out.println("IRPJ:   " + valor.multiply(nf.getValorIrpj()).setScale(2, RoundingMode.HALF_UP));
                System.out.println("CSLL:   " + valor.multiply(nf.getvalorCsll()).setScale(2, RoundingMode.HALF_UP));

                System.out.println("================================");
        }

        public 
}
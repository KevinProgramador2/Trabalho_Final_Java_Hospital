package br.com.hospital.persistence;

import java.time.LocalDate;

import br.com.hospital.model.Fatura;
import br.com.hospital.model.FormaPagamento;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.Servico;
import br.com.hospital.model.StatusCobranca;

public class TesteCalculoNotaFiscal {
    public static void main(String[] args) {

        NotaFiscal nFiscal = new NotaFiscal();

        Paciente p = new Paciente("Rogerio", "123", "123", "Rua A", LocalDate.now(), 1);

        Fatura f = new Fatura(1, p, 5000.0, LocalDate.of(2026, 04, 20), LocalDate.of(2027, 10, 10),
                StatusCobranca.PENDENTE, FormaPagamento.PIX, Servico.ATENDIMENTO);

        p.getNome();
        p.getCpf();

        System.out.println(p);
        System.out.println(p);
    }
}

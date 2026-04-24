package br.com.hospital.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.hospital.model.*;
import br.com.hospital.model.enums.*;

public class FormatoDeSaidaDao {

    public static void main(String[] args) {
        // 1. CRIAR OS DADOS (Sem isso o arquivo sai vazio)
        Hospital h = new Hospital(1, "Hospital Geral de Clínicas", "23866957578");

        Paciente p = new Paciente("Laura", "1245323311", "2442663423",
                "Rua dos minions", LocalDate.now(), 1);

        // Simula um serviço para a fatura
        BigDecimal valorTotal = new BigDecimal("5000.00");
        Fatura f = new Fatura(1, "22322422", valorTotal, LocalDate.now(), LocalDate.now(),
                StatusCobrancaEnum.EM_ANALISE, FormaPagamentoEnum.PIX, null, p);

        NotaFiscal nf = new NotaFiscal(h, p,
                ImpostosEnum.ISS.getValor(),
                ImpostosEnum.PIS.getValor(),
                ImpostosEnum.COFINS.getValor(),
                ImpostosEnum.IRPJ.getValor(),
                ImpostosEnum.CSLL.getValor(), f);

        nf.calcularImpostos();

        List<NotaFiscal> listaDeNotas = new ArrayList<>();
        listaDeNotas.add(nf);

        exportarParaCSV(listaDeNotas, "notas_fiscais.csv");d
    }

    public static void exportarParaCSV(List<NotaFiscal> notas, String nomeArquivo) {
        try (FileWriter fw = new FileWriter(nomeArquivo);
                PrintWriter pw = new PrintWriter(fw)) {

            if (notas.isEmpty()) {
                System.out.println("Aviso: A lista de notas está vazia. Nada será escrito.");
                return;
            }

            for (NotaFiscal nf : notas) {
                String nomePaciente = nf.getCliente().getNome();
                BigDecimal valorBase = nf.getFatura().getValor();

                // Formato solicitado: <nome>;<valor>;<iss>;<pis>;<cofins>;<irpj>;<csll>
                pw.printf(Locale.US, "%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f%n",
                        nomePaciente,
                        valorBase,
                        valorBase.multiply(nf.getValorIss()),
                        valorBase.multiply(nf.getValorPis()),
                        valorBase.multiply(nf.getValorCofins()),
                        valorBase.multiply(nf.getValorIrpj()),
                        valorBase.multiply(nf.getvalorCsll()));
            }

            // Força a gravação de qualquer dado restante no buffer
            pw.flush();

            System.out.println("Processamento Concluído: Arquivo '" + nomeArquivo + "' gerado com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro crítico de I/O: " + e.getMessage());
        }
    }
}
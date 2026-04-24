package br.com.hospital.persistence.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import br.com.hospital.model.*;

public class EmitirNotaFiscal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FaturaDao fd = new FaturaDao();
        NotaFiscalDao nfd = new NotaFiscalDao();
        Fatura f;

        System.out.print("Informe o número da fatura: ");
        String numeroFatura = s.next();

        f = fd.buscar(numeroFatura);

        try {
            NotaFiscal gerada = nfd.gerar(f);

            if(gerada!= null)
                exportarParaCSV(gerada, "notas_fiscais.csv");
            else
                throw new Exception("Não foi possível gerar a Nota Fiscal. MOTIVO: Duplicada.");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static void exportarParaCSV(NotaFiscal nf, String nomeArquivo) {
        try (FileWriter fw = new FileWriter(nomeArquivo);
                PrintWriter pw = new PrintWriter(fw)) {

            pw.printf(Locale.US, "%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f%n",
                        nf.getFatura().getCliente().getNome(),
                        nf.getFatura().getValor(),
                        nf.getValorIss(),
                        nf.getValorPis(),
                        nf.getValorCofins(),
                        nf.getValorIrpj(),
                        nf.getValorCsll());

            // Força a gravação de qualquer dado restante no buffer
            pw.flush();

            System.out.println("Processamento Concluído: Arquivo '" + nomeArquivo + "' gerado com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro crítico de I/O: " + e.getMessage());
        }
    }
}
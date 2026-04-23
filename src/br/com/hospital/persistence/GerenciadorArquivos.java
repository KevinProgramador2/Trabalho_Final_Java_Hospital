package br.com.hospital.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hospital.model.Atendimento;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.Medico;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.enums.FormaPagamentoEnum;
import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.enums.StatusAtendimentoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;
import br.com.hospital.model.enums.TipoAtendimentoEnum;
import br.com.hospital.model.interfaces.Cliente;
import br.com.hospital.model.interfaces.Servico;

public class GerenciadorArquivos {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo:");
            String nomeArquivo = sc.next();

            File file = new File(nomeArquivo);
            Scanner scArquivo = new Scanner(file, "UTF-8");

            List<NotaFiscal> nFiscals = new ArrayList<>();

            // Mock de objetos necessários
            Medico medico= new Medico(1, "Maicon Nascimento", "868985765", "2457-8966", "Rua Benjamin Constant", LocalDate.of(1970, 1, 1), "8657575", "Geriatria");
            Hospital hospital = new Hospital(1, "Hospital Central", "18575781254");
            Cliente cliente = new Paciente("João Silva", "7657857844", "2764-2896", "Rua Barão do Amazonas", LocalDate.of(1970, 01, 01), 1);
            Servico servico= new Atendimento(1, LocalDateTime.now(), TipoAtendimentoEnum.CONSULTA, StatusAtendimentoEnum.REALIZADO, cliente, medico);
            Fatura fatura = new Fatura(1, "FAT-001", new BigDecimal("100.0"), LocalDate.now(), LocalDate.of(2026, 4, 30), StatusCobrancaEnum.PENDENTE, FormaPagamentoEnum.DINHEIRO, servico, cliente);

            while (scArquivo.hasNext()) {
                String linha = scArquivo.nextLine();

                if (!linha.isEmpty()) {
                    String[] dadosLinha = linha.split(";");

                    // Aqui você deveria montar corretamente cliente/emissor com base no arquivo
                    nFiscals.add(new NotaFiscal(
                            hospital,
                            cliente,
                            ImpostosEnum.ISS.getValor(),
                            ImpostosEnum.PIS.getValor(),
                            ImpostosEnum.COFINS.getValor(),
                            ImpostosEnum.IRPJ.getValor(),
                            ImpostosEnum.CSLL.getValor(),
                            fatura
                    ));
                }
            }

            scArquivo.close();
            sc.close();

            // Exibir
            for (NotaFiscal nf : nFiscals) {
                System.out.println(nf);
            }

            // Gravar arquivo
            FileWriter caminho = new FileWriter("notaFiscal.csv");
            PrintWriter gravarArquivo = new PrintWriter(caminho);

            for (NotaFiscal nf : nFiscals) {
                String linhaArquivo =
                        nf.getEmissor().getNome() + "|" +
                        nf.getCliente().getNome() + "|" +
                        nf.getValorIss() + "|" +
                        nf.getValorPis() + "|" +
                        nf.getValorCofins() + "|" +
                        nf.getValorIrpj() + "|" +
                        nf.getvalorCsll() + "|" +
                        nf.getFatura().getNumero();

                gravarArquivo.println(linhaArquivo);
            }

            gravarArquivo.close();

        } catch (Exception e) {
            e.printStackTrace(); // nunca deixe catch vazio
        }
    }
}
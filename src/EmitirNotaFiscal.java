import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.hospital.model.*;
import br.com.hospital.model.enums.*;
import br.com.hospital.persistence.FaturaDao;
import br.com.hospital.persistence.NotaFiscalDao;

public class EmitirNotaFiscal {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        FaturaDao fd= new FaturaDao();
        NotaFiscalDao nfd= new NotaFiscalDao();
        Fatura f;
        Integer opcao;
        
        do {
            System.out.print("Informe o número da fatura: ");
            String numeroFatura= s.next();

            try {
                f= fd.buscar(numeroFatura);

            } catch (NullPointerException e) {
                System.err.println("Não foi possível consultar a fatura. Tente novamente digitando valores válidos.");
            }

            NotaFiscal gerada= nfd.gerar(f);
            
            List<NotaFiscal> listaDeNotas = new ArrayList<>();
            listaDeNotas.add(nf);

            System.out.println("Digite '0' para sair.");
            System.out.println("Digite '1' para adicionar.");
            System.out.println("Deseja adicionar mais uma nota fiscal?");
            opcao= s.nextInt();

            if(opcao!= 0 && opcao!= 1) {
                while(opcao!= 0 && opcao!= 1) {
                    System.out.println("\n");
                    System.out.print("Opção inválida. Digite novamente um valor entre '0' e '1': ");
                    opcao= s.nextInt();
                    System.out.println("\n");
                }
            }

        } while (opcao!= 0);

        exportarParaCSV(listaDeNotas, "notas_fiscais.csv");
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
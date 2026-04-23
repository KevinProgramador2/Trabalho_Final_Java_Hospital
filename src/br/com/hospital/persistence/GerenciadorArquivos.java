package br.com.hospital.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hospital.model.Fatura;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.enums.ImpostosEnum;

//Responsável por criar, escrever e ler o arquivo
public class GerenciadorArquivos {

    public static void main(String[] args, Fatura fatura) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo:");
            String nomeArquivo = sc.next();

            File file = new File(nomeArquivo);
            Scanner scArquivo = new Scanner(file, "UTF-8");
            List<NotaFiscal> nFiscals = new ArrayList<>();
            while (scArquivo.hasNext()) {
                String linha = scArquivo.nextLine();
                if (!linha.isEmpty()) {
                    String[] dadosLinha = linha.split(";");
                    String nome = dadosLinha[0];
                    String profissao = dadosLinha[1];
                    nFiscals.add(new NotaFiscal(nome, profissao, ImpostosEnum.ISS.getValor(), ImpostosEnum.PIS.getValor(), ImpostosEnum.COFINS.getValor(), ImpostosEnum.IRPJ.getValor(), ImpostosEnum.CSLL.getValor(), fatura));
                }
            }
            sc.close();
            System.out.println("Gravar em um novo arquivo");

            for (NotaFiscal funcionario : nFiscals) {
                System.out.println(funcionario);
            }

            System.out.println("Gravar em um novo arquivo");
            FileWriter caminho = new FileWriter("\\imprimir\\notaFiscal.csv");
            PrintWriter gravarArquivo = new PrintWriter(caminho);
            for (NotaFiscal nFiscal : nFiscals) {
                String linhaArquivo = NotaFiscal() + "|" + NotaFiscal() + "\n";
                gravarArquivo.printf(linhaArquivo);
            }
            gravarArquivo.close();
        } catch (Exception e) {

        }
    }

    private static String NotaFiscal() {
        System.err.println("Error: metodo NotaFiscal");
        throw new UnsupportedOperationException("Unimplemented method 'NotaFiscal'");
    }

}
package br.com.hospital.persistence;

import java.io.File;
import java.sql.Connection;
import java.util.Scanner;

import br.com.hospital.conexao.ConnectionFactory;

public class LeituraFaturaCsv {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;

        Connection c = new ConnectionFactory().getConnection();

        if (args != null && args.length > 0 && args[0] != null && !args[0].isBlank()) {
            nome = args[0];
            System.out.println("Usando argumento: " + nome);
        } else {
            System.out.println("Informe o nome da pasta ou o nome do arquivo:");
            nome = ler.nextLine().trim();
        }

        if (nome.isEmpty()) {
            System.out.println("Nenhum nome informado. Encerrando.");
            ler.close();
            return;
        }

        File file = new File(nome);

        try {
            if (file.exists()) {
                if (file.isFile()) {
                    System.out.printf("Arquivo '%s' existe - tamanho: %d bytes\n", file.getName(), file.length());
                } else if (file.isDirectory()) {
                    System.out.println("Conteúdo da pasta: ");
                    String[] pasta = file.list();
                    if (pasta == null || pasta.length == 0) {
                        System.out.println("(pasta vazia)");
                    } else {
                        for (String item : pasta) {
                            System.out.println(item);
                        }
                    }
                } else {
                    System.out.println("O caminho existe mas não é um arquivo nem uma pasta acessível.");
                }
            } else {
                System.out.println("Arquivo ou pasta não encontrado: " + file.getAbsolutePath());
            }
        } catch (SecurityException se) {
            System.out.println("Sem permissão para acessar o caminho informado: " + se.getMessage());
        } finally {
            ler.close();
        }
    }
}
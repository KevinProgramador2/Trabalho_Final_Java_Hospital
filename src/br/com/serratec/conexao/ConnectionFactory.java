package br.com.serratec.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String url = "jdbc:postgresql://ep-sweet-feather-ac048z4u-pooler.sa-east-1.aws.neon.tech/neondb?sslmode=require";
    private String usuario = "neondb_owner";
    private String senha = "npg_G7jLs1ROuvgp";

    private Connection connection;

    public Connection getConnection() {
        System.out.println("Conectando no banco de dados....");
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            if (connection != null) {
                System.out.println("Conectado com sucesso!");
                return connection;
            } else {
                System.out.println("Não foi possível conectar!");
                throw new RuntimeException("Conexão retornou null");
            }

        }catch (SQLException e) {
            System.out.println("Problemas no Driver ou senha incorreta do banco");
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar no banco", e);
        }
    }
}

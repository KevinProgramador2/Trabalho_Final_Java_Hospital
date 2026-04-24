package br.com.hospital.persistence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.enums.TipoServicoEnum;

public class ServicoDao {
    private Connection connection;

    public ServicoDao() {
        connection = new ConnectionFactory().getConnection();
    }

    public TipoServicoEnum consultar(Integer servico_id) {
        String sql = "select tipo from hospital.servico where id_servico= ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, servico_id);
            ResultSet rs = statement.executeQuery();

            if (!rs.next()) {
                throw new Exception("Serviço não encontrado.");
            }

            TipoServicoEnum tipo = TipoServicoEnum.valueOf(rs.getString("tipo"));

            rs.close();
            statement.close();
            connection.close();
            return tipo;

        } catch (SQLException e) {
            System.err.println("ID inválido. Registro não encontrado.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

package br.com.hospital.persistence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.Cliente;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.enums.FormaPagamentoEnum;
import br.com.hospital.model.enums.StatusCobrancaEnum;

public class FaturaDao {
    private Connection connection;

    public FaturaDao() {
        connection = new ConnectionFactory().getConnection();
    }

    public Fatura buscar(String numero) {
        String sql1 = "select * from hospital.fatura where numero= ?";
        String sql2 = "select nome from hospital.cliente where id_cliente= ?";
        String sql3 = "select * from hospital.hospital where id_hospital= ?";
        try {
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, numero);
            ResultSet rs1 = statement1.executeQuery();

            if (!rs1.next()) {
                throw new Exception("Fatura não encontrada.");
            }

            if (StatusCobrancaEnum.valueOf(rs1.getString("statuscobranca")) != StatusCobrancaEnum.PAGO) {
                throw new Exception("Fatura não finalizada. Status atual: "+ rs1.getString("statuscobranca"));
            } else {
                ServicoDao sd = new ServicoDao();

                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, rs1.getInt("cliente_id"));
                ResultSet rs2 = statement2.executeQuery();

                if (!rs2.next()) {
                    throw new Exception("Cliente não encontrado.");
                }

                Cliente cliente = new Cliente(rs1.getInt("cliente_id"), rs2.getString("nome"));

                PreparedStatement statement3 = connection.prepareStatement(sql3);
                statement3.setInt(1, rs1.getInt("emissor_id"));
                ResultSet rs3 = statement3.executeQuery();

                if (!rs3.next()) {
                    throw new Exception("Hospital Emissor não encontrado.");
                }

                Hospital hospital = new Hospital(rs1.getInt("emissor_id"), rs3.getString("nome"),
                        rs3.getString("cnpj"));

                Fatura f = new Fatura(
                        rs1.getInt("id_fatura"),
                        rs1.getString("numero"),
                        rs1.getBigDecimal("valor"),
                        rs1.getObject("dataemissao", LocalDate.class),
                        rs1.getObject("datavencimento", LocalDate.class),
                        StatusCobrancaEnum.valueOf(rs1.getString("statuscobranca")),
                        FormaPagamentoEnum.valueOf(rs1.getString("formapagamento")),
                        sd.consultar(rs1.getInt("servico_id")),
                        cliente,
                        hospital);

                rs1.close();
                rs2.close();
                rs3.close();
                statement1.close();
                statement2.close();
                statement3.close();
                connection.close();

                return f;
            }

        } catch (SQLException e) {
            System.err.println("Fatura não encontrada.");
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

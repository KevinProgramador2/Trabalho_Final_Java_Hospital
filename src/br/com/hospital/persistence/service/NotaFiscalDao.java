package br.com.hospital.persistence.service;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.Fatura;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.enums.ImpostosEnum;
import br.com.hospital.model.enums.TipoServicoEnum;

public class NotaFiscalDao {
        private Connection connection;

        public NotaFiscalDao() {
                connection = new ConnectionFactory().getConnection();
        }

        public NotaFiscal gerar(Fatura f) {
                NotaFiscal nf = new NotaFiscal(
                                ImpostosEnum.ISS.getValor(),
                                ImpostosEnum.PIS.getValor(),
                                ImpostosEnum.COFINS.getValor(),
                                ImpostosEnum.IRPJ.getValor(),
                                ImpostosEnum.CSLL.getValor(),
                                f);

                if(inserir(nf))
                        return nf;
                else
                        return null;

                //!nf.eQuals(inserir(nf));
        }

        public Boolean inserir(NotaFiscal notaFiscal) {
                String sql = "insert into hospital.notaFiscal(emissor, cliente, descricao, valorBruto, iss, pis, cofins, irpj, csll, fatura_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, notaFiscal.getFatura().getEmissor().getNome());
                        statement.setString(2, notaFiscal.getFatura().getCliente().getNome());
                        statement.setString(3, getDescricao(notaFiscal.getFatura().getServico()));
                        statement.setBigDecimal(4, notaFiscal.getFatura().getValor().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(5, notaFiscal.getValorIss().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(6, notaFiscal.getValorPis().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(7, notaFiscal.getValorCofins().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(8, notaFiscal.getValorIrpj().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(9, notaFiscal.getValorCsll().setScale(2, RoundingMode.HALF_UP));
                        statement.setInt(10, notaFiscal.getFatura().getId());
                        statement.execute();
                        statement.close();
                        connection.close();

                        System.out.println("Dados inseridos com sucesso!");

                        return true;

                } catch (SQLException e) {
                        System.err.println("Não foi possível registrar a Nota Fiscal. MOTIVO: Duplicada.");
                        e.printStackTrace();
                }

                return false;
        }

        public String getDescricao(TipoServicoEnum servico) {
                if (servico == TipoServicoEnum.ATENDIMENTO)
                        return "Atendimento com médico";
                else if (servico == TipoServicoEnum.EXAME)
                        return "Exame clínico";
                return "Internação hospitalar";
        }
}

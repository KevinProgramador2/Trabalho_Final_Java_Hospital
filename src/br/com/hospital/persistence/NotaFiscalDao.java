package br.com.hospital.persistence;

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
        
        public void gerar(String numeroFatura) {
                FaturaDao fd= new FaturaDao();
                Fatura f = fd.buscar(numeroFatura);
                NotaFiscal nf = new NotaFiscal(
                ImpostosEnum.ISS.getValor(),
                ImpostosEnum.PIS.getValor(),
                ImpostosEnum.COFINS.getValor(),
                ImpostosEnum.IRPJ.getValor(),
                ImpostosEnum.CSLL.getValor(),
                f);

                nf.calcularImpostos();

                inserir(nf);
        }

        public void inserir(NotaFiscal notaFiscal) {
                String sql= "insert into notaFiscal(emissor, cliente, descricao, valorBrato, iss, pis, cofins, irpj, csll, fatura_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try {
                        PreparedStatement statement= connection.prepareStatement(sql);
                        statement.setString(1, notaFiscal.getFatura().getEmissor().getNome());
                        statement.setString(2, notaFiscal.getFatura().getCliente().getNome());
                        statement.setString(3, getDescricao(notaFiscal.getFatura().getServico()));
                        statement.setBigDecimal(4, notaFiscal.getFatura().getValor().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(5, notaFiscal.getValorIss().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(6, notaFiscal.getValorPis().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(7, notaFiscal.getValorCofins().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(8, notaFiscal.getValorIrpj().setScale(2, RoundingMode.HALF_UP));
                        statement.setBigDecimal(9, notaFiscal.getvalorCsll().setScale(2, RoundingMode.HALF_UP));
                        statement.setInt(10, notaFiscal.getFatura().getId());
                        statement.execute();
                        statement.close();
                        connection.close();

                        System.out.println("Dados inseridos com sucesso!");

                } catch (SQLException e) {
                        System.err.println("Não foi possível registrar a Nota Fiscal.");
                        e.printStackTrace();
                } 
        }

        public String getDescricao(TipoServicoEnum servico) {
                if(servico== TipoServicoEnum.ATENDIMENTO)
                        return "Atendimento com médico";
                else if(servico== TipoServicoEnum.EXAME)
                        return "Exame clínico";
                return "Internação hospitalar";
        }

        public String emitir(NotaFiscal notaFiscal) {
                String emissao= "NOTA FISCAL ELETRONICA DE PRESTAÇÃO DE SERVIÇO\n"+
                "Prestador de Serviço\n"+ 
                notaFiscal.getFatura().getEmissor().getNome()+ "\n"+
                "CNPJ: "+ notaFiscal.getFatura().getEmissor().getCnpj()+ "\n"+
                "\n"+
                "Tomador\n"+
                "Cliente: "+ notaFiscal.getFatura().getCliente().getNome()+ "\n"+
                "\n"+
                "Descrição do Serviço\n"+
                getDescricao(notaFiscal.getFatura().getServico())+ "\n"+
                "\n"+
                "Valores da Nota\n"+
                "Valor bruto do serviço: R$"+ notaFiscal.getFatura().getValor().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "ISS\n"+
                "Alíquota: "+ ImpostosEnum.ISS+ "\n"+
                "Valor: R$"+ notaFiscal.getValorIss().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "\n"+
                "PIS\n"+
                "Alíquota: "+ ImpostosEnum.PIS+ "\n"+
                "Valor: R$"+ notaFiscal.getValorPis().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "\n"+
                "COFINS\n"+
                "Alíquota: "+ ImpostosEnum.COFINS+ "\n"+
                "Valor: R$"+ notaFiscal.getValorCofins().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "\n"+
                "IRPJ\n"+
                "Percentual efetivo: "+ ImpostosEnum.IRPJ+ "\n"+
                "Valor: R$"+ notaFiscal.getValorIrpj().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "\n"+
                "CSLL\n"+
                "Percentual efetivo: "+ ImpostosEnum.CSLL+ "\n"+
                "Valor: R$"+ notaFiscal.getvalorCsll().setScale(2, RoundingMode.HALF_UP)+ "\n"+
                "\n"+
                "RESUMO DOS IMPOSTOS\n"+
                "Impostos                       Valor\n"+
                "ISS           "+ ImpostosEnum.ISS+ "           "+ notaFiscal.getValorIss().setScale(2, RoundingMode.HALF_UP)+ "\n"+ 
                "PIS           "+ ImpostosEnum.PIS+ "           "+ notaFiscal.getValorPis().setScale(2, RoundingMode.HALF_UP)+ "\n"+ 
                "COFINS        "+ ImpostosEnum.COFINS+ "           "+ notaFiscal.getValorCofins().setScale(2, RoundingMode.HALF_UP)+ "\n"+ 
                "IRPJ          "+ ImpostosEnum.IRPJ+ "           "+ notaFiscal.getValorIrpj().setScale(2, RoundingMode.HALF_UP)+ "\n"+ 
                "CSLL          "+ ImpostosEnum.CSLL+ "           "+ notaFiscal.getvalorCsll().setScale(2, RoundingMode.HALF_UP)+ "\n";

                return emissao;
        }
}
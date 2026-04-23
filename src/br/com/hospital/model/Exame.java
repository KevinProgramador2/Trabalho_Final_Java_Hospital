package br.com.hospital.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.hospital.model.enums.TipoExameEnum;
import br.com.hospital.model.enums.TipoServicoEnum;
import br.com.hospital.model.interfaces.Servico;

// exame foi separado de laudo para fins de facilitar
// e porque somente Laudo depende de Exame, e não vice-versa.
public class Exame implements Servico{
    private Integer id;
    private TipoExameEnum tipoExame;
    private BigDecimal custo;
    private String descricao;
    private LocalDateTime dataSolicitacao;
    private Paciente paciente;
    private Medico responsavel;
    private Laboratorio laboratorio;
    private TipoServicoEnum tipoServico;
    
    public Exame(Integer id, TipoExameEnum tipoExame, BigDecimal custo, LocalDateTime dataSolicitacao,
            Paciente paciente, Medico responsavel, Laboratorio laboratorio) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.custo = custo;
        this.dataSolicitacao = dataSolicitacao;
        this.paciente = paciente;
        this.responsavel = responsavel;
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "Exame [id=" + id + ", tipoExame=" + tipoExame + ", custo=" + custo + ", descricao=" + descricao
                + ", dataSolicitacao=" + dataSolicitacao + ", paciente=" + paciente + ", responsavel=" + responsavel
                + ", laboratorio=" + laboratorio + "]";
    }

    @Override
    public Integer getIdentificador() {
        return id;
    }

    @Override
    public TipoServicoEnum getTipoServico() {
        return tipoServico;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoExameEnum getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExameEnum tipoExame) {
        this.tipoExame = tipoExame;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Medico responsavel) {
        this.responsavel = responsavel;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

}

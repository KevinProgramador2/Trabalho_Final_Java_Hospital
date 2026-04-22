package br.com.hospital.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.hospital.model.enums.TipoExameEnum;

// exame foi separado de laudo para fins de facilitar
// e porque somente Laudo depende de Exame, e não vice-versa.
public class Exame {
    private Integer id;
    private TipoExameEnum tipo;
    private BigDecimal custo;
    private String descricao;
    private LocalDateTime dataSolicitacao;
    private Paciente paciente;
    private Medico responsavel;
    private Laboratorio laboratorio;
    
    public Exame(Integer id, TipoExameEnum tipo, BigDecimal custo, LocalDateTime dataSolicitacao, Paciente paciente,
            Medico responsavel, Laboratorio laboratorio) {
        this.id = id;
        this.tipo = tipo;
        this.custo = custo;
        this.dataSolicitacao = dataSolicitacao;
        this.paciente = paciente;
        this.responsavel = responsavel;
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "Exame [id=" + id + ", tipo=" + tipo + ", custo=" + custo + ", descricao=" + descricao
                + ", dataSolicitacao=" + dataSolicitacao + ", paciente=" + paciente + ", laboratorio=" + laboratorio
                + ", responsavel=" + responsavel + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoExameEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoExameEnum tipo) {
        this.tipo = tipo;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Medico getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Medico responsavel) {
        this.responsavel = responsavel;
    }

}

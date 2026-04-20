package br.com.hospital.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// exame foi separado de laudo para fins de facilitar
// e porque somente Laudo depende de Exame, e não vice-versa.
public class Exame {
    private Integer id;
    private Paciente paciente;
    private Laboratorio laboratorio;
    private LocalDateTime dataSolicitacao;
    private Medico solicitante;
    private Medico medicoResponsavel;
    private TipoExame tipo;
    private BigDecimal custo;
    private Laudo laudo;
    
    

    public Exame(Integer id, Paciente paciente, Laboratorio laboratorio, LocalDateTime dataSolicitacao,
            Medico solicitante, Medico medicoResponsavel, TipoExame tipo, BigDecimal custo, Laudo laudo) {
        this.id = id;
        this.paciente = paciente;
        this.laboratorio = laboratorio;
        this.dataSolicitacao = dataSolicitacao;
        this.solicitante = solicitante;
        this.medicoResponsavel = medicoResponsavel;
        this.tipo = tipo;
        this.custo = custo;
        this.laudo = laudo;
    }

    @Override
    public String toString() {
        return "Exame [id=" + id + ", paciente=" + paciente + ", laboratorio=" + laboratorio + ", dataSolicitacao=" + dataSolicitacao
                + ", solicitante=" + solicitante + ", tipo=" + tipo + ", custo=" + custo + "]";
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

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Medico getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Medico solicitante) {
        this.solicitante = solicitante;
    }

    public TipoExame getTipo() {
        return tipo;
    }

    public void setTipo(TipoExame tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void adicionarLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

}

package br.com.hospital.model;

import java.time.LocalDate;

// exame foi separado de laudo para fins de facilitar
// e porque somente Laudo depende de Exame, e não vice-versa.
public class Exame {
    private Integer id;
    private Paciente paciente;
    private Laboratorio laboratorio;
    private LocalDate dataSolicitacao;
    private Medico solicitante;
    private String tipo;
    private Double custo;
    private Laudo laudo;
    
    public Exame(Integer id, Paciente paciente, Laboratorio laboratorio, LocalDate dataSolicitacao, Medico solicitante, String tipo,
            Double custo) {
        this.id= id;
        this.paciente = paciente;
        this.laboratorio = laboratorio;
        this.dataSolicitacao = dataSolicitacao;
        this.solicitante = solicitante;
        this.tipo = tipo;
        this.custo = custo;
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

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Medico getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Medico solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void adicionarLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

}

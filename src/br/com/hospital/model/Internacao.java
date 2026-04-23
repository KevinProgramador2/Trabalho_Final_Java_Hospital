package br.com.hospital.model;

import java.time.LocalDate;

import br.com.hospital.model.enums.TipoServicoEnum;
import br.com.hospital.model.interfaces.Servico;
import br.com.hospital.model.interfaces.Cliente;

public class Internacao implements Servico {
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Paciente paciente;
    private Cliente cliente;
    private Leito leito;
    private TipoServicoEnum tipoServico;

    public Internacao(Integer id, LocalDate dataEntrada, Paciente paciente, Leito leito) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.paciente = paciente;
        leito.ocupar();
        this.leito = leito;
    }

    public Internacao(Integer id, LocalDate dataEntrada, Cliente cliente, Leito leito) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.cliente = cliente;
        leito.ocupar();
        this.leito = leito;
    }

    @Override
    public String toString() {
        if (dataSaida != null)
            return "Internacao [id=" + id + ", paciente=" + paciente + ", leito=" + leito + ", dataEntrada="
                    + dataEntrada + ", dataSaida="
                    + dataSaida + "]";
        return "Internacao [id=" + id + ", paciente=" + paciente + ", leito=" + leito + ", dataEntrada="
                + dataEntrada + "]";
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Leito getLeito() {
        return leito;
    }

    public void setLeito(Leito leito) {
        this.leito = leito;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void darAlta(LocalDate data) {
        this.leito.liberar();
        this.dataSaida = data;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

}

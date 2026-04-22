package br.com.hospital.model;

import java.time.LocalDate;

public class Internacao {
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Paciente paciente;
    private Leito leito;
    
    public Internacao(Integer id, LocalDate dataEntrada, Paciente paciente, Leito leito) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.paciente = paciente;
        leito.ocupar();
        this.leito = leito;
    }

    @Override
    public String toString() {
        if(dataSaida!= null)
            return "Internacao [id=" + id + ", paciente=" + paciente + ", leito=" + leito + ", dataEntrada=" + dataEntrada + ", dataSaida="
                    + dataSaida + "]";
        return "Internacao [id=" + id + ", paciente=" + paciente + ", leito=" + leito + ", dataEntrada=" 
                    + dataEntrada + "]";
    }

    public Integer getId() {
        return id;
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
        this.dataSaida= data;
    }

}

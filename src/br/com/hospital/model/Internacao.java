package br.com.hospital.model;

import java.time.LocalDate;

public class Internacao {
    private Integer id;
    private Paciente paciente;
    private Leito leito;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    
    public Internacao(Integer id, Paciente paciente, Leito leito, LocalDate dataEntrada) {
        this.id= id;
        this.paciente = paciente;
        this.leito = leito;
        this.leito.ocupar();
        this.dataEntrada = dataEntrada;
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

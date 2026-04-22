package br.com.hospital.model;

import java.time.LocalDate;

public class Prescricao {
    private Integer id;
    private Atendimento atendimento;
    private Medicamento medicamento;
    private LocalDate dataPrescricao;
    private String dosagem;
    private Integer quantidade;

    public Prescricao(Integer id, Atendimento atendimento, Medicamento medicamento, LocalDate dataPrescricao, String dosagem,
            Integer quantidade) {
        this.id = id;
        this.atendimento = atendimento;
        this.medicamento = medicamento;
        this.dataPrescricao = dataPrescricao;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
        atendimento.prescreverMedicamento(this);
    }

    @Override
    public String toString() {
        return "Prescricao [id=" + id + ", atendimento=" + atendimento + ", medicamento=" + medicamento + ", dataPrescricao="
                + dataPrescricao + ", dosagem=" + dosagem + ", quantidade=" + quantidade + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}

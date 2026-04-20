package br.com.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataAtendimento;
    private TipoAtendimento tipo;
    private StatusAtendimento status;
    private String observacao;
    private List<Medicamentos> medicamentos;
    
    public Atendimento(Integer id, Paciente paciente, Medico medico, LocalDate dataAtendimento, TipoAtendimento tipo,
            StatusAtendimento status, String observacao) {
        this.id= id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAtendimento = dataAtendimento;
        this.tipo = tipo;
        this.status = status;
        this.observacao = observacao;
        this.medicamentos= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Atendimento [id=" + id + ", paciente=" + paciente.getNome() + ", medico=" + medico.getNome() + ", dataAtendimento=" + dataAtendimento
        + ", tipo=" + tipo + ", status=" + status + ", observacao=" + observacao + "]";
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public TipoAtendimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtendimento tipo) {
        this.tipo = tipo;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void prescreverMedicamento(Medicamentos medicamento) {
        this.medicamentos.add(medicamento);
    }


}

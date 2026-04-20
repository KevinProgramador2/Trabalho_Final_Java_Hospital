package br.com.hospital.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataAtendimento;
    private TipoAtendimento tipo;
    private StatusAtendimento status;
    private String observacao;
    private List<Medicamento> medicamentos;
    
    public Atendimento(Integer id, Paciente paciente, Medico medico, LocalDateTime dataAtendimento, TipoAtendimento tipo,
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

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
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

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void prescreverMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }


}

package br.com.hospital.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.hospital.model.enums.StatusAtendimentoEnum;
import br.com.hospital.model.enums.TipoAtendimentoEnum;
import br.com.hospital.model.enums.TipoServicoEnum;
import br.com.hospital.model.interfaces.Cliente;
import br.com.hospital.model.interfaces.Servico;

public class Atendimento implements Servico{
    private Integer id;
    private LocalDateTime dataAtendimento;
    private TipoAtendimentoEnum tipoAtendimento;
    private TipoServicoEnum tipoServico;
    private StatusAtendimentoEnum status;
    private String observacao;
    private Cliente paciente;
    private Medico medico;
    private List<Prescricao> medicamentos= new ArrayList<>();

    public Atendimento(Integer id, LocalDateTime dataAtendimento, TipoAtendimentoEnum tipoAtendimento,
            StatusAtendimentoEnum status, Cliente paciente, Medico medico) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.tipoAtendimento = tipoAtendimento;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Atendimento [id=" + id + ", dataAtendimento=" + dataAtendimento + ", tipoAtendimento=" + tipoAtendimento
                + ", status=" + status + ", observacao=" + observacao + ", paciente=" + paciente + ", medico=" + medico
                + ", " + medicamentos + "]";
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

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public TipoAtendimentoEnum getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimentoEnum tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

    public StatusAtendimentoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimentoEnum status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getPaciente() {
        return paciente;
    }

    public void setPaciente(Cliente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Prescricao> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Prescricao> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void prescreverMedicamento(Prescricao medicamento) {
        this.medicamentos.add(medicamento);
    }

}
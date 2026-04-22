package br.com.hospital.model;

import java.time.LocalDate;

public class Credenciamento {
    private Integer id;
    private LocalDate dataCredenciamento;
    private Hospital hospital;
    private PlanoSaude planoSaude;

    public Credenciamento(Integer id, LocalDate dataCredenciamento, Hospital hospital, PlanoSaude planoSaude) {
        this.id = id;
        this.dataCredenciamento = dataCredenciamento;
        this.hospital = hospital;
        this.planoSaude = planoSaude;
    }

    @Override
    public String toString() {
        return "Credenciamento [id=" + id + ", dataCredenciamento=" + dataCredenciamento + ", hospital=" + hospital
                + ", planoSaude=" + planoSaude + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public LocalDate getDataCredenciamento() {
        return dataCredenciamento;
    }

    public void setDataCredenciamento(LocalDate dataCredenciamento) {
        this.dataCredenciamento = dataCredenciamento;
    }

}

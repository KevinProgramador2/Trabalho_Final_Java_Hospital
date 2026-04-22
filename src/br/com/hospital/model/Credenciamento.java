package br.com.hospital.model;

import java.time.LocalDate;

public class Credenciamento {
    private Integer id;
    private Hospital hospital;
    private PlanoSaude planoSaude;
    private LocalDate dataCredenciamento;
    
    public Credenciamento(Integer id, Hospital hospital, PlanoSaude planoSaude, LocalDate dataCredenciamento) {
        this.id = id;
        this.hospital = hospital;
        this.planoSaude = planoSaude;
        this.dataCredenciamento = dataCredenciamento;
        hospital.addCredenciamento(this);
        planoSaude.addCredenciamento(this);
    }

    @Override
    public String toString() {
        return "Credenciamento [id=" + id + ", hospital=" + hospital + ", planoSaude=" + planoSaude
                + ", dataCredenciamento=" + dataCredenciamento + "]";
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

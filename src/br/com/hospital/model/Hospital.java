package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    protected Integer id;
    protected String cpnj;
    protected List<Ala> alas;
    protected List<PlanoSaude> planosSaude;
    
    public Hospital(Integer id, String cpnj) {
        this.id= id;
        this.cpnj = cpnj;
        this.alas = new ArrayList<>();
        this.planosSaude = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Hospital [id=" + id + ", cpnj=" + cpnj + ", alas=" + alas + ", planosSaude=" + planosSaude + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public List<Ala> getAlas() {
        return alas;
    }

    public void setAlas(List<Ala> alas) {
        this.alas = alas;
    }

    public List<PlanoSaude> getPlanosSaude() {
        return planosSaude;
    }

    public void setPlanosSaude(List<PlanoSaude> planosSaude) {
        this.planosSaude = planosSaude;
    }

    public void adicionarAla(Ala ala) {
        this.alas.add(ala);
    }

    public void credenciarPlano(PlanoSaude planoSaude) {
        this.planosSaude.add(planoSaude);
    }

}

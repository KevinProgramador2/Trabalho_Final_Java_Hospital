package br.com.hospital.model;

public class Hospital {
    protected String cpnj;
    protected String alas;
    protected String planoDeSaude;

    public Hospital(String cpnj, String alas, String planoDeSaude) {
        this.cpnj = cpnj;
        this.alas = alas;
        this.planoDeSaude = planoDeSaude;
    }

    @Override
    public String toString() {
        return "Hospital [cpnj=" + cpnj + ", alas=" + alas + ", planoDeSaude=" + planoDeSaude + "]";
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getAlas() {
        return alas;
    }

    public void setAlas(String alas) {
        this.alas = alas;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

}

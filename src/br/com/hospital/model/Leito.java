package br.com.hospital.model;

import br.com.hospital.model.enums.StatusLeitoEnum;

public class Leito {
    private Integer id;
    private String identificador;
    private StatusLeitoEnum status;
    private Ala ala;

    public Leito(Integer id, String identificador, StatusLeitoEnum status, Ala ala) {
        this.id = id;
        this.identificador = identificador;
        this.status = status;
        this.ala = ala;
    }

    @Override
    public String toString() {
        return "Leito [id=" + id + ", identificador=" + identificador + ", status=" + status + ", ala=" + ala + "]";
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public StatusLeitoEnum getStatus() {
        return status;
    }
    
    public void setStatus(StatusLeitoEnum status) {
        this.status = status;
    }
    
    public Ala getAla() {
        return ala;
    }
    
    public void setAla(Ala ala) {
        this.ala = ala;
    }
    
    public void ocupar() {
        if(this.status== StatusLeitoEnum.LIVRE)
            this.status= StatusLeitoEnum.OCUPADO;
        else
            throw new IllegalStateException("O leito não está livre.");
    }
    
    public void liberar() {
        if(this.status== StatusLeitoEnum.OCUPADO || this.status== StatusLeitoEnum.MANUTENCAO)
            this.status= StatusLeitoEnum.LIVRE;
        else
            throw new IllegalStateException("O leito não está ocupado.");
    }
    
    public void manutencao() {
        this.status= StatusLeitoEnum.MANUTENCAO;
    }
    
}

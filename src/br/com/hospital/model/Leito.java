package br.com.hospital.model;

public class Leito {
    private Integer id;
    private StatusLeito status;
    
    public Leito(Integer id, StatusLeito status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public StatusLeito getStatus() {
        return status;
    }

    public void ocupar() {
        if(this.status== StatusLeito.LIVRE)
            this.status= StatusLeito.OCUPADO;
        else
            throw new IllegalStateException("O leito não está livre.");
    }

    public void liberar() {
        if(this.status== StatusLeito.OCUPADO || this.status== StatusLeito.MANUTENCAO)
            this.status= StatusLeito.LIVRE;
        else
            throw new IllegalStateException("O leito não está ocupado.");
    }

    public void manutencao() {
        this.status= StatusLeito.MANUTENCAO;
    }

}

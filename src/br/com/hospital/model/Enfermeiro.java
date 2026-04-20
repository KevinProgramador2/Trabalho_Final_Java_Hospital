package br.com.hospital.model;

import java.time.LocalDate;

public class Enfermeiro extends Pessoa {
    private Integer id;
    private String cre;
    private Turno turno;
    private Ala ala;
    private Enfermeiro chefe= null;

    // construtor para enfermeiras subordinadas.
    public Enfermeiro(Integer id, String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento, String cre,
            Turno turno, Ala ala, Enfermeiro chefe) {
        super(nome, cpf, telefone, endereco, dataNascimento);
        this.id= id;
        this.cre = cre;
        this.turno = turno;
        this.ala = ala;
        this.chefe = chefe;
    }

    // construtor usado para enfermeiras-chefe.
    public Enfermeiro(Integer id, String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento, String cre,
            Turno turno, Ala ala) {
        super(nome, cpf, telefone, endereco, dataNascimento);
        this.id= id;
        this.cre = cre;
        this.turno = turno;
        this.ala = ala;
    }

    // o if verifica se chefe está nulo (o que indica ser uma enfermeira-chefe, caso contrário, é enfermeira subordinada).
    @Override
    public String toString() {
        if(chefe== null)
            return "Enfermeiro [id=" + id + ", nome=" + super.getNome() + ", cre=" + cre + ", turno=" + turno + ", ala=" + ala.getTipo() 
                + "]";
        return "Enfermeiro [id=" + id + ", nome=" + super.getNome() + ", cre=" + cre + ", turno=" + turno + ", ala=" + ala.getTipo() 
        + ", chefe=" + chefe.getNome() + "]";
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Ala getAla() {
        return ala;
    }

    public void setAla(Ala ala) {
        this.ala = ala;
    }

    public Enfermeiro getChefe() {
        return chefe;
    }

    public void setChefe(Enfermeiro chefe) {
        this.chefe = chefe;
    }


}

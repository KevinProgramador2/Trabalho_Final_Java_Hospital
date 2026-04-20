package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Ala {
    private Integer id;
    private String tipo;
    private Enfermeiro responsavel;
    private List<Leito> leitos;
    private Integer leitosDisponiveis;

    public Ala(Integer id, String tipo, Enfermeiro responsavel, Integer quantidadeLeitos) {
        this.id = id;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.leitos = new ArrayList<>();
        this.leitosDisponiveis = quantidadeLeitos;
    }

    @Override
    public String toString() {
        return "Ala [id=" + id + ", tipo=" + tipo + ", responsavel=" + responsavel + ", leitosDisponiveis="
                + leitosDisponiveis(leitos) + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Enfermeiro getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Enfermeiro responsavel) {
        this.responsavel = responsavel;
    }

    public List<Leito> getLeitos() {
        return leitos;
    }

    public void setLeitos(List<Leito> leitos) {
        this.leitos = leitos;
    }

    public Integer getLeitosDisponiveis() {
        return leitosDisponiveis;
    }

    public void setLeitosDisponiveis(Integer leitosDisponiveis) {
        this.leitosDisponiveis = leitosDisponiveis;
    }

    public void adicionarLeito(Leito leito) {
        this.leitos.add(leito);
    }

    public Integer leitosDisponiveis(List<Leito> leitos) {
        leitosDisponiveis = 0;
        for (Leito leito : leitos) {
            if (leito.getStatus() == StatusLeito.LIVRE)
                this.leitosDisponiveis++;
        }

        return leitosDisponiveis;
    }

}

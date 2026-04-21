package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Ala {
    private Integer id;
    private TipoAla tipo;
    private Enfermeiro responsavel;
    private List<Leito> leitos;

    public Ala(Integer id, TipoAla tipo, Enfermeiro responsavel) {
        this.id = id;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.leitos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Ala [id=" + id + ", tipo=" + tipo + ", responsavel=" + responsavel + ", leitosDisponiveis="
                + getLeitosDisponiveis() + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoAla getTipo() {
        return tipo;
    }

    public void setTipo(TipoAla tipo) {
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

    public void adicionarLeito(Leito leito) {
        this.leitos.add(leito);
    }

    public Integer getLeitosDisponiveis() {
        int count = 0;
        for (Leito leito : leitos) {
            if (leito.getStatus() == StatusLeito.LIVRE) {
                count++;
            }
        }
        return count;
    }

}

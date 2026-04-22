package br.com.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanoSaude implements Cliente {
    private Integer id;
    private String nome;
    private String telefone;
    private CoberturaPlano cobertura;
    private List<Credenciamento> credenciamentos = new ArrayList<>();

    public PlanoSaude(Integer id, String nome, String telefone, CoberturaPlano cobertura) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cobertura = cobertura;
    }

    @Override
    public String toString() {
        return "PlanoSaude [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cobertura=" + cobertura + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CoberturaPlano getCobertura() {
        return cobertura;
    }

    public void setCobertura(CoberturaPlano cobertura) {
        this.cobertura = cobertura;
    }

    public List<Credenciamento> getCredenciamentos() {
        return credenciamentos;
    }

    public void setCredenciamentos(List<Credenciamento> credenciamentos) {
        this.credenciamentos = credenciamentos;
    }

    @Override
    public Integer getIdentificador() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void addCredenciamento(Credenciamento credenciamento) {
        credenciamentos.add(credenciamento);
    }

}
